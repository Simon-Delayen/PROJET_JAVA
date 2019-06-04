package model;

import contract.model.IAudio;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Audio implements IAudio {
    public static Audio instance;

    private Audio(){

    }

    /**
     * Method to play sound
     * @param sound
     *          path of sound file
     */
    public void playSound(String sound){

        try{
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(sound);
            inputStream = new BufferedInputStream(inputStream);
            AudioInputStream audio = AudioSystem.getAudioInputStream(inputStream);
            Clip c = AudioSystem.getClip();
            c.open(audio);
            c.start();
        }
        catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
        }
        catch (LineUnavailableException e) {
        e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Method to get instance of audio
     * @return instance
     */
    public static Audio getInstance(){
        if(instance == null) {
            instance = new Audio();
        }
        return instance;
    }

}
