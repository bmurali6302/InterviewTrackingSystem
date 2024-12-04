package com.interviewscheduleservice.client;

import com.interviewscheduleservice.dto.CandidateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "candidateservice",url="http://localhost:8090")
public interface CandidateService {
    @GetMapping("api/v1/candidate/viewcandidatebyid/{candidateId}")
    public ResponseEntity<CandidateDto> viewCandidateById(@PathVariable Long candidateId);
}
