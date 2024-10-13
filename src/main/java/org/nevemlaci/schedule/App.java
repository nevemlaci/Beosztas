package org.nevemlaci.schedule;

import javax.swing.*;
import java.awt.*;

public class App {

    public App() {
        frame = new JFrame("Hello, World!");
        frame.getRootPane().putClientProperty("JRootPane.menuBarEmbedded", true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setSize(1280,720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(main_panel);
        frame.add(menu,BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private final JFrame frame;
    private final MainPanel main_panel = new MainPanel();
    private final Menu menu = new Menu(this);

    public JFrame getFrame() {
        return frame;
    }

    public MainPanel getMainPanel() {
        return main_panel;
    }

    public Menu getMenu() {
        return menu;
    }


}
