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
            }
            System.out.println(partOne(data));
            System.out.println(partTwo(data));
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static int partOne(String data) {
        int x = 0, y = 0, total = 1;
        String[] points = data.split("");
        int[][] ps = new int[points.length+1][2];
        ps[0][0] = 0;
        ps[0][1] = 0;
        boolean alreadyBeen;
        for (int i = 0; i < points.length; i++) {
            alreadyBeen = false;
            if (null != points[i]) {
                switch (points[i]) {
                    case "^" -> y++;
                    case "<" -> x--;
                    case ">" -> x++;
                    case "v" -> y--;
                    default -> {
                    }
                }
            }
            for (int[] p1 : ps) {
                if (p1 != null) {
                    if (p1[0] == x && p1[1] == y) {
                        alreadyBeen = true;
                        break;
                    }
                }
            }
            int x1 = x;
            int y1 = y;
            ps[i+1][0] = x1;
            ps[i+1][1] = y1;

            if (!alreadyBeen) total++;
        }
        return total;
    }

    public static int partTwo(String data) {
        int x = 0, y = 0, xr = 0, yr = 0, total = 1;
        String[] points = data.split("");
        int[][] ps = new int[(points.length/2)+1][2];
        int[][] psr = new int[(points.length/2)+1][2];
        ps[0][0] = 0;
        ps[0][1] = 0;
        psr[0][0] = 0;
        psr[0][1] = 0;
        boolean alreadyBeen;
        for (int i = 0; i < points.length/2; i++) {
            alreadyBeen = false;
            if (null != points[i*2]) {
                switch (points[i*2]) {
                    case "^" -> y++;
                    case "<" -> x--;
                    case ">" -> x++;
                    case "v" -> y--;
                    default -> {
                    }
                }
            }
            for (int[] p1 : ps) {
                if (p1 != null) {
                    if (p1[0] == x && p1[1] == y) {
                        alreadyBeen = true;
                        break;
                    }
                }
            }
            int x1 = x;
            int y1 = y;
            ps[i+1][0] = x1;
            ps[i+1][1] = y1;

            if (!alreadyBeen) total++;
        }
        for (int i = 0; i < points.length/2; i++) {
            alreadyBeen = false;
            if (null != points[(i*2)+1]) {
                switch (points[(i*2)+1]) {
                    case "^" -> yr++;
                    case "<" -> xr--;
                    case ">" -> xr++;
                    case "v" -> yr--;
                    default -> {
                    }
                }
            }
            for (int[] p1 : psr) {
                if (p1 != null) {
                    if (p1[0] == xr && p1[1] == yr) {
                        alreadyBeen = true;
                        break;
                    }
                }
            }
            for (int[] p2 : ps) {
                if (p2 != null) {
                    if (p2[0] == xr && p2[1] == yr) {
                        alreadyBeen = true;
                        break;
                    }
                }
            }
            int x1 = xr;
            int y1 = yr;
            psr[i+1][0] = x1;
            psr[i+1][1] = y1;

            if (!alreadyBeen) total++;
        }
        return total;
    }
}