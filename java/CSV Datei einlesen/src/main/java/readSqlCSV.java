import java.io.BufferedReader;
import java.io.FileReader;

public class readSqlCSV {

    public static void addFromCSVFilePersonal(String filepath) {
        int count = 0;
        String res = "";
        try {
            BufferedReader r = new BufferedReader(new FileReader(filepath));
            while(r.ready()) {
                if(count == 0){
                    String line = r.readLine();
                    String[] firstLineSplit = line.split(",");
                    res = "INSERT INTO personal(" + firstLineSplit[0] + "," + firstLineSplit[1] + "," + firstLineSplit[2] + "," + firstLineSplit[3] + "," + firstLineSplit[4] + ")";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    System.out.println(res + "\n" + "VALUES ('" + lineSplit[0] + "','" + lineSplit[1] + "','" + lineSplit[2] + "'," + "'" + lineSplit[3] + "','"+ lineSplit[4] + "');");
                }
            }
            r.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFromCSVFilePatient(String filepath) {
        int count = 0;
        String res = "";
        try {
            BufferedReader r = new BufferedReader(new FileReader(filepath));
            while(r.ready()) {
                if(count == 0){
                    String line = r.readLine();
                    String[] firstLineSplit = line.split(",");
                    res = "INSERT INTO patient(" + firstLineSplit[0] + "," + firstLineSplit[1] + "," + firstLineSplit[2] + "," + firstLineSplit[3] + "," + firstLineSplit[4] + "," + firstLineSplit[5] +  ")";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    String[] dateSplit = lineSplit[2].split("\\.");
                    System.out.println(res + "\n" + "VALUES ('" + lineSplit[0] + "','" + lineSplit[1] + "','" + dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit [0]  + "'," + "'" + lineSplit[3] + "','"+ lineSplit[4] + "','" +  lineSplit[5] + "');");
                }
            }
            r.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFromCSVFileBehandlung(String filepath) {
        int count = 0;
        String res = "";
        try {
            BufferedReader r = new BufferedReader(new FileReader(filepath));
            while(r.ready()) {
                if(count == 0){
                    String line = r.readLine();
                    String[] firstLineSplit = line.split(",");
                    res = "INSERT INTO behandlung(" + firstLineSplit[0] + "," + firstLineSplit[1] + "," + firstLineSplit[2] + "," + firstLineSplit[3] + "," + firstLineSplit[4] + "," + firstLineSplit[5] + ")";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    System.out.println(res + "\n" + "VALUES ('" + lineSplit[0] + "'" + "," + "'" + lineSplit[1] + "'" + "," + "'" + lineSplit[2] + "'" + "," + "'" + lineSplit[3] + "'" + "," + "'" + lineSplit[4] + "'" + "," + "'" + lineSplit[5] + "');");
                }
            }
            r.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFromCSVFileZimmer(String filepath) {
        int count = 0;
        String res = "";
        try {
            BufferedReader r = new BufferedReader(new FileReader(filepath));
            while(r.ready()) {
                if(count == 0){
                    String line = r.readLine();
                    String[] firstLineSplit = line.split(",");
                    res = "INSERT INTO zimmer(" + firstLineSplit[0] + "," + firstLineSplit[1] + "," + firstLineSplit[2] + "," + firstLineSplit[3] +  ")";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    System.out.println(res + "\n" + "VALUES (" + lineSplit[0] + "," + lineSplit[1] + "," + lineSplit[2] + "," + "'" + lineSplit[3] + "');");
                }
            }
            r.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //addFromCSVFilePersonal("../../Ressources/personal.csv");
        //addFromCSVFilePatient("../../Ressources/PatientList.csv");
        addFromCSVFileZimmer("../../Ressources/RoomList.csv");
        //addFromCSVFileBehandlung("../../Ressources/treatmesnt.csv");
    }

}
