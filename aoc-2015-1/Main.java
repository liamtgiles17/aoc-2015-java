import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);
            String data = "";
            while (reader.hasNextLine()) {
                data = reader.nextLine();
                System.out.println(data);
            }
            System.out.println(partTwo(data));
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static int partOne(String data) {
        int floor = 0;
        String[] tokens = data.split("");
        for (String token : tokens) {
            if ("(".equals(token)) {
                floor++;
            } else if (")".equals(token)) {
                floor--;
            }
        }
        return floor;
    }

    public static int partTwo(String data) {
        int floor = 0;
        int basementCharacter = 0;
        String[] tokens = data.split("");
        for (int i = 0; i < tokens.length; i++) {
            if ("(".equals(tokens[i])) {
                floor++;
            } else if (")".equals(tokens[i])) {
                floor--;
            }
            if (floor < 0) {
                basementCharacter = i;
                break;
            }
        }
        if (basementCharacter > 0) {
            basementCharacter++;
        }
        return basementCharacter;
    }
}