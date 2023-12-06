package com.candidate.application.service;


import com.candidate.application.dto.CandidateDTO;
import com.candidate.application.entity.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CandidateService {
    Mono<CandidateDTO> saveCandidate(CandidateDTO candidateDto);

    Mono<CandidateDTO> getCandidate(String candidateId);

    Flux<CandidateDTO> getAllCandidates();
 
    Mono<CandidateDTO> updateCandidate(CandidateDTO candidateDto, String candidateId);

    Mono<Void> deleteCandidate(String candidateId);
    
    
}