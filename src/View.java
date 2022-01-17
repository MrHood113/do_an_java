import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Mon Jan 17 15:23:41 ICT 2022
 */



/**
 * @author unknown
 */
public class View extends JFrame {
    public View(String tenbacsi) {
        initComponents();
        lbtenbacsi.setText("Xin chào, Bác sĩ "+tenbacsi);
    }

    private void dangxuat(ActionEvent e) {
        setVisible(false);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Login login = new Login();
            login.setVisible(true);
            login.setDefaultCloseOperation(3);


        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        button9 = new JButton();
        lbtenbacsi = new JLabel();
        label1 = new JLabel();
        label5 = new JLabel();
        panel3 = new JTabbedPane();
        panel5 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel8 = new JPanel();
        label6 = new JLabel();
        textField1 = new JTextField();
        label7 = new JLabel();
        textField2 = new JTextField();
        label8 = new JLabel();
        textField3 = new JTextField();
        label9 = new JLabel();
        textField4 = new JTextField();
        label10 = new JLabel();
        comboBox1 = new JComboBox<>();
        label11 = new JLabel();
        textField5 = new JTextField();
        panel9 = new JPanel();
        label12 = new JLabel();
        textField6 = new JTextField();
        label13 = new JLabel();
        textField7 = new JTextField();
        panel10 = new JPanel();
        label14 = new JLabel();
        textField8 = new JTextField();
        label16 = new JLabel();
        textField9 = new JTextField();
        label17 = new JLabel();
        comboBox2 = new JComboBox<>();
        label18 = new JLabel();
        comboBox3 = new JComboBox();
        panel11 = new JPanel();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        label15 = new JLabel();
        panel4 = new JPanel();
        panel6 = new JPanel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("B\u1ec6NH VI\u1ec6N QU\u1ea6N QU\u00c8");
        setIconImage(new ImageIcon(getClass().getResource("/img/medical-team.png")).getImage());
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 204, 204));
            panel1.setLayout(null);

            //---- button9 ----
            button9.setText("\u0110\u0102NG XU\u1ea4T");
            button9.setIcon(new ImageIcon(getClass().getResource("/img/logout.png")));
            button9.setFont(new Font("Montserrat Medium", Font.BOLD, 11));
            button9.setBackground(Color.pink);
            button9.addActionListener(e -> dangxuat(e));
            panel1.add(button9);
            button9.setBounds(1240, 10, 145, 50);

            //---- lbtenbacsi ----
            lbtenbacsi.setFont(lbtenbacsi.getFont().deriveFont(lbtenbacsi.getFont().getSize() + 4f));
            lbtenbacsi.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            panel1.add(lbtenbacsi);
            lbtenbacsi.setBounds(875, 20, 360, 34);

            //---- label1 ----
            label1.setText("PH\u1ea6N M\u1ec0M QU\u1ea2N L\u00dd H\u1ed2 S\u01a0 B\u1ec6NH \u00c1N");
            label1.setFont(new Font("Montserrat Black", Font.PLAIN, 36));
            label1.setForeground(new Color(51, 51, 255));
            panel1.add(label1);
            label1.setBounds(130, 15, 740, label1.getPreferredSize().height);

            //---- label5 ----
            label5.setIcon(new ImageIcon(getClass().getResource("/img/96292c1b74a02d97da084006a2334189.jpg")));
            panel1.add(label5);
            label5.setBounds(0, 0, 1400, 70);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== panel3 ========
        {
            panel3.setOpaque(true);
            panel3.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));

            //======== panel5 ========
            {
                panel5.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setFont(new Font("Montserrat", Font.PLAIN, 14));

                    //---- table1 ----
                    table1.setRowHeight(30);
                    table1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, "", null, null, null, "", null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "M\u00e3 b\u1ec7nh nh\u00e2n", "H\u1ecd v\u00e0 t\u00ean", "N\u0103m sinh", "Gi\u1edbi t\u00ednh", "\u0110\u1ecba ch\u1ec9", "S\u1ed1 \u0111i\u1ec7n tho\u1ea1i", "S\u1ed1 BHYT", "CCCD/CMND", "Ng\u00e0y ti\u1ebfp nh\u1eadn", "M\u00e3 b\u00e1c s\u0129 ph\u1ee5 tr\u00e1ch", "T\u00ecnh tr\u1ea1ng", "M\u00e3 virus"
                        }
                    ));
                    scrollPane1.setViewportView(table1);
                }
                panel5.add(scrollPane1);
                scrollPane1.setBounds(10, 345, 1370, 315);

                //======== panel8 ========
                {
                    panel8.setBorder(new TitledBorder(null, "Th\u00f4ng tin b\u1ec7nh nh\u00e2n", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                        new Font("Montserrat Medium", Font.PLAIN, 14)));
                    panel8.setLayout(null);

                    //---- label6 ----
                    label6.setText("M\u00e3 b\u1ec7nh nh\u00e2n (*) :");
                    label6.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label6);
                    label6.setBounds(10, 20, 150, 30);

                    //---- textField1 ----
                    textField1.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(textField1);
                    textField1.setBounds(150, 20, 230, 30);

                    //---- label7 ----
                    label7.setText("H\u1ecd v\u00e0 t\u00ean (*) :");
                    label7.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label7);
                    label7.setBounds(10, 60, 120, 30);

                    //---- textField2 ----
                    textField2.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(textField2);
                    textField2.setBounds(150, 60, 230, 30);

                    //---- label8 ----
                    label8.setText("N\u0103m sinh (*) :");
                    label8.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label8);
                    label8.setBounds(10, 100, 115, 30);

                    //---- textField3 ----
                    textField3.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(textField3);
                    textField3.setBounds(150, 100, 60, 30);

                    //---- label9 ----
                    label9.setText("\u0110\u1ecba ch\u1ec9 (*) :");
                    label9.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label9);
                    label9.setBounds(10, 140, 100, 30);

                    //---- textField4 ----
                    textField4.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(textField4);
                    textField4.setBounds(150, 140, 230, 30);

                    //---- label10 ----
                    label10.setText("Gi\u1edbi t\u00ednh (*) :");
                    label10.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label10);
                    label10.setBounds(215, 100, 100, 30);

                    //---- comboBox1 ----
                    comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Nam",
                        "N\u1eef"
                    }));
                    comboBox1.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(comboBox1);
                    comboBox1.setBounds(310, 100, 70, 30);

                    //---- label11 ----
                    label11.setText("S\u1ed1 \u0111i\u1ec7n tho\u1ea1i (*) :");
                    label11.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label11);
                    label11.setBounds(10, 180, 135, 30);

                    //---- textField5 ----
                    textField5.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(textField5);
                    textField5.setBounds(150, 180, 230, 30);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel8.getComponentCount(); i++) {
                            Rectangle bounds = panel8.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel8.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel8.setMinimumSize(preferredSize);
                        panel8.setPreferredSize(preferredSize);
                    }
                }
                panel5.add(panel8);
                panel8.setBounds(390, 15, 400, 220);

                //======== panel9 ========
                {
                    panel9.setBorder(new TitledBorder(null, "Gi\u1ea5y t\u1edd", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                        new Font("Montserrat Medium", Font.PLAIN, 14)));
                    panel9.setLayout(null);

                    //---- label12 ----
                    label12.setText("S\u1ed1 BHYT :");
                    label12.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel9.add(label12);
                    label12.setBounds(10, 20, 100, 30);

                    //---- textField6 ----
                    textField6.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel9.add(textField6);
                    textField6.setBounds(150, 20, 230, 30);

                    //---- label13 ----
                    label13.setText("CCCD/CMND :");
                    label13.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel9.add(label13);
                    label13.setBounds(10, 55, 100, 30);

                    //---- textField7 ----
                    textField7.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel9.add(textField7);
                    textField7.setBounds(150, 55, 230, 30);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel9.getComponentCount(); i++) {
                            Rectangle bounds = panel9.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel9.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel9.setMinimumSize(preferredSize);
                        panel9.setPreferredSize(preferredSize);
                    }
                }
                panel5.add(panel9);
                panel9.setBounds(390, 235, 400, 95);

                //======== panel10 ========
                {
                    panel10.setBorder(new TitledBorder(null, "T\u00ecnh tr\u1ea1ng \u0111i\u1ec1u tr\u1ecb", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                        new Font("Montserrat Medium", Font.PLAIN, 14)));
                    panel10.setLayout(null);

                    //---- label14 ----
                    label14.setText("Ng\u00e0y ti\u1ebfp nh\u1eadn (**) :");
                    label14.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(label14);
                    label14.setBounds(10, 20, 145, 30);

                    //---- textField8 ----
                    textField8.setEditable(false);
                    textField8.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(textField8);
                    textField8.setBounds(195, 20, 200, 30);

                    //---- label16 ----
                    label16.setText("M\u00e3 b\u00e1c s\u0129 ph\u1ee5 tr\u00e1ch (**) :");
                    label16.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(label16);
                    label16.setBounds(10, 60, 185, 30);

                    //---- textField9 ----
                    textField9.setEditable(false);
                    textField9.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(textField9);
                    textField9.setBounds(195, 60, 200, 30);

                    //---- label17 ----
                    label17.setText("Giai \u0111o\u1ea1n (*) :");
                    label17.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(label17);
                    label17.setBounds(10, 100, 110, 30);

                    //---- comboBox2 ----
                    comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Giai \u0111o\u1ea1n 1 - \u1ee6 b\u1ec7nh",
                        "Giai \u0111o\u1ea1n 2 - Nh\u1eb9 v\u00e0 trung b\u00ecnh",
                        "Giai \u0111o\u1ea1n 3 - N\u1eb7ng"
                    }));
                    comboBox2.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(comboBox2);
                    comboBox2.setBounds(195, 100, 200, 30);

                    //---- label18 ----
                    label18.setText("M\u00e3 virus (*) :");
                    label18.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(label18);
                    label18.setBounds(10, 140, 130, 30);

                    //---- comboBox3 ----
                    comboBox3.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(comboBox3);
                    comboBox3.setBounds(195, 140, 200, 30);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel10.getComponentCount(); i++) {
                            Rectangle bounds = panel10.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel10.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel10.setMinimumSize(preferredSize);
                        panel10.setPreferredSize(preferredSize);
                    }
                }
                panel5.add(panel10);
                panel10.setBounds(795, 15, 410, 315);

                //======== panel11 ========
                {
                    panel11.setLayout(null);

                    //---- button10 ----
                    button10.setText("TH\u00caM");
                    button10.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
                    panel11.add(button10);
                    button10.setBounds(0, 0, 120, 45);

                    //---- button11 ----
                    button11.setText("S\u1eecA");
                    button11.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
                    panel11.add(button11);
                    button11.setBounds(0, 57, 119, 45);

                    //---- button12 ----
                    button12.setText("X\u00d3A");
                    button12.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
                    panel11.add(button12);
                    button12.setBounds(0, 114, 119, 45);

                    //---- button13 ----
                    button13.setText("CLEAR");
                    button13.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
                    panel11.add(button13);
                    button13.setBounds(0, 260, 119, 45);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel11.getComponentCount(); i++) {
                            Rectangle bounds = panel11.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel11.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel11.setMinimumSize(preferredSize);
                        panel11.setPreferredSize(preferredSize);
                    }
                }
                panel5.add(panel11);
                panel11.setBounds(new Rectangle(new Point(1240, 20), panel11.getPreferredSize()));

                //---- label15 ----
                label15.setText("text");
                label15.setIcon(new ImageIcon(getClass().getResource("/img/medical-report2.png")));
                panel5.add(label15);
                label15.setBounds(0, 5, 350, 345);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel5.getComponentCount(); i++) {
                        Rectangle bounds = panel5.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel5.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel5.setMinimumSize(preferredSize);
                    panel5.setPreferredSize(preferredSize);
                }
            }
            panel3.addTab("C\u1eacP NH\u1eacT H\u1ed2 S\u01a0 B\u1ec6NH \u00c1N", new ImageIcon(getClass().getResource("/img/update.png")), panel5);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            panel3.addTab("TRA C\u1ee8U TH\u00d4NG TIN H\u1ed2 S\u01a0 B\u1ec6NH \u00c1N", new ImageIcon(getClass().getResource("/img/magnifying-glass.png")), panel4);

            //======== panel6 ========
            {
                panel6.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel6.getComponentCount(); i++) {
                        Rectangle bounds = panel6.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel6.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel6.setMinimumSize(preferredSize);
                    panel6.setPreferredSize(preferredSize);
                }
            }
            panel3.addTab("IN TH\u00d4NG TIN B\u1ec6NH \u00c1N", new ImageIcon(getClass().getResource("/img/printer.png")), panel6);
        }
        contentPane.add(panel3, BorderLayout.CENTER);
        setSize(1400, 810);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton button9;
    private JLabel lbtenbacsi;
    private JLabel label1;
    private JLabel label5;
    private JTabbedPane panel3;
    private JPanel panel5;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel8;
    private JLabel label6;
    private JTextField textField1;
    private JLabel label7;
    private JTextField textField2;
    private JLabel label8;
    private JTextField textField3;
    private JLabel label9;
    private JTextField textField4;
    private JLabel label10;
    private JComboBox<String> comboBox1;
    private JLabel label11;
    private JTextField textField5;
    private JPanel panel9;
    private JLabel label12;
    private JTextField textField6;
    private JLabel label13;
    private JTextField textField7;
    private JPanel panel10;
    private JLabel label14;
    private JTextField textField8;
    private JLabel label16;
    private JTextField textField9;
    private JLabel label17;
    private JComboBox<String> comboBox2;
    private JLabel label18;
    private JComboBox comboBox3;
    private JPanel panel11;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JLabel label15;
    private JPanel panel4;
    private JPanel panel6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
