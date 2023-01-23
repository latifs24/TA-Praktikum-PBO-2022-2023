package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

public class AdminGUI extends JFrame
{
    JLabel background, addLabel, viewLabel, updtLabel, deleteLabel, loveHotelLabel;
    JLabel usernameLabel, passwordLabel, topLabel;
    JButton addButton,viewButton,updateButton,deleteButton, logoutButton, exitButton, backButton, submitButton;
    JTable tableAccount;
    JPanel panel;
    JList listAccount;
    JTextArea description = new JTextArea();
    JTextField addUsertext, addPasstext;
    JScrollPane scrollPaneView, scrollPaneList;
    BufferedImage srcImgAddButton, srcImgAddButtonC, srcImgAddButtonP;  //Button C = Clicked. P = Pointed.
    BufferedImage srcImgViewButton, srcImgViewButtonC, srcImgViewButtonP;
    BufferedImage srcImgUpdtButton, srcImgUpdtButtonC, srcImgUpdtButtonP;
    BufferedImage srcImgDeleteButton, srcImgDeleteButtonC, srcImgDeleteButtonP;
    BufferedImage srcImgLogout, srcImgExit,  srcBackIcon, srcSubmitIcon;
    Image imgResAddB, imgResAddBC, imgResAddBP;
    Image imgResViewB, imgResViewBC, imgResViewBP;
    Image imgResUpdtB, imgResUpdtBC, imgResUpdtBP;
    Image imgResDeleteB, imgResDeleteBC, imgResDeleteBP;
    Image imgResLogout, imgResExit, imgResLogoutC, imgResExitC;
    Image backIconResize, backIconResizeP, submitIconResize, submitIconResizeP;
    ImageIcon addIcon, addIconC, addIconP;
    ImageIcon viewIcon, viewIconC, viewIconP;
    ImageIcon updtIcon, updtIconC, updtIconP;
    ImageIcon deleteIcon, deleteIconC, deleteIconP;
    ImageIcon logoutIcon, exitIcon,logoutIconC, exitIconC, frameIcon, backIcon, backIconP, submitIcon, submitIconP;
    ImageIcon kita_chanIcon, bocchiIcon, bocchiWarning;
    Integer indexSelectedJlist;
    String textAreaArgument;
    DefaultTableModel tableData = new DefaultTableModel();
    Object[] column = {"Username", "Password"};
    Font font = null;
    GUIController guiController = new GUIController();

