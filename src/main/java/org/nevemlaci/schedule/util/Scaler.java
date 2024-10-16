package org.nevemlaci.schedule.util;

import javax.swing.*;
import java.awt.*;

public abstract class Scaler {
    private Scaler(){}

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Scales the given dimension to the screen size
     * @param x the x scale
     * @param y the y scale
     * @return the scaled dimension
     */
    public static Dimension scaleToScreen(double x, double y){
        return new Dimension((int)(SCREEN_SIZE.width * x), (int)(SCREEN_SIZE.height * y));
    }

    public static Dimension scaleToWindow(JFrame frame, double x, double y){
        return new Dimension((int)(frame.getWidth() * x), (int)(frame.getHeight() * y));
    }
}
