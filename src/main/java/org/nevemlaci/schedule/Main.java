package org.nevemlaci.schedule;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        ThemeManager.SetTheme(new FlatDarkLaf());
        try {
            Settings.LoadSettings("config/data.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        App app = new App();
    }
}