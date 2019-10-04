package com.kids.english.service.message;
/*
 * created by ellen
 * created on 16.08.2019
 * class created for project english
 */

import com.kids.english.entity.Message;
import com.kids.english.repos.SpamRepo;
import com.kids.english.util.Constans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class SpamAnalyzerImpl implements SpamAnalyzer {

    private String spam = "";
    @Autowired
    private SpamRepo spamRepo;

    @Override
    public String tooShortOrTooLongMessage(Message message) {
        spam = "";
        if (message.getText().length() < Constans.MIN_LENGTH_FOR_MESSAGE || message.getText().length() > Constans.MAX_LENGTH_FOR_MESSAGE) {
            spam = " The message is too short or too long";
        }
        return spam;
    }

    @Override
    public boolean messageContainsSpam(Message message) {
        Pattern pattern = Pattern.compile("-|:|/|, | ");
        String [] messageWords = pattern.split(message.getText());
        for (String next:messageWords) {
            if (!spamRepo.findDistinctByWord(next).isEmpty())
                return true;
        }
        return false;

    }
}
