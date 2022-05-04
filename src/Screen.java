import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JFrame {
    private JPanel MainPanel;
    private JPanel TopPanel;
    private JLabel TitleLabel;
    private JPanel BottomPanel;
    private JPanel LeftPanel;
    private JLabel NameLabel;
    private JLabel SurnameLabel;
    private JLabel SchoolGradeLabel;
    private JLabel TicketLabel;
    private JPanel RightPanel;
    private JList ListStudents;
    private JTextArea NameText;
    private JTextArea SurnameText;
    private JTextArea SchoolGradeText;
    private JTextArea TicketText;
    private JButton TicketButton;
    private JButton OverlookButton;
    private JTextField KeyText;
    private JButton FindButton;
    private JScrollPane ScrollPane;
    private JLabel TicketsLabel;
    private JTextField TicketsBoughtText;

    private DefaultListModel listStudentsModel;


    Screen(Dance newDance) {
        super("Prom!!");
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        listStudentsModel = new DefaultListModel();
        ListStudents.setModel(listStudentsModel);


        FindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchStudent(newDance);
            }
        });

        TicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuyTicket(newDance);
            }
        });

        OverlookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Screen2 newScreen2 = new Screen2(newDance);
                newScreen2.setSize(500, 400);
                newScreen2.setVisible(true);
                newScreen2.FillList2(newDance);
            }
        });

        ListStudents.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int studentNumber = ListStudents.getSelectedIndex();
                if (studentNumber >= 0) {
                    Student x = newDance.AllStudentsList.get(studentNumber);
                    NameText.setText("  " + x.getName());
                    SurnameText.setText("  " + x.getSurname());
                    SchoolGradeText.setText("  " + x.getSchoolGrade());
                    TicketText.setText("  " + x.getTicketPrice());
                }
            }
        });
    }

    private void BuyTicket(Dance newDance) {
        int studentNumber = ListStudents.getSelectedIndex();
        if (studentNumber >= 0) {
            Student x = newDance.AllStudentsList.get(studentNumber);
                newDance.StudentsAttendingList.add(x);
                newDance.totalRevenue = newDance.totalRevenue + Integer.parseInt(x.getTicketPrice());
                TicketsBoughtText.setText(Integer.toString(newDance.StudentsAttendingList.size()));
            }
        }

    public void FillList(Dance newDance) {
        listStudentsModel.removeAllElements();
        System.out.println("Removing all people from list");
        for (Student a : newDance.AllStudentsList) {
            System.out.println("Adding person to list: " + a.getName() + " " + a.getSurname());
            listStudentsModel.addElement(a.getNameAndSurname());
        }
    }
    public void SearchStudent(Dance newDance){
        int left = 0;
        int right = newDance.AllStudentsList.size();
        int midpoint;
        String key = KeyText.getText();
        System.out.println();
        System.out.println("key: " + key);

        while (left <= right) {
            midpoint = (left + right) / 2;
            int result = ((newDance.AllStudentsList.get(midpoint).getName()).compareTo(key));
            if (result == 0) {
                System.out.println(newDance.AllStudentsList.get(midpoint).toString());
                NameText.setText(newDance.AllStudentsList.get(midpoint).getName());
                SurnameText.setText(newDance.AllStudentsList.get(midpoint).getSurname());
                SchoolGradeText.setText(newDance.AllStudentsList.get(midpoint).getSchoolGrade());
                listStudentsModel.removeAllElements();
                listStudentsModel.addElement(newDance.AllStudentsList.get(midpoint).getNameAndSurname());
                break;
            }
            else if (result < 0)
                left = midpoint + 1;
            else
                right = midpoint - 1;
        }
    }
    }







