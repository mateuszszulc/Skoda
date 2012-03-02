package modules;

import app.BCEvents;
import app.EventManager;
import app.UserAction;
import coc.BC;
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

        //Start radio somehow...
        //1. Asynchronous:
        // Start radio asynchronous, fetch cached data and wait for callback with
        // (possibly) updated data (this is probably how it works at Conti)

        //1a send event/post message or direct call to asynchronous method.

        BC.start();

        //2. Synchronized...

        //3. Is there any other way?


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
