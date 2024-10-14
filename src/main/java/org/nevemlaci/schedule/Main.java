package org.nevemlaci.schedule;

import com.formdev.flatlaf.FlatDarkLaf;
import org.nevemlaci.schedule.app.App;
import org.nevemlaci.schedule.settings.Settings;
import org.nevemlaci.schedule.settings.Theme;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Theme.SetTheme(new FlatDarkLaf());
        try {
            Settings.LoadSettings("config/data.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        App app = new App();
        try {
            Settings.WriteSettings("config/data.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}