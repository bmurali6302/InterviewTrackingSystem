package com.interviewscheduleservice.controller;

import com.interviewscheduleservice.client.CandidateService;
import com.interviewscheduleservice.dto.CandidateDto;
import com.interviewscheduleservice.dto.InterviewScheduleDto;
import com.interviewscheduleservice.entity.InterviewSchedule;
import com.interviewscheduleservice.serviceimpl.InterviewScheduleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interviewschedule")
public class InterviewScheduleController {
    private CandidateService candidateService;
    private InterviewScheduleServiceImpl interviewScheduleService;

    public InterviewScheduleController(CandidateService candidateService, InterviewScheduleServiceImpl interviewScheduleService) {
        this.candidateService = candidateService;
        this.interviewScheduleService = interviewScheduleService;
    }

    @PostMapping("/schedule")
    public ResponseEntity<InterviewSchedule> secheduleInterview(@RequestBody InterviewScheduleDto interviewScheduleDto){
        InterviewSchedule interviewSchedule1 = interviewScheduleService.secheduleInterview(interviewScheduleDto);
        return new ResponseEntity<>(interviewSchedule1,HttpStatus.OK);
    }
    @PutMapping("/updateinterviewschedule/{interviewScheduleId}")
    public ResponseEntity<InterviewSchedule> updateInterviewSchedule(@PathVariable long interviewScheduleId,@RequestBody InterviewScheduleDto interviewScheduleDto){
        InterviewSchedule interviewSchedule1 = interviewScheduleService.editInterviewSchedule(interviewScheduleId, interviewScheduleDto);
        return new ResponseEntity<>(interviewSchedule1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{interviewScheduleId}")
    public ResponseEntity<String> deleteInterviewSchedule(@PathVariable long interviewScheduleId){
        String s = interviewScheduleService.cancelInterview(interviewScheduleId);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
    @GetMapping("/viewall")
    public ResponseEntity<List<InterviewSchedule>> findAll(){
        List<InterviewSchedule> all = interviewScheduleService.findAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
    @GetMapping("api/v1/candidate/viewcandidatebyid/{candidateId}")
    public ResponseEntity<CandidateDto> viewCandidateById(@PathVariable Long candidateId){
        return candidateService.viewCandidateById(candidateId);
    }
}