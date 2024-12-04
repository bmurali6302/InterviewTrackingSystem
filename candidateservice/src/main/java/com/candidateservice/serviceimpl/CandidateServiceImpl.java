package com.candidateservice.serviceimpl;
import com.candidateservice.entity.Candidate;
import com.candidateservice.exception.CandidateAlreadyRegistred;
import com.candidateservice.exception.CandidateIdNotFound;
import com.candidateservice.repository.CandidateRepository;
import com.candidateservice.service.CandidateService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CandidateServiceImpl implements CandidateService {
    private CandidateRepository candidateRepository;
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    @Override
    public String addCandidate(Candidate candidate) {
        Candidate byemail = candidateRepository.findByEmail(candidate.getEmail());
        if(byemail!=null){
           throw new CandidateAlreadyRegistred("Candidate already exist");
        }
        Candidate save = candidateRepository.save(candidate);
        return "Candidate Registered Successfully";
    }
    @Override
    public List<Candidate> viewAllCandidate() {
        List<Candidate> all = candidateRepository.findAll();
        return all;
    }
    @Override
    public Candidate updateCandidate(Long candidateId,Candidate candidate) {
        Optional<Candidate> byId = candidateRepository.findById(candidate.getCandidateId());
        if(byId.isPresent()){
            Candidate candidate1 = byId.get();
            candidate1.setCandidateName(candidate.getCandidateName());
            candidate1.setEmail(candidate.getEmail());
            candidate1.setPrimarySkills(candidate.getPrimarySkills());
            candidate1.setSecondarySkills(candidate.getSecondarySkills());
            candidate1.setQualification(candidate.getQualification());
            candidate1.setDesignation(candidate.getDesignation());
            candidate1.setNoticePeriod(candidate.getNoticePeriod());
            candidate1.setLocation(candidate.getLocation());
            return candidate1;
        }else {
            throw new CandidateIdNotFound("CandidateIdNotFound");
        }
    }
    @Override
    public String deleteCandidate(Long candidateId) {
        Optional<Candidate> byId = candidateRepository.findById(candidateId);
        if(byId.isPresent()){
            candidateRepository.deleteById(candidateId);
        }
            throw new CandidateIdNotFound("CandidateIdNotFound");
    }
    @Override
    public Candidate viewCandidateById(Long candidateId) {
        Optional<Candidate> byId = candidateRepository.findById(candidateId);
        if(byId.isPresent()){
            Candidate candidate = byId.get();
            return candidate;
        }else {
            throw new CandidateIdNotFound("CandidateId not found");
    }
    }

//    public boolean verifyLogin(LoginDto loginDto) {
//        Optional<Candidate> opUser = candidateRepository.findByCandidateName(loginDto.getCandidateName());
//        if (opUser.isPresent()) {
//            Candidate candidate = opUser.get();
//            boolean checkpw = BCrypt.checkpw(loginDto.getPassword(),
//                    candidate.getPassword());  //here comparing password encrypt to decrypt
//            return checkpw;
//        }
//        return false;
//    }
}