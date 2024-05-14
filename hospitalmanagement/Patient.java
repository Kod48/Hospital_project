package hospitalmanagement;

public class Patient extends Person{
    public Patient(String citizenNumber, String name, String surname,
                   String email, String phone, String gender, int age) {
        super(citizenNumber, name, surname, email, phone, gender, age);
    }
}
