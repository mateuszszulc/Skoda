package modules;

import app.EventManager;
import app.UserAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 22.02.12
 * Time: 23:54
 */
public class MediaModule implements Module {
    private JPanel display;

    public MediaModule(JPanel display, EventManager eventManager) {
        this.display = display;
    }

    public void reset() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void start() {
        display.removeAll();
        display.add(new JLabel("Media Screen"), BorderLayout.CENTER);
        display.updateUI();
    }

    public void stop() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void process(UserAction userAction) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
