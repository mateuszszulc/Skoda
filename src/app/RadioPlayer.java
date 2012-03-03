package app;

import javax.media.*;
import javax.media.format.AudioFormat;
import java.io.File;

public class RadioPlayer {

    private Player player;

    public void start() {
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
            player = Manager.createPlayer(new MediaLocator(new File("d:/Prowler.mp3").toURI().toURL()));
            System.out.println("Test");
            // player.realize();
            Thread.sleep(1000);
            //player.setMediaTime(new Time(new Double(30)));
            player.start();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stop() {
        player.stop();
    }
}