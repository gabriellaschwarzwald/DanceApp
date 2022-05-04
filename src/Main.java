import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String[] AllStudents = new String[500];
        AllStudents = ReadFile(AllStudents);

        Dance newDance = new Dance(AllStudents);

        Screen newScreen = new Screen(newDance);
        newScreen.setSize(750, 500);
        newScreen.setVisible(true);
        newScreen.FillList(newDance);

    }

    public static String[] ReadFile(String[] AllStudents) {
        Scanner scan = null;
        int counter = 0;

        try {
            scan = new Scanner(new File("StudentList.txt"));
        } catch (
                FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            AllStudents[counter] = line;
            counter++;
        }
        return AllStudents;
    }


}


