package com.candidateservice.service;
import com.candidateservice.entity.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CandidateService {
    public String addCandidate(Candidate candidate);
    public List<Candidate> viewAllCandidate();
    public Candidate updateCandidate(Long candidateId,Candidate candidate);
    public String deleteCandidate(Long candidateId);

    public Candidate viewCandidateById(Long candidateId);
   // public boolean verifyLogin(LoginDto loginDto);
}
