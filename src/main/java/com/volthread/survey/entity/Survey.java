package com.volthread.survey.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "surveys")
@Data
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surveyType;

    private String participantName;
    private String participantSurname;
    private int gender;
    private LocalDate birthDate;
    private String surveyorName;
    private String surveyorSurname;

    private String team;
    private String description;

    private Integer happinessScore;
    private String happyThings;
    private String unhappyThings;
    private String additionalDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantSurname() {
        return participantSurname;
    }

    public void setParticipantSurname(String participantSurname) {
        this.participantSurname = participantSurname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSurveyorName() {
        return surveyorName;
    }

    public void setSurveyorName(String surveyorName) {
        this.surveyorName = surveyorName;
    }

    public String getSurveyorSurname() {
        return surveyorSurname;
    }

    public void setSurveyorSurname(String surveyorSurname) {
        this.surveyorSurname = surveyorSurname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHappinessScore() {
        return happinessScore;
    }

    public void setHappinessScore(Integer happinessScore) {
        this.happinessScore = happinessScore;
    }

    public String getHappyThings() {
        return happyThings;
    }

    public void setHappyThings(String happyThings) {
        this.happyThings = happyThings;
    }

    public String getUnhappyThings() {
        return unhappyThings;
    }

    public void setUnhappyThings(String unhappyThings) {
        this.unhappyThings = unhappyThings;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }
}

