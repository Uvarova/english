package com.kids.english.controller;

/*
 * created by ellen
 * created on 11.04.2019
 * class created for project english
 */

import com.kids.english.service.TextSpeech;
import com.kids.english.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class StudyController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TextSpeech textSpeech;

    @GetMapping("/supply")
    public String supply(@RequestParam (name="tag", required = false) String tag, Map<String, Object> model) {
        model.put("subjects", subjectService.findByTag(tag));
        return "supply";
    }

    @PostMapping("/supply")
    public String sound(@RequestParam(name = "title", required = false, defaultValue = "") String title,
                        @RequestParam(name = "tag", required = false, defaultValue = "") String tag, Map<String, Object> model){

        textSpeech.readWord(title);
        model.put("subjects", subjectService.findByTag(tag));
        return "/supply";
    }


}
