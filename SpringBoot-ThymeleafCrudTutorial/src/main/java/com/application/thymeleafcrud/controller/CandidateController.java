package com.application.thymeleafcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.thymeleafcrud.entity.Candidate;
import com.application.thymeleafcrud.repository.CandidateRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Candidate candidate) {
        return "add-candidate";
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addCandidate(@Valid Candidate candidate, BindingResult result, Model model) {
        if (result.hasFieldErrors("name") || result.hasFieldErrors("email") || result.hasFieldErrors("age")) {
            return "add-candidate";
        }

        candidateRepository.save(candidate);
        return "redirect:list";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));
        model.addAttribute("candidate", candidate);
        return "update-candidate";
    }


    @PostMapping("/update/{id}")
    public String updateCandidate(@PathVariable("id") long id, @Valid Candidate candidate, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            candidate.setId(id);
            return "update-candidate";
        }

        candidateRepository.save(candidate);
        model.addAttribute("candidates", candidateRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable("id") long id, Model model) {
        Candidate candidate = candidateRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));
        candidateRepository.delete(candidate);
        model.addAttribute("candidates", candidateRepository.findAll());
        return "index";
    }
}
