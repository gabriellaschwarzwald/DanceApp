import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen2 extends JFrame{
    private JPanel MainPanel;
    private JPanel TopPanel;
    private JLabel TitleLabel;
    private JLabel ListLabel;
    private JLabel NumStudentsLabel;
    private JTextField NumStudentsText;
    private JLabel RevenueLabel;
    private JTextField RevenueText;
    private JList AttendingList;
    private JButton GoBackButton;
    private JButton RemoveButton;
    private DefaultListModel listStudentsModel2;

    Screen2(Dance newDance) {
        super("Prom Overlook!!");
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        listStudentsModel2 = new DefaultListModel();
        AttendingList.setModel(listStudentsModel2);

        NumStudentsText.setText(Integer.toString(newDance.StudentsAttendingList.size()));

        RevenueText.setText(Integer.toString(newDance.totalRevenue));

        AttendingList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            }
        });
        GoBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Screen newScreen = new Screen(newDance);
                newScreen.setSize(750, 500);
                newScreen.setVisible(true);
                newScreen.FillList(newDance);
            }
        });
        RemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentNumber2 = AttendingList.getSelectedIndex();
                int newRevenue = 0;
                newDance.StudentsAttendingList.remove(studentNumber2);
                NumStudentsText.setText(Integer.toString(newDance.StudentsAttendingList.size()));
                for(Student x : newDance.StudentsAttendingList) {
                    newRevenue = newRevenue + Integer.parseInt(x.getTicketPrice());
                }
                RevenueText.setText(Integer.toString(newRevenue));
                System.out.println("Removing person from list: " + newDance.StudentsAttendingList.get(studentNumber2));
                FillList2(newDance);
            }
        });
    }
        public void FillList2(Dance newDance){
            listStudentsModel2.removeAllElements();
            System.out.println("Removing all people from list");
            for (Student x : newDance.StudentsAttendingList) {
                System.out.println("Adding person to list: " + x.getName() + " " + x.getSurname());
                listStudentsModel2.addElement(x.getNameAndSurname());
            }
        }
}

