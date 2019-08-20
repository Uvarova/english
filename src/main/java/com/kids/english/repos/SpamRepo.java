package com.kids.english.repos;
/*
 * created by ellen
 * created on 20.08.2019
 * class created for project english
 */

import com.kids.english.entity.SpamWords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpamRepo extends JpaRepository<SpamWords, Long> {
    List<SpamWords> findDistinctByWord(String word);
}
