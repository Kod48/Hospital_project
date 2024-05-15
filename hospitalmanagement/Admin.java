package hospitalmanagement;

public class Admin extends Staff{
    public Admin(/*IOoperations[] operations,*/String citizenNumber, String name, String surname,
                 String email, String phone, String gender, int age, double salary) {
        super(citizenNumber, name, surname, email, phone, gender, age, salary);
    }

    @Override

    public void menu(Database data) {

        System.out.println("menu");
    }

    @Override


    public String toString2() {
        return null;
    }

    //@Override
    //public abstract void menu(Database data,Staff staff){}

}
