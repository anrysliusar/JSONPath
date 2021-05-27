package com.example.jsonpathdemo.controllers;

import com.example.jsonpathdemo.dto.Prize;
import com.example.jsonpathdemo.services.PrizesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prizes")
public class PrizesController {
    private final PrizesService prizesService;

    @GetMapping("")
    public List<Prize> getPrizes() throws IOException {
        String expression = "$.prizes[*]";
        return (List<Prize>) prizesService.getFormattedResponseFromFile(expression);

    }

    @GetMapping("/{index}")
    public HashMap<String, Object> getChosenPrize(@PathVariable String index) throws IOException {
        String expression = "$.prizes[" + index + "]";
        return (HashMap<String, Object>) prizesService.getFormattedResponseFromFile(expression);
    }

    @GetMapping("/{start}/{end}")
    public List<Prize> getRangeOfPrizes(@PathVariable String start, @PathVariable String end) throws IOException {
        String expression = "$.prizes[" + start + ":" + end + "]";
        return (List<Prize>) prizesService.getFormattedResponseFromFile(expression);
    }

    @GetMapping("/{start}/{end}/{step}")
    public List<Prize> getChosenPrizes(@PathVariable String start, @PathVariable String end, @PathVariable String step) throws IOException {
        String expression = "$.prizes[" + start + ":" + end + ":" + step + "]";
        return (List<Prize>) prizesService.getFormattedResponseFromFile(expression);
    }

    @GetMapping("/categories")
    public List<String> getCategories() throws IOException {
        String expression = "$.prizes[*].category";
        return (List<String>) prizesService.getFormattedResponseFromFile(expression);
    }


}
