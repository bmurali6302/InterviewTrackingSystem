package com.candidateservice.dto;

import lombok.Data;

@Data
public class CandidateDto {
    private Long candidateId;
    private String candidateName;
    private String email;
    private String primarySkills;
    private String secondarySkills;
    private String qualification;
    private String designation;
    private Integer noticePeriod;
    private String location;
   // private String password;

   // private String candidateRole;

}
