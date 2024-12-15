package com.volthread.survey.service;

import com.volthread.survey.entity.Survey;
import com.volthread.survey.repo.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey getSurveyById(Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found!"));
    }

    public Survey updateSurvey(Long id, Survey updated) {
        Survey existing = getSurveyById(id);

        existing.setParticipantName(updated.getParticipantName());
        existing.setParticipantSurname(updated.getParticipantSurname());
        existing.setGender(updated.getGender());
        existing.setBirthDate(updated.getBirthDate());
        existing.setSurveyorName(updated.getSurveyorName());
        existing.setSurveyorSurname(updated.getSurveyorSurname());
        existing.setSurveyType(updated.getSurveyType());

        if ("1".equals(updated.getSurveyType())) {
            existing.setTeam(updated.getTeam());
            existing.setDescription(updated.getDescription());
            existing.setHappinessScore(null);
            existing.setHappyThings(null);
            existing.setUnhappyThings(null);
            existing.setAdditionalDescription(null);
        } else if ("2".equals(updated.getSurveyType())) {
            existing.setHappinessScore(updated.getHappinessScore());
            existing.setHappyThings(updated.getHappyThings());
            existing.setUnhappyThings(updated.getUnhappyThings());
            existing.setAdditionalDescription(updated.getAdditionalDescription());
            existing.setTeam(null);
            existing.setDescription(null);
        }

        return surveyRepository.save(existing);
    }

    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }

    public double getAverageHappinessScore() {
        List<Survey> memnuniyetAnketleri = surveyRepository.findBySurveyType("2");
        return memnuniyetAnketleri.stream()
                .filter(s -> s.getHappinessScore() != null)
                .mapToInt(Survey::getHappinessScore)
                .average()
                .orElse(0.0);
    }

    public Map<String, Double> getTeamDistribution() {
        List<Survey> futbolAnketleri = surveyRepository.findBySurveyType("1");
        if (futbolAnketleri.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, Long> countByTeam = futbolAnketleri.stream()
                .filter(s -> s.getTeam() != null && !s.getTeam().isEmpty())
                .collect(Collectors.groupingBy(Survey::getTeam, Collectors.counting()));

        long total = futbolAnketleri.size();
        Map<String, Double> percentages = new HashMap<>();
        for (Map.Entry<String, Long> entry : countByTeam.entrySet()) {
            percentages.put(entry.getKey(), (entry.getValue() * 100.0) / total);
        }
        return percentages;
    }

}




