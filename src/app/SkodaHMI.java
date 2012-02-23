package app;

import coc.AV;
import coc.BC;
import modules.MediaModule;
import modules.Module;
import modules.RadioModule;
import modules.SetupModule;

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
    private JButton hkRRE;

    Module radio;
    Module media;
    Module setup;
    Module currentModule;

    //Thread BCThread;
    BC bcCoC;
    AV avCoC;

    private Module previousModule;

    public SkodaHMI() {
        setupGUI();
        setupListeners();

        radio = new RadioModule();
        media = new MediaModule();
        setup = new SetupModule();

        currentModule = radio;
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
                    currentModule = previousModule;
            }
        });
    }

    private void hkRadioHandler() {
        if (currentModule == radio)
            radio.process(UserAction.HK_Radio);
        else
            startModule(radio);
    }

    private void startModule(Module module) {
        currentModule.stop();
        currentModule = module;

    }

    private void hkMediaHandler() {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void hkSetupHandler() {
        //To change body of created methods use File | Settings | File Templates.
    }

    private Boolean hkBackHandler() {
        return false;
    }

    private void setupGUI() {
        frontPanel = new JFrame();
        frontPanel.setSize(600, 200);
        Container pane = frontPanel.getContentPane();

        JPanel leftPanel = createLeftPanel();
        pane.add(leftPanel, BorderLayout.LINE_START);

        display = new JPanel();
        //display.setSize(500,500);
        display.add(new JLabel("R/Maryja"), BorderLayout.CENTER);
        pane.add(display, BorderLayout.CENTER);

        JPanel rightPanel = createRightPanel();
        pane.add(rightPanel, BorderLayout.LINE_END);
        //frontPanel.pack();
    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(3, 1);
        rightPanel.setLayout(gridLayout);
        hkSetup = new JButton("Setup");
        hkBack = new JButton("Back");
        hkRRE = new JButton("RRE");
        rightPanel.add(hkSetup);
        rightPanel.add(hkBack);
        rightPanel.add(hkRRE);
        return rightPanel;
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(2, 1);
        leftPanel.setLayout(gridLayout);
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
