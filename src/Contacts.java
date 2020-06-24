import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;


public class Contacts {
    public String firstName;
    public String lastName;
    public String phoneNumber;

    static Path contactsPath = Paths.get("src", "contacts.txt");
    Input in = new Input();

    public Contacts(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public static void addContact() throws IOException {
        Input in = new Input();
        List<String> list = Files.readAllLines(contactsPath);
        System.out.println("Please enter the new contact information: ");
        System.out.println("First name:");
        String inputFirst = in.getString();
        System.out.println("Last name:");
        String inputLast = in.getString();
        //checks if duplicate name
//        String input = inputFirst  + "           " + inputLast;
//        System.out.println(input);
//        for (int i = 0; i <= list.size() - 1; i++) {
//            if (list.get(i).toLowerCase().contains(input.toLowerCase())) {
//                System.out.println("Duplicate name exist. Overwrite? (y/n)");
//            }
//        }
        System.out.println("Phone number:");
        String inputNum = in.getString();
        if(inputNum.length() == 7) {
            String number = inputNum.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
            String contactInfo = String.format("%-15s %-15s | %15s", inputFirst, inputLast, number);
            System.out.println("You have added: " + contactInfo);
            Files.write(contactsPath, Arrays.asList(contactInfo),
                    StandardOpenOption.APPEND );
        } else if(inputNum.length() == 10) {
            String number = inputNum.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

            String contactInfo = String.format("%-15s %-15s | %15s", inputFirst, inputLast, number);
            System.out.println("You have added: " + contactInfo);
            Files.write(contactsPath, Arrays.asList(contactInfo),
                    StandardOpenOption.APPEND
            );
        } else {
            System.out.println("Please enter a 7 digit number or 10 digit number with area code: ");
        }
    }


    public static void searchContact() throws IOException {
        Input in = new Input();
        List<String> list = Files.readAllLines(contactsPath);

        System.out.println("Which contact would you like to Search for?");
        String input = in.getString();

        for (int i = 0; i <= list.size() - 1; i++) {
            if (list.get(i).toLowerCase().contains(input.toLowerCase())) {
                System.out.println("Contact info:\n" + list.get(i));
            }
        }
    }
//    public static void overWriteContact() throws IOException {
//        Input in = new Input();
//        List<String> removeList = Files.readAllLines(contactsPath);
//        System.out.println("Which Contact would you like to Delete?");
//        String input = in.getString();
//        for (int i = 0; i <= removeList.size() - 1; i++) {
//            if (removeList.get(i).toLowerCase().contains(input.toLowerCase())) {
//                String item = removeList.get(i);
//                System.out.println("Would you like to remove: " + item + "? Enter y/n" );
//                boolean removeInput = in.yesNo();
//                if (removeInput == true) {
//                    removeList.remove(i);
//                    System.out.println("You have deleted " + item);
//                } else  {
//                    System.out.println("Not deleting: " + item + "." + "\n Returning to menu.");
//                    break;
//                }
//            }
//        }
//        Files.write(contactsPath, removeList);
//
//    }


    public static void removeContact() throws IOException {
        Input in = new Input();
        List<String> removeList = Files.readAllLines(contactsPath);
        System.out.println("Which Contact would you like to Delete?");
        String input = in.getString();
        for (int i = 0; i <= removeList.size() - 1; i++) {
            if (removeList.get(i).toLowerCase().contains(input.toLowerCase())) {
                String item = removeList.get(i);
                System.out.println("Would you like to remove: " + item + "? Enter y/n" );
                boolean removeInput = in.yesNo();
                if (removeInput == true) {
                    removeList.remove(i);
                    System.out.println("You have deleted " + item);
                } else  {
                    System.out.println("Not deleting: " + item + "." + "\n Returning to menu.");
                    break;
                }
            }
        }
        Files.write(contactsPath, removeList);

    }


}



































//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Collections;
//
//public class Contacts {
//    private String firstName;
//    private String lastName;
//    private String phoneNumber;
//    public static void main(String[] args) {
//
//
//        Path myDirectory = Paths.get("src");
//        Path gitignore = Paths.get(".gitignore");
//
//
//
//        System.out.println(Files.exists(myDirectory));
//        System.out.println(Files.notExists(gitignore));
//
//        String directory = "test";
//        Path contactsFile = Paths.get("src","contacts.txt");
//
//        menu();
//
//        if(Files.notExists(contactsFile)){
//            try {
//                Files.createFile(contactsFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
////        Writing to contacts.txt
//
//        List<String> contacts = new ArrayList<>();
//        contacts.add("Goku          | 233 787 5444");
//        contacts.add("Piccolo       | 433 888 3521");
//        contacts.add("Vegeta        | 988 300 4000");
//        contacts.add("Bulma         | 344 651 2977");
//        contacts.add("Yamcha        | 225 388 9001");
//
//        try {
//            Files.write(contactsFile, contacts);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            List<String> myStudents = Files.readAllLines(contactsFile);
//            System.out.println(myStudents);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        String newStudent = "Ramon";
//        List<String> newStudents = Arrays.asList("Ramon","Justin","Julia","Augustine","Sophie");
//        try {
//            Files.write(contactsFile,newStudents,StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<String> newClass = new ArrayList<>();
//
////        for(String student : myStudents){
////            if(student.equals("Justin")){
////                newClass.add("Shelby");
////                continue;
////            }
////            newClass.add(student);
//        }
//
////        try {
////            Files.write(contactsFile,newClass);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        System.out.println(newClass);
////
////    }
//public static int menu() {
//
//    int selection;
//    Scanner input = new Scanner(System.in);
//
//    /***************************************************/
//
//    System.out.println("\n\nMENU");
//    System.out.println("\n1. View Contacts.");
//    System.out.println("\n2. Add New Contact.");
//    System.out.println("\n3. Search a new Contact.");
//    System.out.println("\n4. Delete an existing contact.");
//    System.out.println("\n5. Exit.\n");
//    System.out.println("Enter an option:\n");
//
//    selection = input.nextInt();
//    return selection;
//
//}
//
//
//}
