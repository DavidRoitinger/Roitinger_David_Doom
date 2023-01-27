import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound implements Runnable {
    private static Clip clip1;
    @Override
    public void run() {
        try {
            File musicPath = new File("Doom OST - E1M1 - At Doom's Gate.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            while (true){

                clip.start();
                Thread.sleep(clip.getMicrosecondLength()/1000);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
