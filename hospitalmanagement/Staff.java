package hospitalmanagement;

import operations.IOOperations;

public  abstract class Staff extends Person{

    protected IOOperations[] operations;

    private double salary;
  
    public Staff(String citizenNumber, String name,String surname, String email, String phone, String gender, int age,double salary) {
        super(citizenNumber, name, surname, email, phone, gender, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    //@Override
    public abstract void menu(Database data,Staff staff);

    @Override
    public String toString() {
        return super.toString() +
                "Salary:" + this.salary+ " $" + "\n";
    }

    public abstract String toString2();
}
