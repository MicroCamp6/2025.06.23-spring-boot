package com.comarch.szkolenia.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("cos dziala !!!");
        return "jahsgdfjgh";
    }
}
