import util.Input;
import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Collections;


public class ContactsTest extends Contacts{
    public ContactsTest(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
    }

    public static void main(String[] args) throws IOException {

        Input in = new Input ();
        Path contactsPath = Paths.get("src", "contacts.txt");
        int input;

        List<String> list = Files.readAllLines(contactsPath);
        Collections.sort(list);


        String menu="\n\nMENU";
        menu +="\n1. View contacts.\n";
        menu+="2. Add a new contact.\n";
        menu+="3. Search a contact by name.\n";
        menu+="4. Delete an existing contact.\n";
        menu+="5. Exit.\n" ;
        menu+="Enter an option:\n";

        do {
            System.out.println(menu);

            input = in.getInt();

            switch (input) {
                case 1:
                    list = Files.readAllLines(contactsPath);
                    Collections.sort(list);
                    for (int i = 0; i < list.size(); i += 1) {
                        System.out.println((i + 1) + " : " + list.get(i));
                    }
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    System.out.println("Goodbye");
                default:
                    break;

            }
        }while(input !=5);

    }

}