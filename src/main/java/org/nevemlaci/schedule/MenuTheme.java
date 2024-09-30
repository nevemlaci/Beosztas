package org.nevemlaci.schedule;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuTheme extends JMenu {
    public MenuTheme() {
        super("Theme");

        JMenuItem light = new LeftClickableMenuItem("Light", () -> ThemeManager.SetTheme(new FlatLightLaf()));
        JMenuItem dark = new LeftClickableMenuItem("Dark", () -> ThemeManager.SetTheme(new FlatDarkLaf()));

        add(light);
        add(dark);
    }
}
