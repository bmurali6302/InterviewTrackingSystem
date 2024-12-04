package com.candidateservice.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id", nullable = false)
    private Long candidateId;

    @Column(name = "candidate_name")
    private String candidateName;

    private String email;

    @Column(name = "primary_skills")
    private String primarySkills;

    @Column(name = "secondary_skills")
    private String secondarySkills;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "designation")
    private String designation;

    @Column(name = "notice_period")
    private Integer noticePeriod;

    @Column(name = "location")
    private String location;

   // private String password;

   // private String candidateRole;

//    @OneToMany(mappedBy="candidate",cascade=CascadeType.ALL)
//    private List<InterviewSchedule> interviewSchedule;
}