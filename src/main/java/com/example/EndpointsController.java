package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/awesome")
public class EndpointsController {

    @GetMapping("/")
    public String getIndex() {
        return "GET to index route";
    }

    @PostMapping("/postpoint")
    public String postPoint() {
        return "POST'd to post endpoint";
    }

    @DeleteMapping("/deletepoint")
    public String deletePoint() {
        return "DELETE'd to delete endpoint";
    }

}
