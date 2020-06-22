import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    public static void main(String[] args) {

        Path myDirectory = Paths.get("src");
        Path gitignore = Paths.get(".gitignore");

        System.out.println(Files.exists(myDirectory));
        System.out.println(Files.notExists(gitignore));

        String directory = "test";
        Path contactsFile = Paths.get("src","contacts.txt");

//        if(Files.notExists(myTest)){
//            try {
//                Files.createDirectory(myTest);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        if(Files.notExists(contactsFile)){
            try {
                Files.createFile(contactsFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        Writing to contacts.txt

        List<String> contacts = new ArrayList<>();
        contacts.add("Goku");
        contacts.add("Piccolo");
        contacts.add("Vegeta");
        contacts.add("Bulma");
        contacts.add("Yamcha");

        try {
            Files.write(contactsFile, contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<String> myStudents = Files.readAllLines(contactsFile);
            System.out.println(myStudents);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String newStudent = "Ramon";
        List<String> newStudents = Arrays.asList("Ramon","Justin","Julia","Augustine","Sophie");
        try {
            Files.write(contactsFile,newStudents,StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> newClass = new ArrayList<>();

//        for(String student : myStudents){
//            if(student.equals("Justin")){
//                newClass.add("Shelby");
//                continue;
//            }
//            newClass.add(student);
        }

        try {
            Files.write(contactsFile,newClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newClass);

    }


}
