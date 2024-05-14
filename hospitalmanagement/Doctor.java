package hospitalmanagement;

public class Doctor extends Staff {
    private final int MAX_PATIENT=5;
    private String[] dailyAppointment;//
    private String status;

    public Doctor(/*IOoperations[] operations,*/String citizenNumber, String name, String surname,
                  String email, String phone, String gender, int age,
                  int id, double salary,String status) {
        super(citizenNumber, name, surname, email, phone, gender, age, id, salary);
        this.status = status;
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
