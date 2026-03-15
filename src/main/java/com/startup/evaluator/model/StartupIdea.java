package com.startup.evaluator.model;

import jakarta.persistence.*;

@Entity
public class StartupIdea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ideaName;
    private int marketSize;
    private int competition;
    private int cost;
    private int scalability;
    private int innovation;
    private int score;

    public StartupIdea(){}

    public Long getId() { return id; }

    public String getIdeaName() { return ideaName; }
    public void setIdeaName(String ideaName) { this.ideaName = ideaName; }

    public int getMarketSize() { return marketSize; }
    public void setMarketSize(int marketSize) { this.marketSize = marketSize; }

    public int getCompetition() { return competition; }
    public void setCompetition(int competition) { this.competition = competition; }

    public int getCost() { return cost; }
    public void setCost(int cost) { this.cost = cost; }

    public int getScalability() { return scalability; }
    public void setScalability(int scalability) { this.scalability = scalability; }

    public int getInnovation() { return innovation; }
    public void setInnovation(int innovation) { this.innovation = innovation; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}