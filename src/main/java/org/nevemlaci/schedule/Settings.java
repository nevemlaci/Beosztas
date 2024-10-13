package org.nevemlaci.schedule;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Settings {

    private static final ArrayList<String> employees = new ArrayList<>();
    private static final ArrayList<String> shifts = new ArrayList<>();

    public static ArrayList<String> getEmployees() {
        return employees;
    }

    public static ArrayList<String> getShifts() {
        return shifts;
    }

    public static void LoadSettings(String cfg_file) throws IOException {
        File file = new File(cfg_file);
        String json = Files.readString(file.toPath());
        JSONObject settings = new JSONObject(json);
        JSONArray employees_array = settings.getJSONArray("employees");
        for (int i = 0; i < employees_array.length(); i++) {
            employees.add(employees_array.getString(i));
        }

        JSONArray shifts_array = settings.getJSONArray("shifts");
        for (int i = 0; i < shifts_array.length(); i++) {
            shifts.add(shifts_array.getString(i));
        }
        if(!shifts.get(0).equals(" ")){ //add empty option if not present
            shifts.add(0, "");
        }
    }

    public static void WriteSettings(String cfg_file) throws IOException {
        JSONObject settings = new JSONObject();
        settings.put("employees", employees);
        settings.put("shifts", shifts);
        Files.writeString(new File(cfg_file).toPath(), settings.toString());
    }
}
