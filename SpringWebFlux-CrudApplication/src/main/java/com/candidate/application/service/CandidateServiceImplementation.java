package com.candidate.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidate.application.dto.CandidateDTO;
import com.candidate.application.entity.Candidate;
import com.candidate.application.repository.CandidateRepository;
import com.candidate.modelmapper.CandidateModelMapper;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CandidateServiceImplementation implements CandidateService {

	private final CandidateRepository candidateRepository;
	
    @Override
    public Mono<CandidateDTO> saveCandidate(CandidateDTO candidateDto) {
        Candidate candidate = CandidateModelMapper.mapToCandidate(candidateDto);
        Mono<Candidate> savedEmployee = candidateRepository.save(candidate);
        return savedEmployee
                .map((candidateEntity) -> CandidateModelMapper.mapToCandidateDto(candidateEntity));
    }

    @Override
    public Mono<CandidateDTO> getCandidate(String candidateId) {
        Mono<Candidate> candidateMono = candidateRepository.findById(candidateId);
        return candidateMono.map((candidate -> CandidateModelMapper.mapToCandidateDto(candidate)));
    }

    @Override
    public Flux<CandidateDTO> getAllCandidates() {

        Flux<Candidate> candidateFlux  = candidateRepository.findAll();
        return candidateFlux
                .map((candidate) -> CandidateModelMapper.mapToCandidateDto(candidate))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<CandidateDTO> updateCandidate(CandidateDTO candidateDto, String candidateId) {

        Mono<Candidate> candidateMono = candidateRepository.findById(candidateId);

        return candidateMono.flatMap((existingCandidate) -> {
        	existingCandidate.setCandidateId(candidateDto.getCandidateId());
        	existingCandidate.setFirstName(candidateDto.getFirstName());
        	existingCandidate.setLastName(candidateDto.getLastName());
        	existingCandidate.setAge(candidateDto.getAge());
            return candidateRepository.save(existingCandidate);
        }).map((candidate -> CandidateModelMapper.mapToCandidateDto(candidate)));
    }

    @Override
    public Mono<Void> deleteCandidate(String candidateId) {
        return candidateRepository.deleteById(candidateId);
    }
}
