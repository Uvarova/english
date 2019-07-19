package com.kids.english.repos;

import com.kids.english.entity.Subjects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectsRepo extends CrudRepository<Subjects, Long> {

    List<Subjects> findByTag(String tag);

}
