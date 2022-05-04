import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dance {

    public static final int MaxCapacity = 200;
    public int numStudents;
    public int totalRevenue;
    public ArrayList<Student> AllStudentsList;
    public ArrayList<Student> StudentsAttendingList;


    public Dance(String[] AllStudents) {
        this.totalRevenue = 0;
        this.numStudents = 0;
        AllStudentsList = new ArrayList<Student>();
        StudentsAttendingList = new ArrayList<Student>();
        InfoToAllStudentsArray(AllStudents);
    }

    public int getNumStudents() {
        return numStudents;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void InfoToAllStudentsArray(String[] AllStudents) {
        for (int i = 0; i < AllStudents.length; i++) {
            if (AllStudents[i] == null)
                break;
            else {
                String[] arrOfStr = AllStudents[i].split(" ", 0);
                Student newStudent = new Student(arrOfStr[0], arrOfStr[1], arrOfStr[3], arrOfStr[4]);
                AllStudentsList.add(newStudent);
                numStudents++;
            }
        }
        for (Student x : AllStudentsList)
            System.out.println(x.toString());
    }
}



