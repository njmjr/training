package com.min.training.controller;

import com.min.training.model.Dog;
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
    @RequestMapping(value = "/respJson",method = RequestMethod.GET)
    public Dog respJson(){
        Dog dog = new Dog();
        dog.setAge(12);
        dog.setName("萨122摩耶2");
        return dog;
    }
}
