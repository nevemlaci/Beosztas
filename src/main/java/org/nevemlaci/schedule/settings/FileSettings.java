package org.nevemlaci.schedule.settings;

import java.io.File;

public class FileSettings {
    public static final File EXAMPLE_DATA_DIR = new File("example_data");
    private static File lastOpenDir = EXAMPLE_DATA_DIR;

    public static File getLastOpenDir() {
        return lastOpenDir;
    }
}
