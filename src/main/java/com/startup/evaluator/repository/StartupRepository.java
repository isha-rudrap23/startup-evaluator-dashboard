package com.startup.evaluator.repository;
import java.util.*;
import com.startup.evaluator.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartupRepository extends JpaRepository<StartupIdea, Long> {
	List<StartupIdea> findTop5ByOrderByScoreDesc();
	
}