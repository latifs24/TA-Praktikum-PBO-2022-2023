package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {

    JRadioButton radioButton1, radioButton2, radioButton3;
    ButtonGroup buttonGroup = new ButtonGroup();
    public Test()
    {
        radioButton1 = new JRadioButton("Reservasi");
        radioButton1.setBounds(3,3,50,50);
        radioButton2 = new JRadioButton("Check In");
        radioButton2.setBounds(60,60,50,50);
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        radioButton2.setEnabled(false);

        add(radioButton1);
        add(radioButton2);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
}
