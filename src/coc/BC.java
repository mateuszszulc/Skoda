package coc;

import app.RadioPlayer;
import app.SkodaDispatcher;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 22.02.12
 * Time: 23:59
 */

//TODO: How BC informs about new events? Observable.
public class BC extends Observable implements Runnable {
    private SkodaDispatcher skodaDispatcher;
    private boolean started;
    private RadioPlayer player;
    private Thread stationListThread;

    public BC(SkodaDispatcher skodaDispatcher) {
        this.skodaDispatcher = skodaDispatcher;
        this.player = new RadioPlayer();

        this.stationListThread = new Thread(new StationListRunnable());
        this.stationListThread.start();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    skodaDispatcher.processEvent();
                }
            });

        }
    }

    public void start() {
        if (isStarted()) return;
        started = true;
        player.start();
    }

    public void stop() {
        if (!isStarted()) return;
        started = false;
        player.stop();
    }

    private boolean isStarted() {
        return started;
    }
}
