package com.interviewscheduleservice.repository;

import com.interviewscheduleservice.entity.InterviewSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewScheduleRepository extends JpaRepository<InterviewSchedule,Long> {
}
