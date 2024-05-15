package hospitalmanagement;
import operations.*;
import java.util.Scanner;
import operations.IOOperations;

public class Doctor extends Staff {
    Database database;
    private final int MAX_PATIENT=5;
    private String[] dailyAppointment;//
    private String status;

    public Doctor(String citizenNumber, String name, String surname,
                           String email, String phone, String gender, int age,
                            double salary, String status) {
        super(citizenNumber, name, surname, email, phone, gender, age, salary);
        this.status = status;
        this.operations = new IOOperations[]{
                new Exit(),
                new ShowPatientInfo(),
                new AddDiagnosis(),
                new CreateRecipe(),
                new ShowSchedule()
        };
    }

    public Doctor(String citizenNumber, String name,String surname,String phone){
        super(citizenNumber, name, surname, phone);
      this.operations = new IOOperations[]{
                new Exit(),
                new ShowPatientInfo(),
                new AddDiagnosis(),
                new CreateRecipe(),
                new ShowSchedule()
        };

    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void menu(Database database){
        System.out.println("0. Exit");
        System.out.println("1. Show Patient Information");
        System.out.println("2. Add Diagnosis");
        System.out.println("3. Create Recipe");
        System.out.println("4. Show Schedule");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        this.operations[choice-1].oper(database);
        scanner.close();;
    }

    public String[] getDailyAppointment() {
        return dailyAppointment;
    }

    public void setDailyAppointment(String[] dailyAppointment) {
        this.dailyAppointment = dailyAppointment;
    }
    //end of the getters and setters

    @Override
    public String toString() {
        return super.toString() +
                "Status:" + this.status + "\n";
    }

    @Override
    public String toString2() {
        return null;
    }

    //@Override
    //public abstract void menu(Database data,Staff staff){}

}
