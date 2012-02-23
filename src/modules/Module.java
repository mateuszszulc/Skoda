package modules;

import app.UserAction;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 23.02.12
 * Time: 22:00
 */
public interface Module {
    public void reset();

    public void start();

    void stop();

    void process(UserAction userAction);
}
