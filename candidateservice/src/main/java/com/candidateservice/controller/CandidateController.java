package com.candidateservice.controller;
import com.candidateservice.entity.Candidate;
import com.candidateservice.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/candidate")
public class CandidateController {
    private CandidateService candidateService;
    public CandidateController(CandidateService candidateService) {

        this.candidateService = candidateService;
    }
    @PostMapping("/addcandidate")
    public ResponseEntity<String> addCandidate(@RequestBody Candidate candidate){
        String s = candidateService.addCandidate(candidate);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }
    @GetMapping("/allcandidate")
    public ResponseEntity<List<Candidate>> viewAllCandidate(){
        List<Candidate> candidates = candidateService.viewAllCandidate();
        return new ResponseEntity<>(candidates,HttpStatus.OK);
    }
    @PutMapping("/updatecandidate/{candidateId}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long candidateId,@RequestBody Candidate candidate){
        Candidate candidate1 = candidateService.updateCandidate(candidateId, candidate);
        return new ResponseEntity<>(candidate1,HttpStatus.OK);
    }
    @DeleteMapping("/deletecandidate/{candidateId}")
    public ResponseEntity<String> deleteCandidate(@PathVariable Long candidateId){
        String s = candidateService.deleteCandidate(candidateId);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
    @GetMapping("/viewcandidatebyid/{candidateId}")
    public ResponseEntity<Candidate> viewCandidateById(@PathVariable Long candidateId){
        Candidate candidate = candidateService.viewCandidateById(candidateId);
        return new ResponseEntity<>(candidate,HttpStatus.OK);
    }


//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
//        boolean status = candidateService.verifyLogin(loginDto);
//        if (status) {
//            return new ResponseEntity<>("user signed in ", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("invalid credentials", HttpStatus.UNAUTHORIZED);
//    }
}