package com.comarch.szkolenia.spring.boot.controllers.rest;

import com.comarch.szkolenia.spring.boot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest")
public class SimpleRestController {

    @PostMapping("/test1/{imie}/{nazwisko}")
    public void test1(@PathVariable(value = "imie") String name,
                      @PathVariable(value = "nazwisko") String surname,
                      @RequestParam(name = "wiek", required = false) Integer age,
                      @RequestBody(required = false) User user,
                      @RequestHeader(value = "header1", required = false) String h1,
                      @RequestHeader(value = "header2", required = false) String h2) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(h1);
        System.out.println(h2);
    }

    @GetMapping("/test2")
    public User test2() {
        return new User("mateusz", "mateusz123");
    }

    @GetMapping("/test3")
    public ResponseEntity<User> test3() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("naglowek-pierwszy", "cos")
                .header("h2", "header2")
                .body(new User("admin", "admin1234"));
    }

    @PostMapping("/test4/{imie}/{nazwisko}")
    public ResponseEntity<User> test4(@PathVariable(value = "imie") String name,
                                      @PathVariable(value = "nazwisko") String surname,
                                      @RequestParam(name = "wiek", required = false) Integer age,
                                      @RequestBody(required = false) User user,
                                      @RequestHeader(value = "header1", required = false) String h1,
                                      @RequestHeader(value = "header2", required = false) String h2) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("naglowek-pierwszy", "cos")
                .header("h2", "header2")
                .body(new User("admin", "admin1234"));
    }
}
