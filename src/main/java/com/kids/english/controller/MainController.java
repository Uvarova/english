package com.kids.english.controller;

/*
 * created by ellen
 * created on 03.04.2019
 * class created for project english
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

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

}

