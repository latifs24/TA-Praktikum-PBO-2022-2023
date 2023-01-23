package View;
import Controllers.AkunController;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
public class LoginGUI
{
    GUIController guiController = new GUIController();
    ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/AppIcon.png"));
    JFrame frame = new JFrame();
    JLabel unameLabel, passwLabel, loveHotelLabel, iconHeart;
    JTextField unametxt;
    JPasswordField passwtxt;
    JCheckBox showpassw;
    String [] listLoginAs = new String[] {"Admin", "Staff"};
    JComboBox comboBoxLogin;
    JButton buttonLogin;
    Boolean loginAs = true;
    public LoginGUI() throws IOException, FontFormatException
    {
        //LoveHotelmainLabel
        Font font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/fonts/Love.ttf"));
        loveHotelLabel = new JLabel("LOVE HoteL", SwingConstants.CENTER);
        loveHotelLabel.setFont(font.deriveFont(Font.BOLD, 38));
        loveHotelLabel.setBounds(62, 77, 270,71);
        //Label
        unameLabel = new JLabel("Username");
        unameLabel.setBounds(76,317,60,25);
        passwLabel = new JLabel("Password");
        passwLabel.setBounds(76,369,60,25);
        //textfield
        unametxt = new JTextField();
        unametxt.setBounds(146, 317, 149, 25);
        passwtxt = new JPasswordField();
        passwtxt.setBounds(146, 369, 149, 25);
        //BackgroundImage
        iconHeart = new JLabel();
        iconHeart.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/loginBg.png")));
        Dimension size = iconHeart.getPreferredSize();
        iconHeart.setBounds(30,122,size.width,size.height);
        //CheckBoxShowPassword
        showpassw = new JCheckBox("Show Password");
        showpassw.setBounds(146,406, 125,17);
        showpassw.setOpaque(false);
        showpassw.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    passwtxt.setEchoChar((char) 0);
                else
                    passwtxt.setEchoChar('*');
            }
        });
        //ComboBoxLoginSebagai?
        comboBoxLogin = new JComboBox<>(listLoginAs);
        comboBoxLogin.setBounds(123,215, 150,25);
        comboBoxLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxLogin.getSelectedIndex() == 0)
                    loginAs = true;
                else if (comboBoxLogin.getSelectedIndex() == 1)
                    loginAs = false;
            }
        });
        //JbuttonLogin
        buttonLogin = new JButton("Loginkan");
        buttonLogin.setBounds(157,450,87,32);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (guiController.cekLogin(loginAs, unametxt.getText(), String.valueOf(passwtxt.getPassword())))
                {
                    emptying();
                    frame.dispose();
                    if (loginAs)
                        try { new AdminGUI(); } catch (IOException ex) { throw new RuntimeException(ex); }
                    else {
                        try {
                            new AdminGUI();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else
                {
                    emptying();
                    JOptionPane.showMessageDialog(null,
                            "Username atau Password Salah", "Login Gagal", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //AddToFrame
        frame.add(unameLabel);
        frame.add(unametxt);
        frame.add(passwLabel);
        frame.add(passwtxt);
        frame.add(loveHotelLabel);
        frame.add(showpassw);
        frame.add(comboBoxLogin);
        frame.add(buttonLogin);
        frame.add(iconHeart);
        //FrameSetup
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setTitle("Love Hotel");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(new java.awt.Color(255,201,245));
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Apkh benar ingin Meninggoy?", "Ingin Meninggoy",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Farewell..", "Pesan terakhir", JOptionPane.WARNING_MESSAGE);
                    frame.dispose();
                }
                else
                    emptying();
            }
        });
        frame.getRootPane().setDefaultButton(buttonLogin);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
    }
    public void emptying()
    {
        unametxt.setText("");
        passwtxt.setText("");
    }
}
