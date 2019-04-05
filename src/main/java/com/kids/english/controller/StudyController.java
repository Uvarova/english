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
public class StudyController {
    @Autowired
    private SubjectsRepo subjectsRepo;


    @GetMapping("/")
    public String greeting(
            // @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model) {
        //model.put("name", name);
        return "main";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }



    @GetMapping("/supply")
    public String supply(@RequestParam (name="tag", required = false) String tag, Map<String, Object> model) {
        Iterable<Subjects> subjects = subjectsRepo.findByTag(tag);
        model.put("subjects", subjects);

        test t = new test();

        return "supply";
    }

    @PostMapping("/supply")
    public String addS(@RequestParam String pic, @RequestParam(name = "sound", required = false) String sound,
                       @RequestParam (name="tag", required = false) String tag,
                       @RequestParam (name="title", required = false) String title, Map<String, Object> model) {
      /*  Subjects sub = new Subjects(pic, sound, tag);
        subjectsRepo.save(sub);*/
        Iterable<Subjects> subjects = subjectsRepo.findByTag("supply");
        model.put("subjects", subjects);

        return "supply";
    }



}
