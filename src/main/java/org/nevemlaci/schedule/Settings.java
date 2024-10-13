package org.nevemlaci.schedule;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public abstract class Settings {

    private static final ArrayList<String> employees = new ArrayList<>();

    public static ArrayList<String> getEmployees() {
        return employees;
    }

    public static void LoadSettings(String cfg_file) throws IOException {
        File file = new File(cfg_file);
        String json = Files.readString(file.toPath());
        JSONObject settings = new JSONObject(json);
        JSONArray employees_array = settings.getJSONArray("employees");
        for (int i = 0; i < employees_array.length(); i++) {
            employees.add(employees_array.getJSONObject(i).getString("name"));
        }
    }
}
