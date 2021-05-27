package com.example.jsonpathdemo.controllers;

import com.example.jsonpathdemo.dto.Laureate;
import com.example.jsonpathdemo.services.PrizesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/laureates")
public class LaureateController {
    private final PrizesService prizesService;

    @SuppressWarnings("unchecked")
    @GetMapping("")
    public List<Laureate> getLaureates() throws IOException {
        String expression = "$.prizes[*].laureates[*]";
        return (List<Laureate>) prizesService.getFormattedResponseFromFile(expression);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/year/{year}")
    public List<Laureate> getLaureatesOfYear(@PathVariable int year) throws IOException {
        String expression = "$.prizes[?(@.year == " + year + ")].laureates[*]";
        return (List<Laureate>) prizesService.getFormattedResponseFromFile(expression);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/firstnames")
    public List<String> getFirstnames() throws IOException {
        String expression = "$.prizes[*].laureates[*].firstname";
        return (List<String>) prizesService.getFormattedResponseFromFile(expression);
    }
}

