package operations;

import hospitalmanagement.Database;

public class Fire implements IOOperations{

    @Override
    public void oper(Database database,Object staff) {
        System.out.println("Fire");
    }
}
