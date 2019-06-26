package com.kids.english.controller;

import com.kids.english.service.TextSpeech;
import com.kids.english.domain.Subjects;
import com.kids.english.repos.SubjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class StudyController {
    @Autowired
    private SubjectsRepo subjectsRepo;

    @GetMapping("/supply")
    public String supply(@RequestParam (name="tag", required = false) String tag, Map<String, Object> model) {
        Iterable<Subjects> subjects = subjectsRepo.findByTag(tag);
        model.put("subjects", subjects);

        return "supply";
    }

    @PostMapping("/supply")
    public String addS(@RequestParam String pic,
                       @RequestParam (name="tag", required = false) String tag,
                       @RequestParam (name="title", required = false) String title, Map<String, Object> model) {

        Iterable<Subjects> subjects = subjectsRepo.findByTag("supply");
        model.put("subjects", subjects);

        return "supply";
    }

    @PostMapping("sound")
    public String sound(@RequestParam(name = "title", required = false, defaultValue = "") String title,
                        @RequestParam(name = "tag", required = false, defaultValue = "") String tag, Map<String, Object> model){

        TextSpeech speak = new TextSpeech();
        speak.readWord(title);

        Iterable<Subjects> subjects = subjectsRepo.findByTag(tag);
        model.put("subjects", subjects);
        return "/supply";
    }


}
