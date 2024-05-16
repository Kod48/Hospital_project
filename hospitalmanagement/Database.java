package hospitalmanagement;
import java.io.*;
public class Database {
    public void create(String dataType, String newData) {

        String csvFile = "Data/" + dataType + ".csv";
        String csvSplitBy = ";";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) { //new FileWriter(csvFile, true) kısmı dosyanın ekleme modunda (append mode) açılmasını sağlar. Yani dosyanın sonuna yeni veri eklenir, mevcut veriler silinmez.
            bw.write(newData);
            bw.newLine();
            System.out.println("Created successfuly");
        } catch (IOException e) {
            e.printStackTrace();
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

    public boolean update(String dataType, String citizenNumber, String updateType, String newValue) {

        String csvFile = "Data/" + dataType + ".csv";
        String tempFile = "Data/temp.csv";
        String line = "";
        String csvSplitBy = ";";
        boolean isUpdated = false;
        int updateIndex = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String header = br.readLine();
            if (header != null) {
                bw.write(header);
                bw.newLine();
                String[] titles = header.split(csvSplitBy);

                // Find the index of the column to update
                for (int i = 0; i < titles.length; i++) {
                    if (titles[i].equals(updateType)) {
                        updateIndex = i;
                        break;
                    }
                }
            }

            if (updateIndex == -1) {
                System.out.println("Update type not found in the header!");
                return false;
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                if (citizenNumber.equals(data[0])) {
                    data[updateIndex] = newValue;
                    isUpdated = true;
                }
                bw.write(String.join(csvSplitBy, data));//data dizisini tekrar CSV formatına uygun şekilde birleştirir.
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
            newFile.renameTo(oldFile);//Bu işlem, geçici dosyanın orijinal dosya yerine geçmesini sağlar
        } else {
            return false;
        }
        return isDeleted;
    }
}