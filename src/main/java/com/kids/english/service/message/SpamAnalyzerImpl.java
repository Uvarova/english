package com.kids.english.service.message;
/*
 * created by ellen
 * created on 16.08.2019
 * class created for project english
 */

import com.kids.english.entity.Message;
import com.kids.english.util.Constans;
import org.springframework.stereotype.Service;

@Service
public class SpamAnalyzerImpl implements SpamAnalyzer {

    private String spam = "";

    @Override
    public String tooShortOrTooLongMessage(Message message) {
        spam = "";
        if (message.getText().length() < Constans.minLengthForMessage || message.getText().length() > Constans.maxLengthFprMessage) {
            spam = " The message is too short or too long";
        }
        return spam;
    }
}
