package app;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 22.02.12
 * Time: 23:01
 */
public class SkodaApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SkodaDispatcher skodaDispatcher = new SkodaDispatcher();
                skodaDispatcher.setVisible(true);
            }
        });
    }
}
