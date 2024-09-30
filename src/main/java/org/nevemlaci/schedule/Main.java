package org.nevemlaci.schedule;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        ThemeManager.SetTheme(new FlatDarkLaf());
        App app = new App();
    }
}