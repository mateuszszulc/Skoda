package modules;

import app.BCEvents;
import app.EventManager;
import app.UserAction;
import screens.Screen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 22.02.12
 * Time: 23:54
 */
public class RadioModule implements Module {
    Screen mainRadioScreen;
    //1. child-parent model like in Qt?
    //2. Events consuming model
    //3.

    Screen children[] = new Screen[10];

    Screen currentChild;

    //TODO: Refactor to design pattern - only one screen can posses display? -> ExclusiveJPanel
    //maybe this is not necessary as always one screen will be active?
    private JPanel display;
    private EventManager eventManager;

    public boolean isStarted() {
        return started;
    }

    private boolean started;

    public RadioModule(JPanel display, EventManager eventManager) {
        this.display = display;
        this.eventManager = eventManager;
    }

    public void rrePress() {

    }

    public void rreRight() {

    }

    public void rreLeft() {

    }

    public void reset() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void start() {
        if (isStarted()) return;
        started = true;

        registerEvents();
        setupDisplay();


        //To change body of implemented methods use File | Settings | File Templates.
    }

    private void setupDisplay() {
        Container pane = display.getRootPane();

    }

    private void registerEvents() {
        eventManager.add(BCEvents.STATION_INFO_CHANGED);
        eventManager.add(BCEvents.WAVEBAND_CHANGED);
    }

    public void stop() {
        started = false;
    }

    public void process(UserAction userAction) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
