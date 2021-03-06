package app;

import cache.AVCache;
import cache.BCCache;
import cache.SkodaConfig;
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
import java.util.Observable;
import java.util.Observer;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 22.02.12
 * Time: 23:06
 */
public class SkodaDispatcher implements Observer {
    private JFrame frontPanel;

    public JPanel getDisplay() {
        return display;
    }

    private JPanel display;
    private JButton hkRadio;
    private JButton hkMedia;
    private JButton hkSetup;
    private JButton hkBack;
    private JButton hkRRE;

    EventManager eventManager;

    Module radio;
    Module media;
    Module setup;
    Module currentModule;
    private Module previousModule;

    //Thread BCThread;
    BC bcCoC;
    AV avCoC;

    BCCache bcCache;
    AVCache avCache;
    SkodaConfig skodaConfig;


    public SkodaDispatcher() {
        eventManager = new EventManager();
        setupGUI();
        setupListeners();
        createModules();


        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                startModule(radio);
            }
        });
        t.start();
    }

    private void createModules() {
        //TODO Maybe eventManager also should be exclusive?
        //What for is eventManager?
        bcCoC = new BC(this);
        AV avCoC = new AV();

        radio = new RadioModule(display, eventManager, bcCoC, bcCache);
        media = new MediaModule(display, eventManager);
        setup = new SetupModule(display, eventManager);
    }

    private void setupListeners() {
        //code smell - this looks like boilerplate - and most probably should be somehow generated.
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
        if (currentModule != null) currentModule.stop();
        currentModule = module;
        currentModule.start();


    }

    private void hkMediaHandler() {
        if (currentModule == media)
            media.process(UserAction.HK_Media);
        else
            startModule(media);
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
        frontPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        createSidePanels();

        display = new JPanel();
        display.add(new JLabel("Skoda Multimedia Interface"), BorderLayout.CENTER);
        frontPanel.add(display, BorderLayout.CENTER);

    }

    private void createSidePanels() {
        instantiateButtons();
        JPanel leftPanel = createLeftPanel();
        frontPanel.add(leftPanel, BorderLayout.LINE_START);
        JPanel rightPanel = createRightPanel();
        frontPanel.add(rightPanel, BorderLayout.LINE_END);
    }

    private JPanel createRightPanel() {
        JPanel panel = createPanelWithGridLayout(3, 1);
        addButtonsToPanel(panel, hkSetup, hkBack, hkRRE);
        return panel;
    }

    private void instantiateButtons() {
        hkSetup = new JButton("Setup");
        hkBack = new JButton("Back");
        hkRRE = new JButton("RRE");
        hkRadio = new JButton("Radio");
        hkMedia = new JButton("Media");
    }

    private void addButtonsToPanel(JPanel panel, JButton... buttons) {
        for (JButton button : buttons) {
            panel.add(button);
        }
    }

    private JPanel createLeftPanel() {
        JPanel panel = createPanelWithGridLayout(2, 1);
        addButtonsToPanel(panel, hkRadio, hkMedia);
        return panel;
    }

    private JPanel createPanelWithGridLayout(int row, int column) {
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(row, column);
        panel.setLayout(gridLayout);
        return panel;
    }

    public void setVisible(boolean visible) {
        frontPanel.setVisible(visible);
    }

    public void processEvent() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void update(Observable o, Object arg) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
