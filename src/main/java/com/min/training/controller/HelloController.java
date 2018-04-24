package com.min.training.controller;

import com.min.training.model.Dog;
import com.min.training.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
@RequestMapping
public class HelloController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Hello() {
        return String.valueOf(new Random().nextInt(1000));
    }

    @RequestMapping(value = "/respJson", method = RequestMethod.GET)
    public Dog respJson() {
        Dog dog = new Dog();
        dog.setAge(12);
        dog.setName("萨122摩耶2");
        return dog;
    }

    @RequestMapping(value = "/zeroException", method = RequestMethod.GET)
    public int zeroException() {
        return 100 / 0;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int login(int id, String name, HttpSession session) {
        if ("123".equals(name)) {
            User user = new User();
            user.setId(id);
            user.setName(name);
            session.setAttribute("user", user);
        } else
        {
            return 0;
        }
        return 1;
    }
}
