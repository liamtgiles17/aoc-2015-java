import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);
            String[] data = new String[1000];
            int it = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                data[it] = line;
                it++;
            }
            System.out.println(partOne(data));
            System.out.println(partTwo(data));
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static int[] bubbleSort(int[] arr, int n) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n-1; i++) {
            swapped = false;
            for (j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        return arr;
    }

    public static int[] getLengths(String point) {
        String[] sideLengths = point.split("[x]+");
        int[] lengths = new int[3];
        for (int i = 0; i < sideLengths.length; i++) {
            lengths[i] = Integer.parseInt(sideLengths[i]);
        }
        return lengths;
    }

    public static int partOne(String[] data) {
        int total = 0;
        for (String point : data) {
            int[] lengths = getLengths(point);
            int[] areas = {lengths[0]*lengths[1], lengths[0]*lengths[2], lengths[2]*lengths[1]};
            areas = bubbleSort(areas, areas.length);
            int sum = (2*areas[0]) + (2*areas[1]) + (2*areas[2]) + areas[0];
            total += sum;
        }
        return total;
    }

    public static int partTwo(String[] data) {
        int total = 0;
        for (String point : data) {
            int[] lengths = getLengths(point);
            lengths = bubbleSort(lengths, lengths.length);
            int volume = lengths[0]*lengths[1]*lengths[2];
            int perim = (2*lengths[0]) + (2*lengths[1]);
            int sum = volume + perim;
            total += sum;
        }
        return total;
    }
}