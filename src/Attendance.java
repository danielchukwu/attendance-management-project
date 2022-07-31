import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Attendance {

    ArrayList <String> attendanceArray = new ArrayList();

    void takeAttendance () {
        JFrame f = new JFrame();              // create frame
        f.setSize(800, 400);     // set size of frame (width and height)
        f.setLayout(new GridLayout(3,2));    // set grid layout of frame (rows and colums)

        // Name: label and text-field and add both to frame
        JLabel nameLabel = new JLabel("Name");
        JTextField nameText = new JTextField();
        f.add(nameLabel);
        f.add(nameText);

        // Matric Number: label and text-field and add both to frame
        JLabel matricLabel = new JLabel("Name");
        JTextField matricText = new JTextField();
        f.add(matricLabel);
        f.add(matricText);

        // Submit Button
        JButton submitButton = new JButton("ENTER");
        f.add(submitButton);

        // Make frame visible
        f.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);

                // Extract nameText and matricText
                String name1 = nameText.getText();
                String matric1 = matricText.getText();
                String nameAndMatric = "Name: " + name1 + ", Matric Number: " + matric1 + " | ";

                // write info to file
                try {
                    FileWriter aFile = new FileWriter("attendance.txt");

                    attendanceArray.add(nameAndMatric); // add nameAndMatric to our Global Array in line 11

                    // loop our Global Array in line 11 and
                    for (int i = 0; i < attendanceArray.toArray().length; i++) {
                        aFile.append(attendanceArray.get(i));
                    }

                    aFile.close();
                } catch (Exception anError) {
                    System.out.println("");
                }

                // call attendanceTaken method
                attendanceTaken();
            }
        });
    }

    void attendanceTaken () {
        JFrame f = new JFrame();              // create frame
        f.setSize(800, 400);     // set size of frame (width and height)
        f.setLayout(new GridLayout(1,2));    // set grid layout of frame (rows and colums)

        // add another Attendance Button
        JButton addAnotherButton = new JButton("Successfully Added. Add Another Attendance");

        // make frame visible
        f.setVisible(true);
        f.add(addAnotherButton);

        addAnotherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                takeAttendance();
            }
        });
    }

}
