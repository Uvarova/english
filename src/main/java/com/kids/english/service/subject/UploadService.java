package com.kids.english.service.subject;
/*
 * created by ellen
 * created on 26.06.2019
 * class created for project english for kids
 */

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {
    String upload(String title, String tag, MultipartFile file);
    String createUniqueName(String name);
    boolean transferFile(MultipartFile file, String tag, String resultFilename);
}
