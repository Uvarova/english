package com.kids.english;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class PlaySound {

    public PlaySound() {
    }

    public void playSound(String nameSound){

        File soundFile = new File(nameSound);
        Clip clip = null;
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile)) {

            //Получаем реализацию интерфейса Clip
            try {
                clip = AudioSystem.getClip();
                clip.open(ais);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        clip.setFramePosition(0); //устанавливаем указатель на старт

        FloatControl vc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        vc.setValue(2);
        clip.start();

        try {
            sleep(clip.getMicrosecondLength()/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clip.stop(); //Останавливаем
        clip.close(); //Закрываем

    }
}
