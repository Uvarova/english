package com.kids.english.service.subject;
/*
 * created by ellen
 * created on 08.07.2019
 * class created for project english
 */

import com.kids.english.domain.Subjects;

public interface SubjectService {
    Iterable<Subjects> findByTag(String tag);
    Iterable<Subjects> findAll();
}
