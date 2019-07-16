package com.kids.english;

import com.sun.speech.freetts.VoiceManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * created by ellen
 * created on 16.07.2019
 * class created for project english
 */

public class TextSpeechTest {

    @Test
    public void readWord() {
        Assert.assertNotNull(VoiceManager.getInstance().getVoice("kevin16"));
    }
}