package hospitalmanagement;

public class Secretary extends  Staff{
    //private IOoperations[] operations2;

    public Secretary(/*IOoperations[] operations,*/String citizenNumber, String name, String surname,
                     String email, String phone, String gender,
                     int age, int id, double salary) {
        super(citizenNumber, name, surname, email, phone, gender, age, salary);
    }
  
    public Secretary(String citizenNumber, String name,String surname,String phone){
        super(citizenNumber, name, surname, phone);
    }
    @Override
    public void menu(Database data,Object staff) {
        System.out.println("menu");

    }

    @Override
    public String toString2() {
        return null;
    }




}
