package util;

import java.util.Scanner;

public class Input {

    private Scanner sc;

    public Input() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public String getString() {
        return sc.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public boolean yesNo() {
        String input = sc.next();
        System.out.println(input);
        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public int getInt() {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            System.out.println("Invalid input. Enter valid integer.");
            sc.next();
            return getInt();
        }
    }

    public int getInt(int min, int max) {
        int userInt = getInt();
        if (userInt >= min && userInt <= max) {
            return userInt;
        } else {
            System.out.println("Please enter an integer in the correct range between " + min + " " + "and " + max);
            return getInt(min, max);
        }
    }
}
