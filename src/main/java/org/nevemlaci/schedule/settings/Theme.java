package org.nevemlaci.schedule.settings;

import javax.swing.*;
import java.awt.*;

public class Theme {

    public static void RefreshWindows(){
        Window[] windows = Window.getWindows();
        for(Window window : windows){
            SwingUtilities.updateComponentTreeUI(window);
        }
    }

    public static void SetTheme(LookAndFeel look_and_feel){
        try{
            UIManager.setLookAndFeel(look_and_feel);
            RefreshWindows();
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
