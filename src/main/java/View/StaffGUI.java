package View;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class StaffGUI extends JFrame
{
    GUIController guiController = new GUIController();
    JPanel panel;
    //ATTRIBUTES Home
    JLabel background, reservLabel, tamuLabel, topLabel;
    JButton reservButton, tamuButton, backButton;

    JLabel addReservLabel, viewReservLabel, updtReservLabel, deleteReservLabel;
    JLabel addTamuLabel, viewTamuLabel, updtTamuLabel, deleteTamuLabel;
    //ATTRIBUTES MENU ADD TAMU
    JLabel namaLabel, noKtpLabel, noTelpLabel, noKamarLabel, keteranganTanggalLabel;
    JTextField namatxt, noKtptxt, noTelptxt;
    JComboBox noKamarcomboBox;
    String nama,noKtp,noTelp,noKamar;
    String listKamar[] = new String[guiController.kamar.getSizeData()];

    JButton addReservButton, viewReservButton, updtReservButton, deleteReservButton;
    JButton addTamuButton, viewTamuButton, updateTamuButton, deleteTamuButton, statusTamuButton;
    JButton submitButton;
    ImageIcon ryoIcon, ryoBG;
    Font font = null;
    DefaultTableModel tableModelKamar = new DefaultTableModel(), tableModelTamu = new DefaultTableModel();
    JTable jTableKamar = new JTable(tableModelKamar), jTableTamu = new JTable(tableModelTamu);
    JList jListTamu = new JList<>();
    JScrollPane scrollPaneKamar, scrollPaneTamu;
    JRadioButton Rbutton1, Rbutton2, Rbutton3;
    Object columnKamar [] = {"Nama Kamar", "Keterangan", "Status"};
    Object columTamu [] = {"Nama" , "No.Telepon" , " Nomor Kamar" , "Tanggal Check-In", "Tanggal Check-Out" , "Status" };
    Integer indexTerpilih;
    String[] tempListTamu;
    JTextArea textArea = new JTextArea();
    public void initialize() throws IOException {
        //SETUP PANEL
        panel = new JPanel();
        panel.setSize(1366,768);
        panel.setLayout(null);
        panel.setBackground(new Color(129,212,250));

        for (int i=0; i<guiController.kamar.getSizeData(); i++)
        {
            listKamar[i] = guiController.kamar.getNamaKamar(i);
        }
        noKamarcomboBox = new JComboBox<>(listKamar);

        background = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("img/ryoBG.png")));
        background.setBounds(900,550,161,174);
        ryoIcon = new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/ryoWarning.png"));
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/fonts/Love.ttf"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }

        //Setup JBUTTON & JLabel
        addTamuLabel = new JLabel("Tambahkan Tamu");
        addTamuLabel.setBounds(340,350,160,40);
        addTamuLabel.setFont(new Font("Candara", Font.BOLD, 20));
        addTamuButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/add.png")));
        addTamuButton.setPressedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/addClicked.png")));
        addTamuButton.setBounds(350,200,140,140);
        addTamuButton.setToolTipText("Tambahkan Tamu");
        addTamuButton.setContentAreaFilled(false);
        addTamuButton.setRolloverEnabled(true);
        addTamuButton.setBorderPainted(false);
        addTamuButton.setOpaque(false);
        addTamuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTamu();
            }
        });

        viewTamuLabel = new JLabel("Daftar Tamu");
        viewTamuLabel.setBounds(860,350,140,40);
        viewTamuLabel.setFont(new Font("Candara", Font.BOLD, 20));
        viewTamuButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/view.png")));
        viewTamuButton.setPressedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/viewClicked.png")));
        viewTamuButton.setBounds(850,200,140,140);
        viewTamuButton.setToolTipText("Lihat Daftar Tamu");
        viewTamuButton.setContentAreaFilled(false);
        viewTamuButton.setRolloverEnabled(true);
        viewTamuButton.setBorderPainted(false);
        viewTamuButton.setOpaque(false);
        viewTamuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanel();
                viewTamu();
            }
        });

        updtTamuLabel = new JLabel("Update Tamu");
        updtTamuLabel.setBounds(350,610,160,40);
        updtTamuLabel.setFont(new Font("Candara", Font.BOLD, 20));
        updateTamuButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/update.png")));
        updateTamuButton.setPressedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/updateClicked.png")));
        updateTamuButton.setBounds(345,470,140,140);
        updateTamuButton.setToolTipText("Update Data Tamu");
        updateTamuButton.setContentAreaFilled(false);
        updateTamuButton.setRolloverEnabled(true);
        updateTamuButton.setBorderPainted(false);
        updateTamuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanel();
                updateTamu();
            }
        });

        deleteTamuLabel = new JLabel("Hapus Tamu");
        deleteTamuLabel.setBounds(865,610,160,40);
        deleteTamuLabel.setFont(new Font("Candara", Font.BOLD, 20));
        deleteTamuButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/delete.png")));
        deleteTamuButton.setPressedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/deleteClicked.png")));
        deleteTamuButton.setBounds(850,465,140,140);
        deleteTamuButton.setToolTipText("Hapus Data Tamu");
        deleteTamuButton.setBackground(Color.red);
        deleteTamuButton.setContentAreaFilled(false);
        deleteTamuButton.setRolloverEnabled(true);
        deleteTamuButton.setBorderPainted(false);
        deleteTamuButton.setOpaque(false);
        deleteTamuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanel();
                deleteTamu();
            }
        });

        submitButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/submit.png")));
        submitButton.setToolTipText("Submit");
        submitButton.setOpaque(false);
        submitButton.setBorderPainted(false);
        submitButton.setContentAreaFilled(false);
        submitButton.setPressedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/submitP.png")));

        backButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/back.png")));
        backButton.setBounds(3,3,75,75);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setPressedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/MainIcons/backP.png")));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanel();
                emptyingField();
                editableText();
                Staffhome();
            }
        });
        jTableTamu.setEnabled(false);
        jTableTamu.setBackground(new Color(50,208,255));
        namaLabel = new JLabel("Nama");
        noKtpLabel = new JLabel("No.KTP");
        noTelpLabel = new JLabel("No.Telp");
        noKamarLabel = new JLabel("No.Kamar");
        namatxt = new JTextField();
        noKtptxt = new JTextField();
        noTelptxt = new JTextField();
       //        statusTamuButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/checkIn.png")));
