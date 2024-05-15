package hospitalmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        System.out.println("Welcome to the Hospital Management System!");

        System.out.println("Please enter your citizen number: ");
        String staffCitizenNumber = scanner.nextLine();

        //database.read("Staff", "23678256821").menu();

    }
}
