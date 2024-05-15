package hospitalmanagement;

public class Admin extends Staff{
    public Admin(/*IOoperations[] operations,*/String citizenNumber, String name, String surname,
                 String email, String phone, String gender, int age, double salary) {
        super(citizenNumber, name, surname, email, phone, gender, age, salary);
    }
    public Admin(String citizenNumber, String name,String surname,String phone){
        super(citizenNumber, name, surname, phone);
    }
    @Override

    public void menu(Database database) {

        System.out.println("Adminn menu");
    }

    @Override


    public String toString2() {
        return null;
    }

    //@Override
    //public abstract void menu(Database data,Staff staff){}

}
