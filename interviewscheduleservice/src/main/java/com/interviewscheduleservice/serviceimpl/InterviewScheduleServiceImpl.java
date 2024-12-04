package com.interviewscheduleservice.serviceimpl;

import com.interviewscheduleservice.client.CandidateService;
import com.interviewscheduleservice.dto.CandidateDto;
import com.interviewscheduleservice.dto.InterviewScheduleDto;
import com.interviewscheduleservice.entity.InterviewSchedule;
import com.interviewscheduleservice.exception.CandidateIdNotFound;
import com.interviewscheduleservice.exception.InterviewNotFoundException;
import com.interviewscheduleservice.repository.InterviewScheduleRepository;
import com.interviewscheduleservice.service.InterviewScheduleService;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Service
public class InterviewScheduleServiceImpl implements InterviewScheduleService {
    private InterviewScheduleRepository interviewScheduleRepository;
    private CandidateService candidateService;

    public InterviewScheduleServiceImpl(InterviewScheduleRepository interviewScheduleRepository, CandidateService candidateService) {
        this.interviewScheduleRepository = interviewScheduleRepository;
        this.candidateService = candidateService;
    }
    @Override
    public InterviewSchedule secheduleInterview(InterviewScheduleDto interviewScheduleDto) {

        try {
            ResponseEntity<CandidateDto> candidateDtoResponseEntity = candidateService.viewCandidateById(interviewScheduleDto.getCandidateId());

            InterviewSchedule interviewSchedule=new InterviewSchedule();
            interviewSchedule.setCandidateId(interviewScheduleDto.getCandidateId());
            interviewSchedule.setTechRating(interviewScheduleDto.getTechRating());
            interviewSchedule.setHrRating(interviewScheduleDto.getHrRating());
            interviewSchedule.setFinalStatus(interviewScheduleDto.getFinalStatus());
            return interviewScheduleRepository.save(interviewSchedule);
        } catch (FeignException.NotFound e) {
            throw new CandidateIdNotFound("Candidate ID not found: " + interviewScheduleDto.getCandidateId());
        }
    }
    @Override
    public String cancelInterview(long interviewScheduleId) {
        Optional<InterviewSchedule> byId = interviewScheduleRepository.findById(interviewScheduleId);
        if(byId.isPresent()) {
            interviewScheduleRepository.deleteById(interviewScheduleId);
            return "deleted successfully";
        }else{
            throw new InterviewNotFoundException("Interview id not found");
        }
    }

    @Override
    public InterviewSchedule editInterviewSchedule(long InterviewScheduleId, InterviewScheduleDto interviewScheduleDto) {
        InterviewSchedule interviewSchedule = interviewScheduleRepository.findById(InterviewScheduleId)
                .orElseThrow(() -> new InterviewNotFoundException("Interview with ID " + InterviewScheduleId + " not found"));

        // Update the fields
        interviewSchedule.setCandidateId(interviewScheduleDto.getCandidateId());  // Optional: validate candidate exists
        interviewSchedule.setTechRating(interviewScheduleDto.getTechRating());
        interviewSchedule.setHrRating(interviewScheduleDto.getHrRating());
        interviewSchedule.setFinalStatus(interviewScheduleDto.getFinalStatus());
        return interviewScheduleRepository.save(interviewSchedule);
        }

    @Override
    public List<InterviewSchedule> findAll() {
        return interviewScheduleRepository.findAll();

    }
}
