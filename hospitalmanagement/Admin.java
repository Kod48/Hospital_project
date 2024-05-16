package hospitalmanagement;

import operations.*;

import java.util.Scanner;

public class Admin extends Staff {
    public Admin(String citizenNumber, String name, String surname,
                 String email, String phone, String gender, int age, double salary) {
        super(citizenNumber, name, surname, email, phone, gender, age, salary);
        this.operations = new IOOperations[]{
                new Exit(),
                new Hire(),
                new Fire(),
                new UpdateSalary(),
                new DeleteAllData(),
                new Search()
        };
    }

    public Admin(String citizenNumber, String name, String surname, String phone) {
        super(citizenNumber, name, surname, phone);
        this.operations = new IOOperations[]{
                new Exit(),
                new Hire(),
                new Fire(),
                new UpdateSalary(),
                new DeleteAllData(),
                new Search()
        };
    }

    @Override

    public void menu(Database database) {
        System.out.println("0. Exit");
        System.out.println("1. Hire");
        System.out.println("2. Fire");
        System.out.println("3. Update Salary");
        System.out.println("4. Delete All Data");
        System.out.println("5. Search");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        this.operations[choice - 1].oper(database);
        scanner.close();


    }

    @Override


    public String toString2() {
        return null;
    }

    //@Override
    //public abstract void menu(Database data,Staff staff){}

}
