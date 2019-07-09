package com.kids.english.service.subject;
/*
 * created by ellen
 * created on 06.06.2019
 * class created for project sweater
 */

import com.kids.english.domain.Subjects;
import com.kids.english.repos.SubjectsRepo;
import com.kids.english.util.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private SubjectsRepo subjectsRepo;
    private String uploadPicture;
    private String uploadPath = Constans.UPLOADPATH;

    public String upload(String title, String tag, MultipartFile file){
        if (file != null && !file.getOriginalFilename().isEmpty()) {

            try {
                UploadServiceImpl prepareToUpload = new UploadServiceImpl();
                String resultFilename = prepareToUpload.createUniqueName(file.getOriginalFilename());
                //put to special folder, named by tag
                uploadPicture = "images/" + tag + "/" + resultFilename;
                Subjects sub = new Subjects(uploadPicture, tag, title);
                file.transferTo(new File(uploadPath + "/" + tag + "/" + resultFilename));
                sub.setFilename(resultFilename);
                subjectsRepo.save(sub);
                return "ok";
            } catch (IOException e) {
                e.printStackTrace();
                return "something goes wrong";
            }
        }
        return " ";
    }

    public String createUniqueName(String name){
        return UUID.randomUUID().toString() + name;
    }
}
