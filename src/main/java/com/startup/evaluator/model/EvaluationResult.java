package com.startup.evaluator.model;

public class EvaluationResult {

    private String ideaName;
    private int score;
    private String recommendation;

    public EvaluationResult(String ideaName, int score, String recommendation) {
        this.ideaName = ideaName;
        this.score = score;
        this.recommendation = recommendation;
    }

    public String getIdeaName() { return ideaName; }
    public int getScore() { return score; }
    public String getRecommendation() { return recommendation; }
}