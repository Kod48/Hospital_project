package hospitalmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        System.out.println("Welcome to the Hospital Management System!");

        System.out.println("Please enter your citizen number: ");
        String staffCitizenNumber = scanner.nextLine();
        Object obj = database.read("Staff", staffCitizenNumber);

        if (obj != null) {
            if (obj instanceof Doctor) {
                Doctor doctor = (Doctor) obj;
                doctor.menu(database);
            } else if (obj instanceof Secretary) {
                Secretary secretary = (Secretary) obj;
                secretary.menu(database);
            }
            else if (obj instanceof Admin) {
                Admin admin = (Admin) obj;
                admin.menu(database);
            }
        }

       // database.delete("Staff","46386327549");
    }
}
