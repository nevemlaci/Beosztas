package org.nevemlaci.schedule;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        }catch (UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }

        App app = new App();
    }
}