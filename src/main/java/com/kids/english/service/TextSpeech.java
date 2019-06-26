package com.kids.english.service;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
/*
special class for translate text to speech
to download https://sourceforge.net/projects/freetts/files/latest/download
 */
public class TextSpeech {

    private static final String VOICENAME = "kevin16";
    private String word;

    public TextSpeech(){}

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void readWord(String word){
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        voice.speak(word);
    }
}