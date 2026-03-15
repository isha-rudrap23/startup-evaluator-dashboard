package com.startup.evaluator.service;

import com.startup.evaluator.model.*;
import com.startup.evaluator.repository.*;
import org.springframework.stereotype.Service;

@Service
public class StartupService {

    private final StartupRepository repository;

    public StartupService(StartupRepository repository) {
        this.repository = repository;
    }

    public EvaluationResult evaluateStartup(StartupIdea idea){

        int score = idea.getMarketSize()
                + idea.getScalability()
                + idea.getInnovation()
                + (10 - idea.getCompetition())
                + (10 - idea.getCost());

        idea.setScore(score);

        repository.save(idea);

        String recommendation;

        if(score >= 40){
            recommendation = "Strong Startup Idea";
        }
        else if(score >= 25){
            recommendation = "Moderate Potential";
        }
        else{
            recommendation = "Weak Idea";
        }

        return new EvaluationResult(
                idea.getIdeaName(),
                score,
                recommendation
        );
    }
}