package com.kids.english.service;
/*
 * created by ellen
 * created on 26.06.2019
 * class created for project english for kids
 */

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String upload(String title, String tag, MultipartFile file);
    String createUniqueName(String name);
}
