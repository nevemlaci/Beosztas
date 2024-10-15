package org.nevemlaci.schedule.settings;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

public abstract class Settings {

    private static ArrayList<String> employees = new ArrayList<>();
    private static ArrayList<String> shifts = new ArrayList<>();

    public static ArrayList<String> getEmployees() {
        return employees;
    }

    public static ArrayList<String> getShifts() {
        return shifts;
    }

    /**
     * Load settings from a JSON file
     * @param cfg_file path to the json file
     * @throws IOException if an I/ O error occurs reading from the file or a malformed or unmappable byte sequence is read
     */
    public static void LoadSettings(String cfg_file) throws IOException {
        File file = new File(cfg_file);
        String json;
        try{
            json = Files.readString(file.toPath());
        } catch (NoSuchFileException e) {
            employees.add("");
            shifts.add(" ");
            return;
        }
        JSONObject settings = new JSONObject(json);
        JSONArray employees_array = settings.getJSONArray("employees");
        for (int i = 0; i < employees_array.length(); i++) {
            employees.add(employees_array.getString(i));
        }

        JSONArray shifts_array = settings.getJSONArray("shifts");
        for (int i = 0; i < shifts_array.length(); i++) {
            shifts.add(shifts_array.getString(i));
        }
        if(shifts.isEmpty()){
            shifts.add(" ");
            return;
        }
        if(!shifts.get(0).equals(" ")){ //add empty option if not present
            shifts.add(0, "");
        }
    }

    public static void WriteSettings(String cfg_file) throws IOException {
        JSONObject settings = new JSONObject();
        settings.put("employees", employees);
        settings.put("shifts", shifts);
        File out = new File(cfg_file);
        //noinspection ResultOfMethodCallIgnored
        out.getParentFile().mkdirs();
        if(out.createNewFile()){
            System.out.println("New file created: " + out.getName());
        } else {
            System.out.println("data.json file already exists, writing into existing data.json");
        }
        Files.writeString(out.toPath(), settings.toString(1));
    }

    public static void ImportEmployeesFromCSV(String csv_file) throws IOException {
        File file = new File(csv_file);
        String csv = Files.readString(file.toPath());
        String[] lines = csv.split("\n");
        employees = new ArrayList<>(List.of(lines));
    }

    public static void ImportShiftsFromCSV(String csv_file) throws IOException {
        File file = new File(csv_file);
        String csv = Files.readString(file.toPath());
        String[] lines = csv.split("\n");
        shifts = new ArrayList<>(List.of(lines));
        if(shifts.isEmpty()){
            shifts.add(" ");
            return;
        }
        if(!shifts.get(0).equals(" ")){ //add empty option if not present
            shifts.add(0, "");
        }
    }
}
