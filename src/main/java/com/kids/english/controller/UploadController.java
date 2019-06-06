package com.kids.english.controller;
/*
 * created by ellen
 * created on 06.06.2019
 * class created for project english
 */

import com.kids.english.domain.Subjects;
import com.kids.english.repos.SubjectsRepo;
import com.kids.english.service.PrepareToUpload;
import com.kids.english.util.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @Autowired
    private SubjectsRepo subjectsRepo;
    private String uploadPicture;
    private String uploadPath = Constans.UPLOADPATH;
    private Boolean uploadOk = false;

    @GetMapping("upload")
    public String upShow(){
        return "upload";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         @RequestParam String sound,
                         @RequestParam String tag,
                         @RequestParam String title) {

        if (file != null && !file.getOriginalFilename().isEmpty()) {

            try {
                PrepareToUpload prepareToUpload = new PrepareToUpload();
                String resultFilename = prepareToUpload.createUniqueName(file.getOriginalFilename());
                //put to special folder, named by tag
                uploadPicture = "images/" + tag + "/" + resultFilename;
                Subjects sub = new Subjects(uploadPicture, sound, tag, title);
                file.transferTo(new File(uploadPath + "/" + tag + "/" + resultFilename));
                sub.setFilename(resultFilename);
                subjectsRepo.save(sub);
                uploadOk = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "upload";
    }

}
