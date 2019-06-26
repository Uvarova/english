package com.kids.english.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Subjects {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String pic;
    private String sound;
    private String tag;
    private String title;
    private String filename;

    public Subjects() {
    }

    public Subjects(String pic, String tag, String title) {
        this.pic = pic;
        this.tag = tag;
        this.title = title;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
