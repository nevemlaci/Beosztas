package org.nevemlaci.schedule.menu;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import org.nevemlaci.schedule.settings.Theme;

import javax.swing.*;

public class MenuTheme extends JMenu {
    public MenuTheme() {
        super("Theme");

        JMenuItem light = new LeftClickableMenuItem("Light", () -> Theme.SetTheme(new FlatLightLaf()));
        JMenuItem dark = new LeftClickableMenuItem("Dark", () -> Theme.SetTheme(new FlatDarkLaf()));

        add(light);
        add(dark);
    }
}
