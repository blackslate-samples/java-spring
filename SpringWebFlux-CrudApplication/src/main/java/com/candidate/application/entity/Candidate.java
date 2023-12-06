package com.candidate.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "candidate")
public class Candidate {
    @Id
    private String candidateId;
    private String firstName;
    private String lastName;
    private Integer age;
}

