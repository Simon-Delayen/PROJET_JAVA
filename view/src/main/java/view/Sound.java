package view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    private Clip clip;

    public Sound(String son){

        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
            clip = AudioSystem.getClip();
            clip.open(audio);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Clip getClip(){
        return clip;
    }


    public void play(){
        clip.start();
    }

    public void stop(){
        clip.stop();
    }

    public static void playSound(String son){
        Sound s = new Sound(son);
        s.play();
    }
}
