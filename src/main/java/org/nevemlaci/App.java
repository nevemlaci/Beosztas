package org.nevemlaci;


import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

public class App {

    public App() {

        frame = new JFrame("Hello, World!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(main_panel);
        frame.setVisible(true);
    }

    private JFrame frame;
    private MainPanel main_panel = new MainPanel();

}
