package com.candidate.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.application.dto.CandidateDTO;
import com.candidate.application.repository.CandidateRepository;
import com.candidate.application.service.CandidateService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CandidateDTO> saveCandidate(@RequestBody CandidateDTO candidateDto){
        return candidateService.saveCandidate(candidateDto);
    }

    @GetMapping("{id}")
    public Mono<CandidateDTO> getCandidate(@PathVariable("id") String candidateId){
        return candidateService.getCandidate(candidateId);
    }

    @GetMapping
    public Flux<CandidateDTO> getAllCandidates(){
        return candidateService.getAllCandidates();
    }

    @PutMapping("{id}")
    public Mono<CandidateDTO> updateCandidate(@RequestBody CandidateDTO CandidateDTO,
                                            @PathVariable("id") String candidateId){
        return candidateService.updateCandidate(CandidateDTO, candidateId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCandidate(@PathVariable("id") String candidateId){
        return candidateService.deleteCandidate(candidateId);
    }
}