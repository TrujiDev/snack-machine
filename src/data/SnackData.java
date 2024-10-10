package data;

import model.Snack;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class SnackData {
    private static final String FILE_PATH = "./snacks.txt";

    // Save snacks in a file
    public static void saveSnacks(List<Snack> snacks) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            for (Snack snack : snacks) {
                writer.write(snack.getIdSnack() + "," + snack.getName() + "," + snack.getPrice());
                writer.newLine();
            }
        }
    }

    // Load snacks from a file
    public static List<Snack> loadSnacks() throws IOException {
        List<Snack> snacks = new ArrayList<>();

        if (Files.exists(Paths.get(FILE_PATH))) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    snacks.add(new Snack(id, name, price));
                }
            }
        }
        return snacks;
    }
}
