package com.min.training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
public class HelloController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Hello(){
        return String.valueOf(new Random().nextInt(1000));
    }
}
