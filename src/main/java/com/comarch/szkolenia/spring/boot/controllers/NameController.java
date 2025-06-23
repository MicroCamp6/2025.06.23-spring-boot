package com.comarch.szkolenia.spring.boot.controllers;

import com.comarch.szkolenia.spring.boot.database.INameDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NameController {
    private final INameDAO nameDAO;

    @GetMapping("/names")
    public String names(Model model) {
        model.addAttribute("randomName", this.nameDAO.getRandom());
        model.addAttribute("allNames", this.nameDAO.getAll());
        return "names";
    }
}
