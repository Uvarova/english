package com.kids.english.service.message;
/*
 * created by ellen
 * created on 03.07.2019
 * class created for project english
 */

import com.kids.english.entity.Message;
import com.kids.english.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
   @Autowired
   private MessageRepo messageRepo;
   private Iterable<Message> messages;

   @Override
    public Iterable<Message> findByTag(String tag) {
       if (tag.isEmpty()) {
           messages = messageRepo.findAll();
       } else {
           messages = messageRepo.findByTag(tag);
       }
        return messages;
    }

    @Override
    public Iterable<Message> findAll() {
        return messageRepo.findAll();
    }

    @Override
    public void saveMessage(Message message) {
        messageRepo.save(message);
    }
}
