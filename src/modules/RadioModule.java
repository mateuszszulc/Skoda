package modules;

import app.UserAction;
import screens.Screen;

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

    public RadioModule() {

        //start();
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
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void stop() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void process(UserAction userAction) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
