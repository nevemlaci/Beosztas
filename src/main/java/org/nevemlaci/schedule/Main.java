package org.nevemlaci.schedule;

import com.formdev.flatlaf.FlatDarkLaf;
import org.nevemlaci.schedule.app.App;
import org.nevemlaci.schedule.settings.SettingsIO;
import org.nevemlaci.schedule.settings.Theme;

import java.io.IOException;


public class Main {
    static {
        System.setProperty("sun.java2d.d3d.onscreen", "false");
    }

    public static void main(String[] args) {
        Theme.SetTheme(new FlatDarkLaf());
        try {
            SettingsIO.importSettingsFromJSON("config/settings.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        App app = App.Instance();
    }
}