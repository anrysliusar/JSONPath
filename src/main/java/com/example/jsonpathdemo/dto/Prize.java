package com.example.jsonpathdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Prize {
    private String year;
    private String category;
    private String overallMotivation;
    private List<Laureate> laureates;

}
