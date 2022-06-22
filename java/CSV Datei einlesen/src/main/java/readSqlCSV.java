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
                    res = "INSERT INTO personal(personal_id,vorname,nachname,berufsbezeichnung,verfügbarkeit)";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    String[] nameSplit = lineSplit[1].split(" ");
                    System.out.println(res + "\n" + "VALUES ('" + lineSplit[0] + "','" + nameSplit[0] + "','"  + nameSplit[1] +  "','" + lineSplit[2] + "'," + "'" + lineSplit[3] + "');");
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
                    res = "INSERT INTO patient(" + firstLineSplit[0] + ",vorname,nachname"  + ",geburtsdatum," + firstLineSplit[3] + ",patientenstatus" +  ")";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    String[] dateSplit = lineSplit[2].split("\\.");
                    String[] nameSplit = lineSplit[1].split(" ");
                    System.out.println(res + "\n" + "VALUES ('" + lineSplit[0] + "','" + nameSplit[0] + "','" + nameSplit[1] + "','"  + dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit [0]  + "'," + "'" + lineSplit[3] + "','"+ lineSplit[4] + "');");
                }
            }
            r.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFromCSVFileBehandlung(String filepath) {
        int count = 0;
        int behandlungsID = 1;
        String res = "";
        try {
            BufferedReader r = new BufferedReader(new FileReader(filepath));
            while(r.ready()) {
                if(count == 0){
                    String line = r.readLine();
                    String[] firstLineSplit = line.split(",");
                    res = "INSERT INTO behandlung(behandlungs_id,kv_nummer,diagnose,personal_id,behandlungs_start,behandlungs_ende)";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    System.out.println(res + "\n" + "VALUES ('" + behandlungsID + "'" + "," + "'" + lineSplit[1] + "'" + ","  + "'" + lineSplit[2] + "'" + "," + "'" + lineSplit[4] + "'" + "," + "'" + lineSplit[5] + "','" + lineSplit[6] +"');");
                    behandlungsID++;
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
                    res = "INSERT INTO zimmer(" + "zimmernummer" +  "," + firstLineSplit[2] + ")";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    System.out.println(res + "\n" + "VALUES (" + lineSplit[0] + "," + lineSplit[2] +");");
                }
            }
            r.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFromCSVFileZimmerbelegung(String filepath) {
        int count = 0;
        String res = "";
        try {
            BufferedReader r = new BufferedReader(new FileReader(filepath));
            while(r.ready()) {
                if(count == 0){
                    String line = r.readLine();
                    String[] firstLineSplit = line.split(",");
                    res = "INSERT INTO zimmerbelegung(" + "zimmernummer" +  ",kv_nummer)";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    System.out.println(res + "\n" + "VALUES (" + lineSplit[0] + ",'" + lineSplit[3] +"');");
                }
            }
            r.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFromCSVFileSchicht(String filepath) {
        int count = 0;
        String res = "";
        try {
            BufferedReader r = new BufferedReader(new FileReader(filepath));
            while(r.ready()) {
                if(count == 0){
                    String line = r.readLine();
                    String[] firstLineSplit = line.split(",");
                    res = "INSERT INTO schicht(schicht_id,jahr,kw,schichtart,personal_id)";
                    count++;
                }
                else {
                    String line = r.readLine();
                    String[] lineSplit = line.split(",");
                    System.out.println(res + "\n" + "VALUES (" + lineSplit[0] + "," + lineSplit[2] + "," + lineSplit[1] + ",'"+ lineSplit[3] + "','" + lineSplit[4] + "');");
                }
            }
            r.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //addFromCSVFilePersonal("/Users/jonaswonneberger/Library/Mobile Documents/com~apple~CloudDocs/Desktop/Allgemeines/Informatik Studium/2. Semster/Datenbanken/personal.csv");
        //addFromCSVFilePatient("/Users/jonaswonneberger/Library/Mobile Documents/com~apple~CloudDocs/Desktop/Allgemeines/Informatik Studium/2. Semster/Datenbanken/PatientList.csv");
        //addFromCSVFileZimmer("/Users/jonaswonneberger/Library/Mobile Documents/com~apple~CloudDocs/Desktop/Allgemeines/Informatik Studium/2. Semster/Datenbanken/RoomList.csv");
        //addFromCSVFileBehandlung("/Users/jonaswonneberger/Library/Mobile Documents/com~apple~CloudDocs/Desktop/Allgemeines/Informatik Studium/2. Semster/Datenbanken/treatments.csv");
        addFromCSVFileZimmerbelegung("/Users/jonaswonneberger/Library/Mobile Documents/com~apple~CloudDocs/Desktop/Allgemeines/Informatik Studium/2. Semster/Datenbanken/RoomList.csv");
        //addFromCSVFileSchicht("/Users/jonaswonneberger/Library/Mobile Documents/com~apple~CloudDocs/Desktop/Allgemeines/Informatik Studium/2. Semster/Datenbanken/shift.csv");
    }

}
