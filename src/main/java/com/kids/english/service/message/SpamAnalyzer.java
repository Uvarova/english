package com.kids.english.service.message;
/*
 * created by ellen
 * created on 16.08.2019
 * class created for project english
 */

import com.kids.english.entity.Message;

public interface SpamAnalyzer {
    String tooShortOrTooLongMessage(Message message);
    boolean messageContainsSpam(Message message);
}
