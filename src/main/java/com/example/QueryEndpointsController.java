package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/queries")
public class QueryEndpointsController {

    @GetMapping("/individuallybyname")
    public String getIndividualParams(@RequestParam String muffin) {
        return String.format("The muffin is : %s", muffin);
    }

    @GetMapping("/ashash")
    public String getParamsAsHash(@RequestParam Map queryString) {
        return queryString.toString();
    }
}
