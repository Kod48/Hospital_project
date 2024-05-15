package hospitalmanagement;
import java.io.*;
public class Database {
    public boolean create(String dataType, String[] newData) {
        String csvFile = "Data/" + dataType + ".csv";
        String csvSplitBy = ";";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < newData.length; i++) {
                sb.append(newData[i]);
                if (i < newData.length - 1) {
                    sb.append(csvSplitBy);
                }
            }
            bw.write(sb.toString());
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String dataType ,String citizienNumber) {
        boolean isFound = false;
        String csvFile = "Data/"+dataType+".csv";
        String line = "";
        String csvSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                for (String column : data) {
                    if (citizienNumber.equals(data[0]) ) {
                        isFound = true;
                        switch (dataType){
                            case "Staff":
                                if (data[3].equals("Doctor")){
                                    Doctor doctor = new Doctor(data[0],data[1],data[2],data[4]);
                                    return doctor;
                                }
                                else if(data[3].equals("Secretary")){
                                    Secretary secretary = new Secretary(data[0],data[1],data[2],data[4]);
                                    return  secretary;
                                }
                                else if(data[3].equals("Admin")){
                                    Admin admin = new Admin(data[0],data[1],data[2],data[4]);
                                    return  admin;
                                }
                            case "Patient":
                                Patient patient = new Patient(data[0],data[1],data[2],data[4]);
                                return patient;
                        }
                    }
                }
            }if (!isFound){
                System.out.println("User not found of!");
                return null;}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(String dataType, String citizenNumber, String[] updatedData) {
        String csvFile = "Data/" + dataType + ".csv";
        String tempFile = "Data/temp.csv";
        String line = "";
        String csvSplitBy = ";";
        boolean isUpdated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String header = br.readLine();
            if (header != null) {
                bw.write(header);
                bw.newLine();
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                if (citizenNumber.equals(data[0])) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < updatedData.length; i++) {
                        sb.append(updatedData[i]);
                        if (i < updatedData.length - 1) {
                            sb.append(csvSplitBy);
                        }
                    }
                    bw.write(sb.toString());
                    isUpdated = true;
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        File oldFile = new File(csvFile);
        File newFile = new File(tempFile);

        if (oldFile.delete()) {
            newFile.renameTo(oldFile);
        } else {
            return false;
        }

        return isUpdated;
    }


    public boolean delete(String dataType, String citizenNumber) {
        String csvFile = "Data/" + dataType + ".csv";
        String tempFile = "Data/temp.csv";
        String line = "";
        String csvSplitBy = ";";
        boolean isDeleted = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String header = br.readLine();
            if (header != null) {
                bw.write(header);
                bw.newLine();
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                if (!citizenNumber.equals(data[0])) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    isDeleted = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        File oldFile = new File(csvFile);
        File newFile = new File(tempFile);

        if (oldFile.delete()) {
            newFile.renameTo(oldFile);
        } else {
            return false;
        }

        return isDeleted;
    }


}