package hospitalmanagement;

public class Admin extends Staff{
    public Admin(/*IOoperations[] operations,*/String citizenNumber, String name, String surname,
                 String email, String phone, String gender, int age, int id, double salary) {
        super(citizenNumber, name, surname, email, phone, gender, age, id, salary);
    }

    @Override

    public void menu(Database data, Staff staff) {
        System.out.println("menu");
    }

    @Override


    public String toString2() {
        return null;
    }

    //@Override
    //public abstract void menu(Database data,Staff staff){}

}
