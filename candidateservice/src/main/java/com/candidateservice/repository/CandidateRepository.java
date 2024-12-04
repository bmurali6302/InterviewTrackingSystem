package com.candidateservice.repository;

import com.candidateservice.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByEmail(String email);
    Optional<Candidate> findByLocation(String location);

   // Optional<Candidate> findByCandidateName(String candidateName);

}