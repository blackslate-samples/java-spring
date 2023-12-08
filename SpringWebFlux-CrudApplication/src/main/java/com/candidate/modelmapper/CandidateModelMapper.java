package com.candidate.modelmapper;

import com.candidate.application.dto.CandidateDTO;
import com.candidate.application.entity.Candidate;

public class CandidateModelMapper {

    public static CandidateDTO mapToCandidateDto(Candidate candidate){
        return new CandidateDTO(
        		candidate.getCandidateId(),
                candidate.getFirstName(),
                candidate.getLastName(),
                candidate.getAge()
               
        );
    }

    public static Candidate mapToCandidate(CandidateDTO canidateDto){
        return new Candidate(
        		canidateDto.getCandidateId(),
        		canidateDto.getFirstName(),
        		canidateDto.getLastName(),
        		canidateDto.getAge()
        		
        );
    }
}
