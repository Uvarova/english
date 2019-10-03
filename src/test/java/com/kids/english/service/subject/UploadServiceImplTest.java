package com.kids.english.service.subject;

import com.kids.english.entity.Subjects;
import com.kids.english.repos.SubjectsRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.when;

/**
 * created by ellen
 * created on 03.10.2019
 */

public class UploadServiceImplTest {

    @InjectMocks
    private UploadServiceImpl uploadServiceImpl;
    @Mock
    private SubjectsRepo subjectsRepo;

    private MultipartFile multipartFileEmpty, multipartFile;
    private Subjects subjects;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        multipartFile = new MockMultipartFile("file", "filename.jpg", "image/jpeg", "hello".getBytes(StandardCharsets.UTF_8));
        subjects = new Subjects();
    }

    @Test
    public void upload(){
        Assert.assertEquals(uploadServiceImpl.upload("title", "tag", multipartFileEmpty), " ");
        when(subjectsRepo.save(subjects)).thenReturn(subjects);
        Assert.assertEquals(uploadServiceImpl.upload("title", "tag", multipartFile), "ok");
    }

    @Test
    public void createUniqueName() {
        Assert.assertNotEquals(uploadServiceImpl.createUniqueName("new"),uploadServiceImpl.createUniqueName("new"));
    }
}