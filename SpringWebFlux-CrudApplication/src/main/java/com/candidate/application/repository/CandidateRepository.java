package com.candidate.application.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.candidate.application.entity.Candidate;

@Repository
public interface CandidateRepository extends ReactiveCrudRepository<Candidate, String> {
	
}
