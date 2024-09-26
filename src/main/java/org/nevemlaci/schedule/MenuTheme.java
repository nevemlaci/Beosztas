package org.nevemlaci.schedule;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuTheme extends JMenu {
    public MenuTheme() {
        super();
        setText("Theme");
        JMenuItem light = new JMenuItem("Light");
        light.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel( new FlatLightLaf() );
                Window[] windows = Window.getWindows();
                for(Window window : windows){
                    SwingUtilities.updateComponentTreeUI(window);
                }
            }catch (UnsupportedLookAndFeelException ex) {
                System.out.println(ex.getMessage());
            }
        });
        JMenuItem dark = new JMenuItem("Dark");
        dark.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel( new FlatDarkLaf() );
                Window[] windows = Window.getWindows();
                for(Window window : windows){
                    SwingUtilities.updateComponentTreeUI(window);
                }
            }catch (UnsupportedLookAndFeelException ex) {
                System.out.println(ex.getMessage());
            }
        });
        add(light);
        add(dark);
    }
}
