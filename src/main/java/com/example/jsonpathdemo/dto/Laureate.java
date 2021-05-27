package com.example.jsonpathdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Laureate {
    private String id;
    private String firstname;
    private String surname;
    private String motivation;
    private int share;
}
