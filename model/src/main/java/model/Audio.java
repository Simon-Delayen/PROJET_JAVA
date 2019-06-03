package model;

import javax.sound.sampled.*;

public class Audio {

    /**
     * Method to play sound
     * @param sound
     *          path of sound file
     */
    public void playSound(String sound){

        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(sound));
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
    /*public static Audio getInstance(){
        if(instance == null) {
            instance = new Audio();
        }
        return instance;
    }*/

}
