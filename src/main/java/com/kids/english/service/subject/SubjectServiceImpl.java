package com.kids.english.service.subject;
/*
 * created by ellen
 * created on 08.07.2019
 * class created for project english
 */

import com.kids.english.entity.Subjects;
import com.kids.english.repos.SubjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectsRepo subjectsRepo;
    private Iterable<Subjects> subjects;

    @Override
    public Iterable<Subjects> findByTag(String tag) {
        if (tag.isEmpty()) {
            subjects = subjectsRepo.findAll();
        } else {
            subjects = subjectsRepo.findByTag(tag);
        }
        return subjects;
    }

    @Override
    public Iterable<Subjects> findAll() {
        return subjectsRepo.findAll();
    }
}