//        statusTamuButton.setPressedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/Staff/checkin/checkInClicked.png")));
//        statusTamuButton.setBounds(600,465,140,140);
//        statusTamuButton.setToolTipText("Status Tamu");
//        statusTamuButton.setContentAreaFilled(false);
//        statusTamuButton.setRolloverEnabled(true);
//        statusTamuButton.setBorderPainted(false);
//        statusTamuButton.setOpaque(false);
//        add(statusTamuButton);
    }
    private Boolean textFieldisEmpty()
    {
       if ( namatxt.getText().equals("") || noKtptxt.equals("") || noTelptxt.getText().equals("") || noKamarcomboBox.equals("") )
           return true;
       else
       {
           nama = namatxt.getText();
           noKtp = noKtptxt.getText();
           noTelp = noTelptxt.getText();
           return false;
       }
    }
    private void emptyingField()
    {
        namatxt.setText("");
        noKtptxt.setText("");
        noTelptxt.setText("");
        noKamarcomboBox.setSelectedIndex(0);
    }
    public void refreshDataKamar()
    {
        tableModelKamar = (DefaultTableModel) jTableKamar.getModel();
        tableModelKamar.setRowCount(0);
        tableModelKamar.setColumnIdentifiers(columnKamar);
        Object [] tempData = new Object[3];
        for (int i=0; i<guiController.kamar.getSizeData(); i++)
        {
            tempData[0] = " " + guiController.kamar.getNamaKamar(i);
            tempData[1] = " " + guiController.kamar.getDetailKamar(i);
            if (guiController.kamar.getStatusKamar(i))
                tempData[2] = " Available ✅ ";
            else
                tempData[2] = " Unavailable ❌";

            tableModelKamar.addRow(tempData);
        }
    }
    public void refreshDataTamu()
    {
        tableModelTamu = (DefaultTableModel) jTableTamu.getModel();
        tableModelTamu.setRowCount(0);
        tableModelTamu.setColumnIdentifiers(columTamu);
        Object [] tempData = new Object[6];
        for (int i=0; i<guiController.tamu.getSizeData(); i++)
        {
            tempData[0] = " " + guiController.tamu.getNama(i);
            tempData[1] = " " + guiController.tamu.getNotelp(i);
            tempData[2] = " " + guiController.kamar.getNamaKamar(guiController.tamu.getNoKamar(i));
            tempData[3] = " " + guiController.tamu.getDateIn(i);
            if (guiController.tamu.getStatusTamu(i) == 1 || guiController.tamu.getStatusTamu(i) == 2 )
                tempData[4] = "*" + guiController.tamu.getDateOut(i);
            else
                tempData[4] = " " + guiController.tamu.getDateOut(i);
            if (guiController.tamu.getStatusTamu(i) == 1)
                tempData[5] = "Reservasi";
            else if (guiController.tamu.getStatusTamu(i) == 2)
                tempData[5] = "CheckIn";
            else if (guiController.tamu.getStatusTamu(i) == 2)
                tempData[5] = "CheckOut";

            tableModelTamu.addRow(tempData);
        }
    }
    private void refreshListTamu()
    {
        tempListTamu = new String[guiController.tamu.getSizeData()];
        for (int i=0; i<guiController.tamu.getSizeData(); i++)
        {
            tempListTamu[i] = guiController.tamu.getNama(i);
        }
        jListTamu = new JList<>(tempListTamu);
    }
    private Boolean cekStatusKamar(int index)
    {
        return guiController.kamar.getStatusKamar(index);
    }
    private void addTamu()
    {
        refreshDataKamar();
        clearPanel();

        namaLabel.setBounds(610, 260,75,25);
        namatxt.setBounds(610,285,150,25);

        noKtpLabel.setBounds(610,315,75,25);
        noKtptxt.setBounds(610, 340,150,25);

        noTelpLabel.setBounds(610,370,75,25);
        noTelptxt.setBounds(610,395,150,25);

        noKamarLabel.setBounds(610,420,75,25);
        noKamarcomboBox.setBounds(610,445,150,25);

        jTableKamar.setEnabled(false);
        jTableKamar.getTableHeader().setReorderingAllowed(false);
        jTableKamar.setBackground(new Color(70,240,180));
        scrollPaneKamar = new JScrollPane(jTableKamar);
        scrollPaneKamar.setBorder(new LineBorder(Color.BLACK, 3));
        scrollPaneKamar.setBounds(150,90,350,400);

        submitButton.setBounds(657,500,54,33);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldisEmpty())
                {
                    JOptionPane.showMessageDialog(null,
                            "Field masih Kosong");
                }
                else if (!cekStatusKamar(noKamarcomboBox.getSelectedIndex()))
                {
                    JOptionPane.showMessageDialog(null, "Pemesanan Gagal, Kamar terpilih sudah dipesan! Harap pilih kamar lain.." );
                }
                else
                {
                    int dialog = JOptionPane.showConfirmDialog(null,
                            "Apakah ingin menambahkan Tamu? \n  ^-^", "Serangan Ryo Stare",
                            JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, ryoIcon);
                    if (dialog == 0)
                    {
                        guiController.tamu.registerTamuOTS(nama, noKtp, noTelp, noKamarcomboBox.getSelectedIndex());
                        JOptionPane.showMessageDialog(null,
                                "Tamu berhasil ditambahkan!", "", JOptionPane.INFORMATION_MESSAGE);
                        guiController.kamar.setCheckKamar(noKamarcomboBox.getSelectedIndex());
                        refreshDataKamar();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Proses daftar Tamu dibatalkan!", "", JOptionPane.WARNING_MESSAGE);
                    }
                    emptyingField();
                }
            }
        });

        topLabel = new JLabel("Register Tamu");
        topLabel.setFont(font.deriveFont(Font.BOLD, 40));
        topLabel.setForeground(Color.BLACK);
        topLabel.setBounds(550, 75, 350,71);
        setTitle("Love Notel Staff : Register Tamu ");

        panel.add(namaLabel);
        panel.add(namatxt);
        panel.add(noKtpLabel);
        panel.add(noKtptxt);
        panel.add(noTelpLabel);
        panel.add(noTelptxt);
        panel.add(noKamarLabel);
        panel.add(noKamarcomboBox);
        panel.add(submitButton);
        panel.add(topLabel);
        panel.add(backButton);
        panel.add(scrollPaneKamar);
    }
    private void viewTamu()
    {
        refreshDataTamu();
        keteranganTanggalLabel = new JLabel("* Waktu Maksimal Tamu harus Check Out");
        keteranganTanggalLabel.setFont(new Font("Candara", Font.BOLD, 14));
        keteranganTanggalLabel.setBounds(260,120,300,30);
        scrollPaneTamu = new JScrollPane(jTableTamu);
        scrollPaneTamu.setBorder(new LineBorder(Color.BLACK, 2));
        scrollPaneTamu.setBounds(260,150,800,400);
        panel.add(keteranganTanggalLabel);
        panel.add(scrollPaneTamu);
        panel.add(backButton);
    }
    public void updateTamu()
    {
        topLabel = new JLabel("Update Tamu");
        topLabel.setFont(font.deriveFont(Font.BOLD, 40));
        topLabel.setForeground(Color.BLACK);
        topLabel.setBounds(550, 75, 350,71);
        setTitle("Love Notel Staff : Update Tamu ");
        componentUpdateDelete();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldisEmpty())
                {
                    JOptionPane.showMessageDialog(null,
                            "Field masih Kosong");
                }
                else if (!cekStatusKamar(noKamarcomboBox.getSelectedIndex()))
                {
                    JOptionPane.showMessageDialog(null, "Pemesanan Gagal, Kamar terpilih sudah dipesan! Harap pilih kamar lain.." );
                }
                else
                {
                    int dialog = JOptionPane.showConfirmDialog(null,
                            "Apakah ingin menambahkan Tamu? \n  ^-^", "Serangan Ryo Stare",
                            JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, ryoIcon);
                    if (dialog == 0)
                    {
                        guiController.kamar.setCheckKamar(noKamarcomboBox.getSelectedIndex());
                        guiController.kamar.unCheckKamar(guiController.tamu.getNoKamar(indexTerpilih));
                        guiController.tamu.updateTamu(indexTerpilih, nama, noKtp, noTelp, noKamarcomboBox.getSelectedIndex());
                        JOptionPane.showMessageDialog(null,
                                "Tamu berhasil diupdate!", "", JOptionPane.INFORMATION_MESSAGE);
                        refreshDataKamar();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                "Proses update Tamu dibatalkan!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
                emptyingField();
            }
        });
    }
    private void deleteTamu()
    {
        topLabel = new JLabel("Delete Tamu");
        topLabel.setFont(font.deriveFont(Font.BOLD, 40));
        topLabel.setForeground(Color.BLACK);
        topLabel.setBounds(550, 75, 350,71);
        setTitle("Love Notel Staff : Delete Tamu ");
        componentUpdateDelete();
        uneditableText();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int dialog = JOptionPane.showConfirmDialog(null,
                        "Apakah yakin ingin menghapus Tamu? \n  ^-^", "Serangan Ryo Stare",
                        JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, ryoIcon);
                if (dialog == 0)
                {
                    guiController.kamar.unCheckKamar(guiController.tamu.getNoKamar(indexTerpilih));
                    guiController.tamu.deleteTamu(indexTerpilih);
                    JOptionPane.showMessageDialog(null,
                            "Data Tamu berhasil dihapus!", "", JOptionPane.INFORMATION_MESSAGE);
                    refreshDataKamar();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "Proses update Tamu dibatalkan!", "", JOptionPane.WARNING_MESSAGE);
                }
                emptyingField();
            }
        });
    }
    private void componentUpdateDelete()
    {
        refreshListTamu();
        namaLabel.setBounds(900, 260,75,25);
        namatxt.setBounds(900,285,150,25);

        noKtpLabel.setBounds(900,315,75,25);
        noKtptxt.setBounds(900, 340,150,25);

        noTelpLabel.setBounds(900,370,75,25);
        noTelptxt.setBounds(900,395,150,25);

        noKamarLabel.setBounds(900,420,75,25);
        noKamarcomboBox.setBounds(900,445,150,25);
        jListTamu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    indexTerpilih = jListTamu.getSelectedIndex();
                    namatxt.setText(guiController.tamu.getNama(indexTerpilih));
                    noKtptxt.setText(guiController.tamu.getNoKtp(indexTerpilih));
                    noTelptxt.setText(guiController.tamu.getNoKtp(indexTerpilih));
                    noKamarcomboBox.setSelectedIndex(guiController.tamu.getNoKamar(indexTerpilih));
                }
            }
        });
        jListTamu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    indexTerpilih = jListTamu.getSelectedIndex();
                    namatxt.setText(guiController.tamu.getNama(indexTerpilih));
                    noKtptxt.setText(guiController.tamu.getNoKtp(indexTerpilih));
                    noTelptxt.setText(guiController.tamu.getNoKtp(indexTerpilih));
                    noKamarcomboBox.setSelectedIndex(guiController.tamu.getNoKamar(indexTerpilih));
                }
            }
        });
        submitButton.setBounds(950,500,54,33);
        scrollPaneTamu = new JScrollPane(jListTamu);
        scrollPaneTamu.setBounds(570,250,200,250);
        scrollPaneTamu.setBorder(new LineBorder(Color.BLACK, 2));

        panel.add(namaLabel);
        panel.add(namatxt);
        panel.add(noKtpLabel);
        panel.add(noKtptxt);
        panel.add(noTelpLabel);
        panel.add(noTelptxt);
        panel.add(noKamarLabel);
        panel.add(noKamarcomboBox);
        panel.add(submitButton);
        panel.add(topLabel);
        panel.add(scrollPaneTamu);
        panel.add(backButton);
    }
    private void editableText()
    {
        namatxt.setEditable(true);
        noTelptxt.setEditable(true);
        noKtptxt.setEditable(true);
        noKamarcomboBox.setEnabled(true);
    }
    private void uneditableText()
    {
        namatxt.setEditable(false);
        noTelptxt.setEditable(false);
        noKtptxt.setEditable(false);
        noKamarcomboBox.setEnabled(false);
    }
    private void clearPanel()
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }
    private void Staffhome()
    {
        panel.add(background);
        panel.add(addTamuLabel);
        panel.add(addTamuButton);
        panel.add(viewTamuLabel);
        panel.add(viewTamuButton);
        panel.add(updtTamuLabel);
        panel.add(updateTamuButton);
        panel.add(deleteTamuLabel);
        panel.add(deleteTamuButton);
    }

    public StaffGUI() throws IOException {
        initialize();
        Staffhome();
        setSize(1366,768);
        setLocationRelativeTo(null);
        getContentPane().add(panel);
        setVisible(true);
    }
}