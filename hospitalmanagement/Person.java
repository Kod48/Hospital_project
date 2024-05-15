package hospitalmanagement;

public abstract class Person {
    private String citizenNumber;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String gender;
    private int age;

    public Person(){

    }
    public Person(String citizenNumber ,String name,String surname,String email,
                  String phone,String gender,int age) {
        this.citizenNumber = citizenNumber;
        this.setName(name);
        this.name = getName();
        this.setSurname(surname);
        this.surname = getSurname();
        this.email = email;
        this.phone = phone;
        this.setGender(gender);
        this.gender = getGender();
        this.age = age;
    }


    public Person(String citizenNumber, String name, String surname, String phone) {
        this.citizenNumber = citizenNumber;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }


    public String getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {

        this.gender = gender.substring(0, 1).toUpperCase() + gender.substring(1);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //end of the getters and setters


    @Override
    public String toString() {
        return  "Name:" + this.name+ "\n"+
                "Surname:" + this.surname+"\n"+
                "Citizen Number:" + this.citizenNumber+"\n"+
                "Email:" + this.email+"\n"+
                "Phone:" + this.phone+"\n"+
                "Age:" + this.age+"\n"+
                "Gender:" + this.gender+"\n";
    }
}
