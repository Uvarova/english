package com.kids.english.controller;
/*
 * created by ellen
 * created on 03.07.2019
 * class created for project english
 */

import com.kids.english.entity.Message;
import com.kids.english.entity.User;
import com.kids.english.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ForumController {
    @Autowired
    private MessageService messageService;
    private String spam = "";

    @RequestMapping("/forum")
    public String allMessages(Map<String,Object> model) {
        model.put("messages", messageService.findAll());
        model.put("spam",spam);
        return "/forum";
    }

    @PostMapping("/findmessage")
    public String findMessage(@RequestParam(name = "tag", required = false, defaultValue = "") String tag, Map<String, Object> model) {
        model.put("messages",messageService.findByTag(tag));
        model.put("spam","");
        return "/forum";
    }

    @PostMapping("/savemessage")
    public String sendMess(@AuthenticationPrincipal User user,
                           @RequestParam(name = "text", required = false, defaultValue = "") String text,
                           @RequestParam(name = "tag", required = false, defaultValue = "") String tag, Map<String, Object> model) {
        Message message = new Message(text,tag,user);
        spam = messageService.saveMessage(message);
        return "redirect:/forum";
    }
}
