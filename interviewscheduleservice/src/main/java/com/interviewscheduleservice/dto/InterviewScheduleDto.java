package com.interviewscheduleservice.dto;

public class InterviewScheduleDto {


    private long interviewScheduleId;
    private long candidateId;
    private int techRating;
    private int hrRating;

    public long getInterviewScheduleId() {
        return interviewScheduleId;
    }

    public void setInterviewScheduleId(long interviewScheduleId) {
        this.interviewScheduleId = interviewScheduleId;
    }

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
    }

    public int getTechRating() {
        return techRating;
    }

    public void setTechRating(int techRating) {
        this.techRating = techRating;
    }

    public int getHrRating() {
        return hrRating;
    }

    public void setHrRating(int hrRating) {
        this.hrRating = hrRating;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    private String finalStatus;

}
