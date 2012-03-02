package testing.jmf;

import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;
import javax.media.Format;
import javax.media.Time;
import java.io.File;

public class AudioTest {
    public static void main(String[] args) {
        Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
        Format input2 = new AudioFormat(AudioFormat.MPEG);
        Format output = new AudioFormat(AudioFormat.LINEAR);
        PlugInManager.addPlugIn(
                "com.sun.media.codec.audio.mpa.Packetizer",
                new Format[]{input1, input2},
                new Format[]{output},
                PlugInManager.CODEC
        );
        try {
            Player player = Manager.createPlayer(new MediaLocator(new File("d:/Prowler.mp3").toURI().toURL()));
            System.out.println("Test");
            // player.realize();

            player.realize();
            Thread.sleep(1000);
            player.setMediaTime(new Time(new Double(30)));
            player.start();


            System.out.println("Test 2");
            Thread.sleep(10000);
            System.out.println("Test 3");

            player.stop();
            System.out.println("Test 4");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}