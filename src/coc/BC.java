package coc;

import app.SkodaHMI;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 22.02.12
 * Time: 23:59
 */
public class BC implements Runnable {
    private SkodaHMI skodaHMI;

    public BC(SkodaHMI skodaHMIparam) {
        skodaHMI = skodaHMIparam;
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
                    skodaHMI.processEvent();
                }
            });

        }
    }
}
