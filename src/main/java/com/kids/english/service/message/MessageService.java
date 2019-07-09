package com.kids.english.service.message;
/*
 * created by ellen
 * created on 03.07.2019
 * class created for project english
 */

import com.kids.english.domain.Message;

public interface MessageService {
    Iterable<Message> findByTag(String tag);
    Iterable<Message> findAll();
    void saveMessage(Message message);
}
