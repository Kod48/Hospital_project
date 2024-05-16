package operations;

import hospitalmanagement.Database;

public class Fire implements IOOperations{

    @Override
    public void oper(Database database) {
        System.out.println("Fire");
    }
}
