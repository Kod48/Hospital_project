package hospitalmanagement;

public  abstract class Staff extends Person{

    //private IOoperations[] operations;
    private int id;
    private double salary;

    public Staff(/*IOoperations[] operations,*/String citizenNumber, String name,
                 String surname, String email, String phone,
                 String gender, int age,int id,double salary) {

        super(citizenNumber, name, surname, email, phone, gender, age);
        this.id = id;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //end of the getter and setter

    //@Override
    //public abstract void menu(Database data,Staff staff){}

    @Override
    public String toString() {
        return super.toString() +
                "ID:" + this.id + "\n"+
                "Salary:" + this.salary+ " $" + "\n";
    }

    public abstract String toString2();

}
