package com.candidate.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDTO {
    private String candidateId;
    private String firstName;
    private String lastName;
    private Integer age;
}

