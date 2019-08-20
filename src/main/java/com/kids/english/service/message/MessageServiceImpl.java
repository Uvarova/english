package com.kids.english.service.message;
/*
 * created by ellen
 * created on 03.07.2019
 * class created for project english
 */

import com.kids.english.entity.Message;
import com.kids.english.entity.User;
import com.kids.english.repos.MessageRepo;
import com.kids.english.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SpamAnalyzer spamAnalyzer;
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
    public String saveMessage(Message message) {
        String spam = "";
        spam = spamAnalyzer.tooShortOrTooLongMessage(message);
        if (spam.length() < 1 && !spamAnalyzer.messageContainsSpam(message)) {
            messageRepo.save(message);
        }else{
            spam = "Your message can't be saved! It contains deprecated words. " + spam;
            User user = message.getAuthor();
            user.setCountOfSpam(user.getCountOfSpam()+1);
            userRepo.save(user);
        }
        return spam;
    }
}
