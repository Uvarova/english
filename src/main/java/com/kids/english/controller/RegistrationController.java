package com.kids.english.controller;

import com.kids.english.domain.User;
import com.kids.english.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

        @Autowired
        private UserService userService;

        @GetMapping("/registration")
        public String registration(Map<String,Object> map) {
            map.put("message","");
            return "registration";
        }

        @PostMapping("/registration")
        public String addUser(User user, Map<String, Object> map) {

            if (userService.findByUsername(user) != null) {
                map.put("message", "User exists!");
                return "registration";
            }

            userService.save(user);
            return "redirect:/login";
        }
}