    private void initializeIcon() throws IOException {
        //Import image from Resource.
        srcImgAddButton = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/adduser.png"));
        srcImgAddButtonC = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/adduserClicked.png"));
        srcImgAddButtonP = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/adduserPointed.png"));
        //---------//
        srcImgViewButton = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/viewuser.png"));
        srcImgViewButtonC = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/viewuserClicked.png"));
        srcImgViewButtonP = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/viewuserPointed.png"));
        //---------//
        srcImgUpdtButton = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/updateuser.png"));
        srcImgUpdtButtonC = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/updateuserClicked.png"));
        srcImgUpdtButtonP = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/updateuserPointed.png"));
        //---------//
        srcImgDeleteButton = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/deleteuser.png"));
        srcImgDeleteButtonC = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/deleteuserClicked.png"));
        srcImgDeleteButtonP = ImageIO.read(this.getClass().getClassLoader().getResource("img/Admin/deleteuserPointed.png"));
        //---------//
        srcImgExit = ImageIO.read(this.getClass().getClassLoader().getResource("img/MainIcons/exit.png"));
        srcBackIcon = ImageIO.read(this.getClass().getClassLoader().getResource("img/MainIcons/back.png"));
        srcImgLogout = ImageIO.read(this.getClass().getClassLoader().getResource("img/MainIcons/logout.png"));
        srcSubmitIcon = ImageIO.read(this.getClass().getClassLoader().getResource("img/MainIcons/submit.png"));

        //Resize Image.
        imgResAddB = srcImgAddButton.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        imgResAddBC = srcImgAddButtonC.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        imgResAddBP = srcImgAddButtonP.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        //---------//
        imgResViewB = srcImgViewButton.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        imgResViewBC = srcImgViewButtonC.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        imgResViewBP = srcImgViewButtonP.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        //---------//
        imgResUpdtB = srcImgUpdtButton.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        imgResUpdtBC = srcImgUpdtButtonC.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        imgResUpdtBP = srcImgUpdtButtonP.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        //---------//
        imgResDeleteB = srcImgDeleteButton.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        imgResDeleteBC = srcImgDeleteButtonC.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        imgResDeleteBP = srcImgDeleteButtonP.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        //---------//
        imgResExit = srcImgExit.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        imgResExitC = srcImgExit.getScaledInstance(71,71, Image.SCALE_SMOOTH);
        imgResLogout = srcImgLogout.getScaledInstance(80,80, Image.SCALE_SMOOTH);
        imgResLogoutC = srcImgLogout.getScaledInstance(76,76, Image.SCALE_SMOOTH);
        backIconResize = srcBackIcon.getScaledInstance(75,75, Image.SCALE_SMOOTH);
        backIconResizeP = srcBackIcon.getScaledInstance(71,71, Image.SCALE_SMOOTH);
        submitIconResize = srcSubmitIcon.getScaledInstance(54,33, Image.SCALE_SMOOTH);
        submitIconResizeP = srcSubmitIcon.getScaledInstance(50,29, Image.SCALE_SMOOTH);

        //Set Icon JButton
        addIcon = new ImageIcon(imgResAddB);
        addIconC = new ImageIcon(imgResAddBC);
        addIconP = new ImageIcon(imgResAddBP);
        viewIcon = new ImageIcon(imgResViewB);
        viewIconC = new ImageIcon(imgResViewBC);
        viewIconP = new ImageIcon(imgResViewBP);
        updtIcon = new ImageIcon(imgResUpdtB);
        updtIconC = new ImageIcon(imgResUpdtBC);
        updtIconP = new ImageIcon(imgResUpdtBP);
        deleteIcon = new ImageIcon(imgResDeleteB);
        deleteIconC = new ImageIcon(imgResDeleteBC);
        deleteIconP = new ImageIcon(imgResDeleteBP);
        logoutIcon = new ImageIcon(imgResLogout);
        exitIcon = new ImageIcon(imgResExit);
        logoutIconC = new ImageIcon(imgResLogoutC);
        exitIconC = new ImageIcon(imgResExitC);
        backIcon = new ImageIcon(backIconResize);
        backIconP = new ImageIcon(backIconResizeP);
        submitIcon = new ImageIcon(submitIconResize);
        submitIconP = new ImageIcon(submitIconResizeP);
        frameIcon = new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/AppIcon.png"));
        kita_chanIcon = new ImageIcon(this.getClass().getClassLoader().getResource("img/Admin/sweetWarning.png"));
        bocchiIcon = new ImageIcon(this.getClass().getClassLoader().getResource("img/Admin/strunggling warning.png"));
        bocchiWarning = new ImageIcon(this.getClass().getClassLoader().getResource("img/Admin/bocchiWarning.png"));
    }

