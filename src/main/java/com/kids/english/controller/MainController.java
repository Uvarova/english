package com.kids.english.controller;


import com.kids.english.domain.Subjects;
import com.kids.english.repos.SubjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private SubjectsRepo subjectsRepo;

    @GetMapping("/")
    public String greeting() {
        return "main";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/search")
    public String searchTag(){
        return "search";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {

        Iterable<Subjects> subjects;

        if (filter != null && !filter.isEmpty()) {
            subjects = subjectsRepo.findByTag(filter);
        } else {
            subjects = subjectsRepo.findAll();
        }

        model.put("subjects", subjects);

        return "supply";
    }

}

