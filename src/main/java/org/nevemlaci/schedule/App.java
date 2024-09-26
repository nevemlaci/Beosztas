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

    private JFrame frame;
    private MainPanel main_panel = new MainPanel();
    private Menu menu = new Menu();
    UIManager ui = new UIManager();
}
