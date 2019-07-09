package com.kids.english.controller;
/*
 * created by ellen
 * created on 06.06.2019
 * class created for project english
 */

import com.kids.english.service.subject.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @GetMapping("upload")
    public String upShow(Map<String,String> map){
        map.put("result","");
        return "upload";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         @RequestParam String tag,
                         @RequestParam String title,
                         Map<String, String> map) {

        map.put("result", uploadService.upload(title, tag, file));
        return "upload";
    }

}
