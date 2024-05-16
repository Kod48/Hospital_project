package operations;
import hospitalmanagement.Database;

import java.util.Scanner;

public class Exit implements IOOperations{

    @Override
    public void oper(Database database) {
        System.out.println("Exit");
    }
}
