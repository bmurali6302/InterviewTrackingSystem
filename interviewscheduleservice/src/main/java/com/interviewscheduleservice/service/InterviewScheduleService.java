package com.interviewscheduleservice.service;

import com.interviewscheduleservice.dto.InterviewScheduleDto;
import com.interviewscheduleservice.entity.InterviewSchedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InterviewScheduleService {
    public InterviewSchedule secheduleInterview(InterviewScheduleDto interviewScheduleDto);
    public String cancelInterview(long interviewScheduleId);
    public InterviewSchedule editInterviewSchedule(long interviewScheduleId,InterviewScheduleDto interviewScheduleDto);
    public List<InterviewSchedule> findAll();
}
