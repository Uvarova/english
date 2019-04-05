package com.kids.english.controller;


import com.kids.english.TextSpeech;
import com.kids.english.domain.Message;
import com.kids.english.domain.Subjects;
import com.kids.english.domain.User;
import com.kids.english.repos.MessageRepo;
import com.kids.english.repos.SubjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ServiceController {
    @Autowired
    private SubjectsRepo subjectsRepo;
    @Autowired
    private MessageRepo messageRepo;


    @GetMapping("forum")
    public String searchMess(Map<String,Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "forum";
    }

    @PostMapping("forum")
    public String sendMess(@AuthenticationPrincipal User user,
            @RequestParam(name = "text", required = false, defaultValue = "") String text,
                           @RequestParam(name = "tag", required = false, defaultValue = "") String tag, Map<String, Object> model) {
        Message mess = new Message(text,tag,user);
        messageRepo.save(mess);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages",messages);

        return "forum";
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

    @GetMapping("upload")
    public String upShow(){
        return "upload";
    }

    @PostMapping("upload")
    public String upload(@RequestParam String pic, @RequestParam String sound, @RequestParam String tag, @RequestParam String title, Map<String, Object> model){

        Subjects sub = new Subjects(pic, sound, tag, title);
        subjectsRepo.save(sub);

        return "upload";
    }

    @PostMapping("sound")
    public String sound(@RequestParam(name = "title", required = false, defaultValue = "") String title,
                        @RequestParam(name = "tag", required = false, defaultValue = "") String tag, Map<String, Object> model){
        //PlaySound play = new PlaySound();
        //play.playSound(sound);
        TextSpeech speak = new TextSpeech();
        try {
            speak.readWord(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterable<Subjects> subjects = subjectsRepo.findByTag(tag);
        model.put("subjects", subjects);
        return "/supply";
    }
}