    private void initializeButton()
    {
        //Setup JButton & Label.
        addLabel = new JLabel("Create Account");
        addLabel.setFont(new Font("Candara", Font.BOLD, 24));
        addLabel.setBounds(310,372,200,40);
        addButton = new JButton();
        addButton.setIcon(addIcon);
        addButton.setBounds(300,192,200,200);
        addButton.setOpaque(false);
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setRolloverEnabled(true);
        addButton.setPressedIcon(addIconP);
        addButton.setRolloverIcon(addIconC);
        addButton.add(addLabel);
        //---------//
        viewLabel = new JLabel("List Account");
        viewLabel.setFont(new Font("Candara", Font.BOLD, 24));
        viewLabel.setBounds(910,372,200,40);
        viewButton = new JButton();
        viewButton.setIcon(viewIcon);
        viewButton.setBounds(875,192,200,200);
        viewButton.setOpaque(false);
        viewButton.setBorderPainted(false);
        viewButton.setContentAreaFilled(false);
        viewButton.setRolloverEnabled(true);
        viewButton.setPressedIcon(viewIconP);
        viewButton.setRolloverIcon(viewIconC);
        //---------//
        updtLabel = new JLabel("Update Account");
        updtLabel.setFont(new Font("Candara", Font.BOLD, 24));
        updtLabel.setBounds(310,620,200,40);
        updateButton = new JButton();
        updateButton.setIcon(updtIcon);
        updateButton.setBounds(300,430,200,200);
        updateButton.setOpaque(false);
        updateButton.setBorderPainted(false);
        updateButton.setContentAreaFilled(false);
        updateButton.setRolloverEnabled(true);
        updateButton.setPressedIcon(updtIconP);
        updateButton.setRolloverIcon(updtIconC);
        //---------//
        deleteLabel = new JLabel("Delete Account");
        deleteLabel.setFont(new Font("Candara", Font.BOLD, 24));
        deleteLabel.setBounds(905,620,200,40);
        deleteButton = new JButton();
        deleteButton.setIcon(deleteIcon);
        deleteButton.setBounds(890,430,200,200);
        deleteButton.setOpaque(false);
        deleteButton.setBorderPainted(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setRolloverEnabled(true);
        deleteButton.setPressedIcon(deleteIconP);
        deleteButton.setRolloverIcon(deleteIconC);
        //---------//
        logoutButton = new JButton();
        logoutButton.setIcon(logoutIcon);
        logoutButton.setBounds(2,10,80,80);
        logoutButton.setOpaque(false);
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setRolloverEnabled(true);
        logoutButton.setPressedIcon(logoutIcon);
        logoutButton.setRolloverIcon(logoutIconC);
        logoutButton.setToolTipText("Logout Account");
        //---------//
        exitButton = new JButton();
        exitButton.setIcon(exitIcon);
        exitButton.setBounds(4,100,75,75);
        exitButton.setOpaque(false);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setRolloverEnabled(true);
        exitButton.setPressedIcon(exitIconC);
        exitButton.setRolloverIcon(exitIconC);
        exitButton.setToolTipText("Exit Program");
        //---------//
        backButton = new JButton();
        backButton.setIcon(backIcon);
        backButton.setToolTipText("Back to Home Page");
        backButton.setBounds(3,12,75,75);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setPressedIcon(backIconP);
    }
    public AdminGUI() throws IOException
    {
        setSize(1366,768);
        initializeIcon();
        initializeButton();

        //SET JTable, JScrollPane, JList.
        tableAccount = new JTable(tableData);
        tableAccount.setEnabled(false);
        tableAccount.setBackground(new Color(255,209,220));
        tableAccount.getTableHeader().setReorderingAllowed(false);
        scrollPaneView = new JScrollPane(tableAccount);
        scrollPaneView.setBorder(BorderFactory.createLineBorder(new Color(255,105,180), 3));
        scrollPaneView.setBounds(532,200,300,350);
        listAccount = new JList<>();
        description.setBounds(900,200,200,100);
        description.setEditable(false);

        //LoveHotelmainLabel
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/fonts/Love.ttf"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
        loveHotelLabel = new JLabel("LOVE HoteL");
        loveHotelLabel.setFont(font.deriveFont(Font.BOLD, 48));
        loveHotelLabel.setForeground(Color.BLACK);
        Font loveHotelFont = loveHotelLabel.getFont();
        Map attributes = loveHotelFont.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        loveHotelLabel.setFont(font.deriveFont(attributes));
        loveHotelLabel.setBounds(550, 75, 350,71);

        //ActionListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createAccount();
                } catch (IOException ex) { throw new RuntimeException(ex); }
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAccount();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { updateAccount(); }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { deleteAccount(); }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { homePageContents(); description.setText(""); }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Apkh benar ingin Logout?", "Perihal ingin Logout",
                        JOptionPane.YES_NO_OPTION,  JOptionPane.WARNING_MESSAGE);
                if (confirmed == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Adios Bruh...", "Pesan Terakhir",
                            JOptionPane.WARNING_MESSAGE);
                    try {
                        dispose();
                        new LoginGUI();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Baiklah Tetaplah Disini bersama bayanganmu");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Apkh benar ingin Meninggoy?", "Perihal Ingin Meninggoy",
                        JOptionPane.YES_NO_OPTION,  JOptionPane.WARNING_MESSAGE);
                if (confirmed == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Farewell..", "Pesan Terakhir",
                            JOptionPane.WARNING_MESSAGE);
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "Baiklah Tetaplah Hidup bersama Mimpimu");
            }
        });
        listAccount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int selectedItem = listAccount.getSelectedIndex();
                    indexSelectedJlist = selectedItem;
                    textAreaArgument = "Password : "+guiController.getPassword(selectedItem);
                    description.setText(textAreaArgument);
                }
            }
        });
        listAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedItem = listAccount.getSelectedIndex();
                    indexSelectedJlist = selectedItem;
                    textAreaArgument = "Password : "+guiController.getPassword(selectedItem);
                    description.setText(textAreaArgument);
                }
            }
        });

        //PANEL SETUP
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255,201,214));
        homePageContents();

        //FRAME SETUP
        setIconImage(frameIcon.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        getContentPane().add(panel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Apkh benar ingin Meninggoy?", "Ingin Meninggoy",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirmed == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Farewell..", "Pesan Terakhir",
                            JOptionPane.WARNING_MESSAGE);
                    dispose();
                }
                else
                        JOptionPane.showMessageDialog(null, "Baiklah Tetaplah Hidup bersama Mimpimu");
            }
        });
       }
       public void homePageContents()
       {
           resetPanel();
           addBackground(0);
           setTitle("Love Hotel Admin");
           panel.add(addButton);
           panel.add(addLabel);
           panel.add(viewButton);
           panel.add(viewLabel);
           panel.add(updateButton);
           panel.add(updtLabel);
           panel.add(deleteButton);
           panel.add(deleteLabel);
           panel.add(logoutButton);
           panel.add(exitButton);
           panel.add(loveHotelLabel);
       }
       public void addBackground(Integer posisi)
       {
           switch (posisi)
           {
               case 0 -> background = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/bocchiBg.png")));
               case 1 -> background = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("img/Admin/adminBG.png")));
           }
           switch (posisi)
           {
               case 0 -> background.setBounds(525,265,350,220);
               case 1 -> background.setBounds(225,200,350,350);
           }
           panel.add(background);
       }
       public void resetPanel()
       {
           panel.setLayout(null);
           panel.removeAll();
           panel.revalidate();
           panel.repaint();
       }

       public void createAccount() throws IOException
       {
           resetPanel();
           usernameLabel = new JLabel("Username ");
           usernameLabel.setBounds(580, 325,75,25);
           passwordLabel = new JLabel("Password ");
           passwordLabel.setBounds(580,360,75,25);
           addUsertext = new JTextField();
           addUsertext.setBounds(652,325,150,25);
           addPasstext = new JTextField();
           addPasstext.setBounds(652, 360,150,25);

           submitButton = new JButton();
           submitButton.setIcon(submitIcon);
           submitButton.setToolTipText("Submit");
           submitButton.setOpaque(false);
           submitButton.setBorderPainted(false);
           submitButton.setContentAreaFilled(false);
           submitButton.setPressedIcon(submitIconP);
           submitButton.setBounds(696,400,54,33);
           submitButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   if (addUsertext.getText().equals("") || addPasstext.getText().equals(""))
                   {
                       JOptionPane.showMessageDialog(null,
                               "Field tidak boleh Kosong!", "Field masih Kosong", JOptionPane.ERROR_MESSAGE);
                   }
                   else
                   {
                       int dialog = JOptionPane.showConfirmDialog(null,
                               "Apakah ingin menambahkan Akun? \n Kita-Kitaaa ^-^", "Serangan Kita Aura",
                               JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, kita_chanIcon);
                       if (dialog == 0)
                       {
                           guiController.createAccount(String.valueOf(addUsertext.getText()), String.valueOf(addPasstext.getText()));
                           JOptionPane.showMessageDialog(null,
                                   "Akun Staff berhasil ditambahkan!", "", JOptionPane.INFORMATION_MESSAGE);
                           addUsertext.setText("");
                           addPasstext.setText("");
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,
                                   "Proses Penambahan Akun dibatalkan!", "", JOptionPane.WARNING_MESSAGE);
                       }
                   }
               }
           });

           topLabel = new JLabel("Create Account");
           topLabel.setFont(font.deriveFont(Font.BOLD, 40));
           topLabel.setForeground(Color.BLACK);
           topLabel.setBounds(550, 75, 350,71);
           setTitle("Love Notel Admin : Create Account ");
           panel.add(usernameLabel);
           panel.add(addUsertext);
           panel.add(passwordLabel);
           panel.add(addPasstext);
           panel.add(backButton);
           panel.add(submitButton);
           panel.add(topLabel);
           addBackground(1);
       }
       public void refreshViewData()
       {
           tableData = (DefaultTableModel) tableAccount.getModel();
           tableData.setRowCount(0);
           tableData.setColumnIdentifiers(column);
           Object [] tempData = new Object[2];
           for (int i=0; i<guiController.getSizeData(); i++)
           {
               tempData[0] = " " + guiController.getUsername(i);
               tempData[1] = " " + guiController.getPassword(i);
               tableData.addRow(tempData);
           }

           if (guiController.getSizeData() == 0)
           {
               JOptionPane.showMessageDialog(null,
                       "Data Masih Kosong ehee :V",
                       "Data masih kosong", JOptionPane.INFORMATION_MESSAGE, bocchiIcon);
           }
       }
        public void viewAccount()
        {
            resetPanel();
            topLabel = new JLabel("View Account");
            topLabel.setFont(font.deriveFont(Font.BOLD, 40));
            topLabel.setForeground(Color.BLACK);
            topLabel.setBounds(550, 75, 350,71);
            setTitle("Love Hotel Admin : View Account ");
            refreshViewData();
            panel.add(topLabel);
            panel.add(scrollPaneView);
            panel.add(backButton);
            addBackground(1);
        }
        public void refreshListData()
        {
            listAccount.clearSelection();
            String [] tempData = new String[guiController.getSizeData()];
            for (int i=0; i<guiController.getSizeData(); i++)
            {
                tempData [i] = guiController.getUsername(i);
            }
            listAccount.setListData(tempData);
            if (guiController.getSizeData() == 0)
            {
                JOptionPane.showMessageDialog(null,
                        "Data Masih Kosong ehee :V",
                        "Data masih kosong", JOptionPane.INFORMATION_MESSAGE, bocchiIcon);
            }
        }
        public void updateAccount()
        {
            resetPanel();
            addBackground(1);
            refreshListData();
            setTitle("Love Hotel Admin : Update Account ");
            topLabel = new JLabel("Update Account");
            topLabel.setFont(font.deriveFont(Font.BOLD, 40));
            topLabel.setForeground(Color.BLACK);
            topLabel.setBounds(550, 75, 350,71);
            scrollPaneList = new JScrollPane(listAccount);
            scrollPaneList.setBorder(BorderFactory.createLineBorder(new Color(255,105,180), 3));
            scrollPaneList.setBounds(532,200,300,350);
            usernameLabel = new JLabel("Username baru ");
            usernameLabel.setBounds(955, 350,100,25);
            passwordLabel = new JLabel("Password baru");
            passwordLabel.setBounds(955,410,100,25);
            addUsertext = new JTextField();
            addUsertext.setBounds(925,380,150,25);
            addPasstext = new JTextField();
            addPasstext.setBounds(925, 440,150,25);

            submitButton = new JButton();
            submitButton.setIcon(submitIcon);
            submitButton.setToolTipText("Submit");
            submitButton.setOpaque(false);
            submitButton.setBorderPainted(false);
            submitButton.setContentAreaFilled(false);
            submitButton.setPressedIcon(submitIconP);
            submitButton.setBounds(975,475,54,33);
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (addUsertext.getText().equals("") || addPasstext.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,
                                "Field tidak boleh Kosong!", "Field masih Kosong", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        int dialog = JOptionPane.showConfirmDialog(null,
                                "Apakah ingin mengupdate? \n Hueee.. ^-^", "Pertanyaan Bocchi",
                                JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, bocchiWarning);
                        if (dialog == 0)
                        {
                            JOptionPane.showMessageDialog(null,
                                    "Akun Staff berhasil diUpdate!", "", JOptionPane.INFORMATION_MESSAGE);
                            guiController.updateAccountbyAdmin(indexSelectedJlist,String.valueOf(addUsertext.getText()), String.valueOf(addPasstext.getText()));
                            textAreaArgument = "Password : "+guiController.getPassword(indexSelectedJlist);
                            description.setText(textAreaArgument);
                            refreshListData();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,
                                    "Proses Penambahan Akun dibatalkan!", "", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            });

            if (guiController.getSizeData() != 0)
            {
                panel.add(usernameLabel);
                panel.add(addUsertext);
                panel.add(passwordLabel);
                panel.add(addPasstext);
                panel.add(description);
                panel.add(scrollPaneList);
                panel.add(submitButton);
            }
            panel.add(topLabel);
            panel.add(backButton);
        }
        public void deleteAccount()
        {
            resetPanel();
            refreshListData();
            setTitle("Love Hotel Admin : Delete Account ");
            topLabel = new JLabel("Delete Account");
            topLabel.setFont(font.deriveFont(Font.BOLD, 40));
            topLabel.setForeground(Color.BLACK);
            topLabel.setBounds(550, 75, 350,71);
            scrollPaneList = new JScrollPane(listAccount);
            scrollPaneList.setBorder(BorderFactory.createLineBorder(new Color(255,105,180), 3));
            scrollPaneList.setBounds(532,200,300,350);

            submitButton = new JButton();
            submitButton.setIcon(submitIcon);
            submitButton.setToolTipText("Submit");
            submitButton.setOpaque(false);
            submitButton.setBorderPainted(false);
            submitButton.setContentAreaFilled(false);
            submitButton.setPressedIcon(submitIconP);
            submitButton.setBounds(975,475,54,33);
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int dialog = JOptionPane.showConfirmDialog(null,
                            "Apakah ingin menghapus akun ini? \n Hueee.. T-T", "Pertanyaan Bocchi : Menghapus Akun",
                            JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, bocchiWarning);
                    if (dialog == 0)
                    {
                        JOptionPane.showMessageDialog(null,
                                "Akun Staff berhasil diHapus!", "", JOptionPane.INFORMATION_MESSAGE);
                        guiController.deleteAccount(indexSelectedJlist);
                        description.setText("");
                        refreshListData();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Proses menghapus Akun dibatalkan!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

            if (guiController.getSizeData() != 0)
            {
                panel.add(description);
                panel.add(scrollPaneList);
                panel.add(submitButton);
            }
            panel.add(topLabel);
            panel.add(backButton);
        }
}