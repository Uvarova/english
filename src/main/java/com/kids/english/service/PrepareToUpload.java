package com.kids.english.service;
/*
 * created by ellen
 * created on 06.06.2019
 * class created for project sweater
 */

import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class PrepareToUpload {

    public String createUniqueName(String name){
        return UUID.randomUUID().toString() + name;
    }
}
