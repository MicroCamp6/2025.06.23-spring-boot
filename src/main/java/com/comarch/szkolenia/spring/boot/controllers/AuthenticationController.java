package com.comarch.szkolenia.spring.boot.controllers;

import com.comarch.szkolenia.spring.boot.database.IUserDAO;
import com.comarch.szkolenia.spring.boot.model.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {
    private final IUserDAO userDAO;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        HttpSession session) {
        Optional<User> userBox = this.userDAO.getByLogin(login);
        if(userBox.isPresent() && userBox.get().getPassword().equals(password)) {
            session.setAttribute("user", userBox.get());
            return "redirect:/";
        }

        return "redirect:/login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
