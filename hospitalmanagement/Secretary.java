package hospitalmanagement;

public class Secretary extends  Staff{
    //private IOoperations[] operations2;

    public Secretary(/*IOoperations[] operations,*/String citizenNumber, String name, String surname,
                     String email, String phone, String gender,
                     int age, int id, double salary) {

        super(citizenNumber, name, surname, email, phone, gender, age, id, salary);
    }


    @Override
    public String toString2() {
        return null;
    }

    //@Override
    //public abstract void menu(Database data,Staff staff){}


}
