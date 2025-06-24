package com.comarch.szkolenia.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @RequestMapping(path = {"/test", "/"}, method = RequestMethod.GET)
    public String test() {
        System.out.println("cos dziala !!!");
        return "index";
    }

    @RequestMapping(path = "/test1", method = RequestMethod.GET)
    public String test1(@RequestParam("imie") String name,
                        @RequestParam("nazwisko") String surname) {
        System.out.println(name);
        System.out.println(surname);

        return "redirect:/test";
    }

    @RequestMapping(path = "/test2/{imie}/{nazwisko}", method = RequestMethod.GET)
    public String test2(@PathVariable("imie") String name,
                        @PathVariable("nazwisko") String surname) {
        System.out.println(name);
        System.out.println(surname);

        return "index";
    }

    //@RequestMapping(path = "/test3/{imie}", method = RequestMethod.GET)
    @GetMapping("/test3/{imie}")
    public String test3(@PathVariable("imie") String name,
                        @RequestParam("nazwisko") String surname,
                        @RequestParam("wiek") int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);

        return "index";
    }

    @GetMapping("/cos")
    public String cos() {
        return "index";
    }

    @PostMapping("/cos")
    public String cos2() {
        return "index";
    }
}
