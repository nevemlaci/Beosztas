package org.nevemlaci.schedule.settings;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

public abstract class SettingsIO {

    private SettingsIO() {
        throw new IllegalStateException("Utility class");
    }

    private static ArrayList<String> employees = new ArrayList<>();
    private static ArrayList<String> shifts = new ArrayList<>();

    public static List<String> getEmployees() {
        return employees;
    }

    public static List<String> getShifts() {
        return shifts;
    }

    /**
     * Load settings from a JSON file
     * @param jsonPath path to the json file
     * @throws IOException if an I/ O error occurs reading from the file or a malformed or unmappable byte sequence is read
     */
    public static void importSettingsFromJSON(String jsonPath) throws IOException {
        File file = new File(jsonPath);
        String json;
        try{
            json = Files.readString(file.toPath());
        } catch (NoSuchFileException e) {
            employees.add("");
            shifts.add(" ");
            return;
        }
        JSONObject settings = new JSONObject(json);
        JSONArray employeesArray = settings.getJSONArray("employees");
        employees = new ArrayList<>();
        for (int i = 0; i < employeesArray.length(); i++) {
            employees.add(employeesArray.getString(i));
        }

        JSONArray shiftsArray = settings.getJSONArray("shifts");
        for (int i = 0; i < shiftsArray.length(); i++) {
            shifts.add(shiftsArray.getString(i));
        }
        if(shifts.isEmpty()){
            shifts.add(" ");
            return;
        }
        if(!shifts.get(0).equals(" ")){ //add empty option if not present
            shifts.add(0, "");
        }
    }

    public static void exportSettingsToJSON(String jsonPath) throws IOException {
        JSONObject settings = new JSONObject();
        settings.put("employees", employees);
        settings.put("shifts", shifts);
        File out = new File(jsonPath);
        //noinspection ResultOfMethodCallIgnored
        out.getParentFile().mkdirs();
        if(out.createNewFile()){
            System.out.println("New file created: " + out.getName());
        } else {
            System.out.println("data.json file already exists, writing into existing data.json");
        }
        Files.writeString(out.toPath(), settings.toString(1));
    }

    public static void importEmployeesFromCSV(String csvPath) throws IOException {
        File inFile = new File(csvPath);
        String csvContent = Files.readString(inFile.toPath());
        csvContent = csvContent.replace("\uFEFF", ""); // throw away bom
        csvContent = csvContent.replace("\r", ""); // throw away carriage return
        String[] lines = csvContent.split("\n");
        employees = new ArrayList<>(List.of(lines));
    }

    public static void importShiftsFromCSV(String csvPath) throws IOException {
        File inFile = new File(csvPath);
        String csv = Files.readString(inFile.toPath());
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

    public static void exportEmployeesToCSV(String csv) {
        exportListToCSV(csv, employees);
    }

    public static void exportShiftsToCSV(String csv) {
        exportListToCSV(csv, shifts);
    }

    private static void exportListToCSV(String csv, List<String> list) {
        File outFile = new File(csv);
        StringBuilder csvContent = new StringBuilder();
        for (String item : list) {
            csvContent.append(item).append("\n");
        }
        try {
            Files.writeString(outFile.toPath(), csvContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
