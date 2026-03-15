package com.startup.evaluator.controller;

import com.startup.evaluator.model.EvaluationResult;
import com.startup.evaluator.model.StartupIdea;
import com.startup.evaluator.repository.StartupRepository;
import com.startup.evaluator.service.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StartupController {

    private final StartupService service;
    private final StartupRepository repository;

    public StartupController(StartupService service, StartupRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @DeleteMapping("/startups/{id}")
    public ResponseEntity<String> deleteStartup(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/evaluate")
    public EvaluationResult evaluate(@RequestBody StartupIdea idea){
        return service.evaluateStartup(idea);
    }

    @GetMapping("/startups")
    public List<StartupIdea> getAllStartups(){
        return repository.findAll();
    }
    @GetMapping("/top-startups")
    public List<StartupIdea> getTopStartups(){
        return repository.findTop5ByOrderByScoreDesc();
    }
     
     @PutMapping("/startups/{id}")
     public StartupIdea updateStartup(@PathVariable Long id, @RequestBody StartupIdea idea){

     StartupIdea existing = repository.findById(id).orElseThrow();

     existing.setIdeaName(idea.getIdeaName());
     existing.setMarketSize(idea.getMarketSize());
     existing.setCompetition(idea.getCompetition());
     existing.setCost(idea.getCost());
     existing.setScalability(idea.getScalability());
     existing.setInnovation(idea.getInnovation());

     int score = idea.getMarketSize()
             + idea.getScalability()
             + idea.getInnovation()
             + (10 - idea.getCompetition())
             + (10 - idea.getCost());

     existing.setScore(score);

     return repository.save(existing);

     }

}