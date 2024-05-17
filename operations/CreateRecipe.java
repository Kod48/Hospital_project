package operations;
import hospitalmanagement.Database;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateRecipe implements IOOperations{
    @Override
    public void oper(Database database , Object staff) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the patient's ID:");
        String patientCitizenNumber = scanner.nextLine();
        String recipeCode;

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            codeBuilder.append(characters.charAt(index));
        }
        //database.update("Appointment", patientCitizenNumber , database.read("Patient" , "patientCitizenNumber"));


    }
}
