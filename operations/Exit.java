package operations;
import hospitalmanagement.Database;

import java.util.Scanner;

public class Exit implements IOOperations{



    public void oper(Database database, Object staff) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Are you sure you want to exit ? (yes/no)");
        String choice = scanner.nextLine();
        if (choice.equals("yes")){
            System.out.println("Exiting...");
            System.exit(0);
        } else if (choice.equals("no")) {
            //?
        }else{
            System.out.println("Invalid choice , please try again !");
            new Exit();
        }
    }
}