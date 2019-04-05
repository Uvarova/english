package com.kids.english.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Subjects {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String pic;
    private String sound;
    private String tag;
    private String title;

    public Subjects() {
    }

    public Subjects(String pic, String sound, String tag, String title) {
        this.pic = pic;
        this.sound = sound;
        this.tag = tag;
        this.title = title;
    }

}
