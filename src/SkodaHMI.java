import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 22.02.12
 * Time: 23:06
 */
public class SkodaHMI {
    private JFrame frontPanel;
    private JPanel display;
    private JButton hkRadio;
    private JButton hkMedia;
    private JButton hkSetup;
    private JButton hkBack;

    CoC radio;
    CoC media;
    CoC setup;
    CoC currentCoC;

    //Thread BCThread;
    BC bc;

    private CoC previousCoC;

    public SkodaHMI() {
        setupGUI();
        setupListeners();

        radio = new RadioCoC();
        media = new MediaCoC();
        setup = new SetupCoC();

        currentCoC = radio;
    }

    private void setupListeners() {
        //brzydko pachnie - to mogloby byc chyba jakos generowane.
        hkRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hkRadioHandler();
            }
        });
        hkMedia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hkMediaHandler();
            }
        });
        hkSetup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hkSetupHandler();
            }
        });
        hkBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!hkBackHandler())
                    currentCoC = previousCoC;
            }
        });
    }

    private Boolean hkBackHandler() {
        return false;
    }

    private void hkSetupHandler() {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void hkMediaHandler() {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void hkRadioHandler() {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void setupGUI() {
        frontPanel = new JFrame();
        frontPanel.setSize(500, 200);
        Container pane = frontPanel.getContentPane();

        JPanel leftPanel = createLeftPanel();
        pane.add(leftPanel, BorderLayout.LINE_START);

        display = new JPanel();
        display.add(new JLabel("R/Maryja"));
        pane.add(display, BorderLayout.CENTER);

        JPanel rightPanel = createRightPanel();
        pane.add(rightPanel, BorderLayout.LINE_END);
        frontPanel.pack();
    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel();
        hkSetup = new JButton("Setup");
        hkBack = new JButton("Back");
        rightPanel.add(hkSetup);
        rightPanel.add(hkBack);
        return rightPanel;
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        hkRadio = new JButton("Radio");
        hkMedia = new JButton("Media");
        leftPanel.add(hkRadio);
        leftPanel.add(hkMedia);
        return leftPanel;
    }

    public void setVisible(boolean visible) {
        frontPanel.setVisible(visible);
    }

    public void processEvent() {
        //To change body of created methods use File | Settings | File Templates.
    }
}
