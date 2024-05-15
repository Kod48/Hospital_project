package hospitalmanagement;
import operations.IOOperations;
public class Doctor extends Staff {
    private final int MAX_PATIENT=5;
    private String[] dailyAppointment;//
    private String status;


    public Doctor(String citizenNumber, String name, String surname,
                  String email, String phone, String gender, int age,
                  int id, double salary,String status) {
        super(citizenNumber, name, surname, email, phone, gender, age, salary);
        this.status = status;
        /*
        this.operations = new IOOperations[]{}
        */

    }

    public Doctor(String citizenNumber, String name,String surname,String phone){
        super(citizenNumber, name, surname, phone);

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getDailyAppointment() {
        return dailyAppointment;
    }

    public void setDailyAppointment(String[] dailyAppointment) {
        this.dailyAppointment = dailyAppointment;
    }
    //end of the getters and setters

    @Override

    public void menu(Database data, Staff staff) {
        System.out.println("menu");
    }

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
