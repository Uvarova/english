package com.kids.english.entity;
/*
 * created by ellen
 * created on 20.08.2019
 * class created for project english
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "spam_words")
@Getter
@Setter
public class SpamWords {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String word;

    public SpamWords(){};

    public SpamWords(String word){
        this.word = word;
    }
}
