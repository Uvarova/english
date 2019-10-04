package com.kids.english.service.subject;
/*
 * created by ellen
 * created on 06.06.2019
 * class created for project sweater
 */

import com.kids.english.entity.Subjects;
import com.kids.english.repos.SubjectsRepo;
import com.kids.english.util.Constans;
import org.apache.commons.io.FilenameUtils;
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

    public String upload(String title, String tag, MultipartFile file){
        if (file != null && !file.getOriginalFilename().isEmpty()) {
                UploadServiceImpl prepareToUpload = new UploadServiceImpl();
                String resultFilename = prepareToUpload.createUniqueName(file.getOriginalFilename());
                if(!resultFilename.equals("mistake") && file.getSize()<Constans.MAX_FILE_FOR_DOWNLOAD && transferFile(file, tag, resultFilename)) {
                    uploadPicture = "images/" + tag + "/" + resultFilename;
                    Subjects sub = new Subjects(uploadPicture, tag, title);
                    sub.setFilename(resultFilename);
                    subjectsRepo.save(sub);
                    return "ok";
                }else return "something goes wrong... ";
        }
        return " ";
    }

    public String createUniqueName(String name){
        if (FilenameUtils.getExtension(name).equals("jpg") || FilenameUtils.getExtension(name).equals("jpeg") ||
                FilenameUtils.getExtension(name).equals("png"))
            return UUID.randomUUID().toString() + name;
        else return "mistake";
    }

    //put to special folder, named by tag
    @Override
    public boolean transferFile (MultipartFile file, String tag, String resultFilename) {
        try {
            file.transferTo(new File(Constans.UPLOADPATH + "/" + tag + "/" + resultFilename));
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
