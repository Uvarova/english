package com.kids.english.controller;

/*
 * created by ellen
 * created on 04.05.2019
 * class created for project english
 */

import com.kids.english.entity.Role;
import com.kids.english.entity.User;
import com.kids.english.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("user", userService.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String saveUser(@RequestParam String username,
                           @RequestParam Map <String,String> form,
                           @RequestParam ("userId") User user){

        userService.editUser(user,username,form);
        return "redirect:/user";
    }
}
