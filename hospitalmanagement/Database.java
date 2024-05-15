package hospitalmanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database {
    public Object read(String dataType ,String citizienNumber) {
        String csvFile = "Data/"+dataType+".csv";
        String line = "";
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                for (String column : data) {
                    if (citizienNumber.equals(data[0]) ) {
                        switch (dataType){
                            case "Staff":
                                if (data[3] == "Doctor"){
                                    Doctor doctor = new Doctor(data[0],data[1],data[2],data[4]);
                                    return doctor;
                                }
                                else if(data[3] == "Secretary"){
                                    Secretary secretary = new Secretary(data[0],data[1],data[2],data[4]);
                                    return  secretary;
                                }
                            case "Patient":
                                Patient patient = new Patient(data[0],data[1],data[2],data[4]);
                                return patient;
                        }
                    }else{
                        System.out.println("User not found of!");
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}