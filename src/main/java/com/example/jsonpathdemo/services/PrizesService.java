package com.example.jsonpathdemo.services;

import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PrizesService {

    public Object getFormattedResponseFromFile(String jsonExpression) throws IOException {
        var file = new File("./files/fileToParse.json");
        return JsonPath.parse(file).read(jsonExpression);
    }
}
