import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
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
    private String tenbacsi, mabacsi;
    private Vector vTitle = new Vector<>(), vData = new Vector<>();
    private Connection conn;
    private Statement stm;
    private ResultSet rst;
    private ResultSetMetaData rstmeta;

    public View(String tenbacsi,String mabacsi) {
        initComponents();
        this.tenbacsi = tenbacsi;
        this.mabacsi = mabacsi;
        lbtenbacsi.setText("Xin chào, Bác sĩ "+tenbacsi);

        reload();

        reload_history();

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyhosobenhan","dangnguyen","123456");
            stm = conn.createStatement();
            rst = stm.executeQuery("SELECT * FROM viruts ");
            while (rst.next()){
                comboBoxVirus.addItem(rst.getString(1));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }



    }
    private void reload(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyhosobenhan","dangnguyen","123456");
            stm = conn.createStatement();
            rst = stm.executeQuery("SELECT * FROM patients ");
            vTitle.clear();
            vData.clear();
            rstmeta = rst.getMetaData();
            int num_columns = rstmeta.getColumnCount();
            String[] title = new String[]{
                    "Mã bệnh nhân",
                    "Họ và tên",
                    "Năm sinh",
                    "Giới tính",
                    "Địa chỉ",
                    "Số điện thoại",
                    "Số BHYT",
                    "CMND/CCCD",
                    "Ngày tiếp nhận",
                    "Mã bác sĩ",
                    "Giai đoạn",
                    "Mã virus"
            };

            while (rst.next()){
                Vector row = new Vector();
                if (rst.getString(10).equals(mabacsi)){
                    for (int i=1;i<=num_columns;i++){
                        row.add(rst.getString(i));
                    }
                    vData.add(row);
                }
            }
            for (int i=1;i<=num_columns;i++){
                // vTitle.add(rstmeta.getColumnLabel(i));
                vTitle.add(title[i-1]);
            }
            rst.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table1.setModel(new DefaultTableModel(vData,vTitle));
        scrollPane1.setViewportView(table1);
        table1.setRowHeight(50);
    }

    Vector vTitle_history = new Vector();
    Vector vData_history = new Vector();
    private void reload_history(){

        try{
            rst = stm.executeQuery("SELECT * FROM patients_insert ");
            vTitle_history.clear();
            vData_history.clear();
            rstmeta = rst.getMetaData();
            int num_columns = rstmeta.getColumnCount();
           /* String[] title = new String[]{
                    "Mã bệnh nhân",
                    "Họ và tên",
                    "Năm sinh",
                    "Giới tính",
                    "Địa chỉ",
                    "Số điện thoại",
                    "Số BHYT",
                    "CMND/CCCD",
                    "Ngày tiếp nhận",
                    "Mã bác sĩ",
                    "Giai đoạn",
                    "Mã virus"
            };
*/
            for (int i=1;i<=num_columns;i++){
                vTitle_history.add(rstmeta.getColumnLabel(i));
                //vTitle_history.add(title[i-1]);
            }
            while (rst.next()){
                Vector row = new Vector();

                    for (int i=1;i<=num_columns;i++){
                        row.add(rst.getString(i));
                    }
                    vData_history.add(row);

            }

            rst.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }

        table4.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table4.setModel(new DefaultTableModel(vData_history,vTitle_history));
        scrollPane4.setViewportView(table4);
        table4.setRowHeight(50);
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

    private void print(ActionEvent e) {
        try {

            boolean print = table1.print(JTable.PrintMode.FIT_WIDTH,new MessageFormat("THÔNG TIN BỆNH NHÂN"),new MessageFormat("Mã bác sĩ: "+mabacsi+" - Bác sĩ: "+tenbacsi));
            if (!print) {
                JOptionPane.showMessageDialog(null, "Unable To Print !!..");
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void btClear(ActionEvent e) {
        tfHoVaTen.setText("");
        tfMaBenhNhan.setText("");
        tfNamSinh.setText("");
        tfBHYT.setText("");
        tfCCCD.setText("");
        tfDienThoai.setText("");
        tfNgayTiepNhan.setText("");
        tfDiaChi.setText("");
        tfMaBacSi.setText("");



    }

    private void selectRow(MouseEvent e) {

    }

    
    private void themBenhNhan(ActionEvent e) {
        try{
            LocalDateTime current = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatted = current.format(formatter);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyhosobenhan","dangnguyen","123456");
            PreparedStatement pst = conn.prepareStatement("INSERT INTO patients VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,tfMaBenhNhan.getText());
            pst.setString(2,tfHoVaTen.getText());
            pst.setString(3,tfNamSinh.getText());
            pst.setString(4, (String) comboBoxGioiTinh.getSelectedItem());
            pst.setString(5,tfDiaChi.getText());
            pst.setString(6,tfDienThoai.getText());
            pst.setString(7,tfBHYT.getText());
            pst.setString(8,tfCCCD.getText());
            pst.setString(9,formatted);
            pst.setString(10,mabacsi);
            pst.setString(11, (String) comboBoxGiaiDoan.getSelectedItem());
            pst.setString(12, (String) comboBoxVirus.getSelectedItem());
            pst.execute();

        } catch (Exception ex){
            ex.printStackTrace();
        }

        reload();
        tfHoVaTen.setText("");
        tfMaBenhNhan.setText("");
        tfNamSinh.setText("");
        tfBHYT.setText("");
        tfCCCD.setText("");
        tfDienThoai.setText("");
        tfNgayTiepNhan.setText("");
        tfDiaChi.setText("");
        tfMaBacSi.setText("");
    }

    private void selectRoew(MouseEvent e) {
        int row = table1.getSelectedRow();
        if (row >= 0) {
            tfMaBenhNhan.setText(table1.getModel().getValueAt(row, 0).toString());
            tfHoVaTen.setText(table1.getModel().getValueAt(row, 1).toString());
            tfNamSinh.setText(table1.getModel().getValueAt(row, 2).toString());
            comboBoxGioiTinh.setSelectedItem(table1.getModel().getValueAt(row,3).toString());
            tfDiaChi.setText(table1.getModel().getValueAt(row,4).toString());
            tfDienThoai.setText(table1.getModel().getValueAt(row,5).toString());
            tfBHYT.setText(table1.getModel().getValueAt(row,6).toString());
            tfCCCD.setText(table1.getModel().getValueAt(row,7).toString());
            tfNgayTiepNhan.setText(table1.getModel().getValueAt(row,8).toString());
            tfMaBacSi.setText(table1.getModel().getValueAt(row,9).toString());
            comboBoxGiaiDoan.setSelectedItem(table1.getModel().getValueAt(row,10).toString());
            comboBoxVirus.setSelectedItem(table1.getModel().getValueAt(row,11).toString());

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
        tfMaBenhNhan = new JTextField();
        label7 = new JLabel();
        tfHoVaTen = new JTextField();
        label8 = new JLabel();
        tfNamSinh = new JTextField();
        label9 = new JLabel();
        tfDiaChi = new JTextField();
        label10 = new JLabel();
        comboBoxGioiTinh = new JComboBox<>();
        label11 = new JLabel();
        tfDienThoai = new JTextField();
        panel9 = new JPanel();
        label12 = new JLabel();
        tfBHYT = new JTextField();
        label13 = new JLabel();
        tfCCCD = new JTextField();
        panel10 = new JPanel();
        label14 = new JLabel();
        tfNgayTiepNhan = new JTextField();
        label16 = new JLabel();
        tfMaBacSi = new JTextField();
        label17 = new JLabel();
        comboBoxGiaiDoan = new JComboBox<>();
        label18 = new JLabel();
        comboBoxVirus = new JComboBox();
        panel11 = new JPanel();
        btAdd = new JButton();
        btEdit = new JButton();
        btDel = new JButton();
        btClear = new JButton();
        btPrint = new JButton();
        label15 = new JLabel();
        panel4 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        panel6 = new JPanel();
        scrollPane4 = new JScrollPane();
        table4 = new JTable();

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
                    table1.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    table1.setModel(new DefaultTableModel(2, 0));
                    table1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            selectRoew(e);
                        }
                    });
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
                    label6.setBounds(10, 20, 140, 30);

                    //---- tfMaBenhNhan ----
                    tfMaBenhNhan.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(tfMaBenhNhan);
                    tfMaBenhNhan.setBounds(150, 20, 230, 30);

                    //---- label7 ----
                    label7.setText("H\u1ecd v\u00e0 t\u00ean (*) :");
                    label7.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label7);
                    label7.setBounds(10, 60, 120, 30);

                    //---- tfHoVaTen ----
                    tfHoVaTen.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(tfHoVaTen);
                    tfHoVaTen.setBounds(150, 60, 230, 30);

                    //---- label8 ----
                    label8.setText("N\u0103m sinh (*) :");
                    label8.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label8);
                    label8.setBounds(10, 100, 115, 30);

                    //---- tfNamSinh ----
                    tfNamSinh.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(tfNamSinh);
                    tfNamSinh.setBounds(150, 100, 60, 30);

                    //---- label9 ----
                    label9.setText("\u0110\u1ecba ch\u1ec9 (*) :");
                    label9.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label9);
                    label9.setBounds(10, 140, 100, 30);

                    //---- tfDiaChi ----
                    tfDiaChi.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(tfDiaChi);
                    tfDiaChi.setBounds(150, 140, 230, 30);

                    //---- label10 ----
                    label10.setText("Gi\u1edbi t\u00ednh (*) :");
                    label10.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label10);
                    label10.setBounds(215, 100, 100, 30);

                    //---- comboBoxGioiTinh ----
                    comboBoxGioiTinh.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Nam",
                        "N\u1eef"
                    }));
                    comboBoxGioiTinh.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(comboBoxGioiTinh);
                    comboBoxGioiTinh.setBounds(310, 100, 70, 30);

                    //---- label11 ----
                    label11.setText("S\u1ed1 \u0111i\u1ec7n tho\u1ea1i (*) :");
                    label11.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(label11);
                    label11.setBounds(10, 180, 135, 30);

                    //---- tfDienThoai ----
                    tfDienThoai.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel8.add(tfDienThoai);
                    tfDienThoai.setBounds(150, 180, 230, 30);

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

                    //---- tfBHYT ----
                    tfBHYT.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel9.add(tfBHYT);
                    tfBHYT.setBounds(150, 20, 230, 30);

                    //---- label13 ----
                    label13.setText("CCCD/CMND :");
                    label13.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel9.add(label13);
                    label13.setBounds(10, 55, 100, 30);

                    //---- tfCCCD ----
                    tfCCCD.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel9.add(tfCCCD);
                    tfCCCD.setBounds(150, 55, 230, 30);

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

                    //---- tfNgayTiepNhan ----
                    tfNgayTiepNhan.setEditable(false);
                    tfNgayTiepNhan.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(tfNgayTiepNhan);
                    tfNgayTiepNhan.setBounds(195, 20, 200, 30);

                    //---- label16 ----
                    label16.setText("M\u00e3 b\u00e1c s\u0129 ph\u1ee5 tr\u00e1ch (**) :");
                    label16.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(label16);
                    label16.setBounds(10, 60, 185, 30);

                    //---- tfMaBacSi ----
                    tfMaBacSi.setEditable(false);
                    tfMaBacSi.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(tfMaBacSi);
                    tfMaBacSi.setBounds(195, 60, 200, 30);

                    //---- label17 ----
                    label17.setText("Giai \u0111o\u1ea1n (*) :");
                    label17.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(label17);
                    label17.setBounds(10, 100, 110, 30);

                    //---- comboBoxGiaiDoan ----
                    comboBoxGiaiDoan.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Giai \u0111o\u1ea1n 1 - \u1ee6 b\u1ec7nh",
                        "Giai \u0111o\u1ea1n 2 - Nh\u1eb9 v\u00e0 trung b\u00ecnh",
                        "Giai \u0111o\u1ea1n 3 - N\u1eb7ng"
                    }));
                    comboBoxGiaiDoan.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(comboBoxGiaiDoan);
                    comboBoxGiaiDoan.setBounds(195, 100, 200, 30);

                    //---- label18 ----
                    label18.setText("M\u00e3 virus (*) :");
                    label18.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(label18);
                    label18.setBounds(10, 140, 130, 30);

                    //---- comboBoxVirus ----
                    comboBoxVirus.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    panel10.add(comboBoxVirus);
                    comboBoxVirus.setBounds(195, 140, 200, 30);

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

                    //---- btAdd ----
                    btAdd.setText("TH\u00caM");
                    btAdd.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
                    btAdd.addActionListener(e -> themBenhNhan(e));
                    panel11.add(btAdd);
                    btAdd.setBounds(0, 0, 120, 45);

                    //---- btEdit ----
                    btEdit.setText("S\u1eecA");
                    btEdit.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
                    panel11.add(btEdit);
                    btEdit.setBounds(0, 57, 119, 45);

                    //---- btDel ----
                    btDel.setText("X\u00d3A");
                    btDel.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
                    panel11.add(btDel);
                    btDel.setBounds(0, 114, 119, 45);

                    //---- btClear ----
                    btClear.setText("CLEAR");
                    btClear.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
                    btClear.addActionListener(e -> btClear(e));
                    panel11.add(btClear);
                    btClear.setBounds(0, 260, 119, 45);

                    //---- btPrint ----
                    btPrint.setText("PRINT");
                    btPrint.addActionListener(e -> print(e));
                    panel11.add(btPrint);
                    btPrint.setBounds(0, 210, 119, 45);

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

                //======== scrollPane2 ========
                {
                    scrollPane2.setBorder(new TitledBorder(null, "Danh s\u00e1ch b\u1ec7nh nh\u00e2n \u0111ang \u0111i\u1ec1u tr\u1ecb", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                        new Font("Montserrat Medium", Font.PLAIN, 14)));
                    scrollPane2.setViewportView(table2);
                }
                panel4.add(scrollPane2);
                scrollPane2.setBounds(15, 15, 655, 650);

                //======== scrollPane3 ========
                {
                    scrollPane3.setBorder(new TitledBorder(null, "Danh s\u00e1ch b\u1ec7nh nh\u00e2n xu\u1ea5t/chuy\u1ec3n vi\u1ec7n", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                        new Font("Montserrat Medium", Font.PLAIN, 14)));
                    scrollPane3.setViewportView(table3);
                }
                panel4.add(scrollPane3);
                scrollPane3.setBounds(755, 15, 620, 650);

                //---- button1 ----
                button1.setIcon(new ImageIcon(getClass().getResource("/img/right-arrow.png")));
                panel4.add(button1);
                button1.setBounds(675, 220, 75, 40);

                //---- button2 ----
                button2.setIcon(new ImageIcon(getClass().getResource("/img/arrow-left.png")));
                panel4.add(button2);
                button2.setBounds(675, 310, 75, 40);

                //---- button3 ----
                button3.setText("PRINT");
                panel4.add(button3);
                button3.setBounds(new Rectangle(new Point(605, 665), button3.getPreferredSize()));

                //---- button4 ----
                button4.setText("PRINT");
                panel4.add(button4);
                button4.setBounds(1310, 665, 63, 23);

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

                //======== scrollPane4 ========
                {
                    scrollPane4.setBorder(new TitledBorder(null, "L\u1ecbch s\u1eed th\u00eam/s\u1eeda/x\u00f3a b\u1ec7nh \u00e1n", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                        new Font("Montserrat Medium", Font.PLAIN, 14)));

                    //---- table4 ----
                    table4.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
                    scrollPane4.setViewportView(table4);
                }
                panel6.add(scrollPane4);
                scrollPane4.setBounds(25, 15, 1350, 665);

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
            panel3.addTab("L\u1ecaCH S\u1eec", new ImageIcon(getClass().getResource("/img/history.png")), panel6);
        }
        contentPane.add(panel3, BorderLayout.CENTER);
        setSize(1410, 840);
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
    private JTextField tfMaBenhNhan;
    private JLabel label7;
    private JTextField tfHoVaTen;
    private JLabel label8;
    private JTextField tfNamSinh;
    private JLabel label9;
    private JTextField tfDiaChi;
    private JLabel label10;
    private JComboBox<String> comboBoxGioiTinh;
    private JLabel label11;
    private JTextField tfDienThoai;
    private JPanel panel9;
    private JLabel label12;
    private JTextField tfBHYT;
    private JLabel label13;
    private JTextField tfCCCD;
    private JPanel panel10;
    private JLabel label14;
    private JTextField tfNgayTiepNhan;
    private JLabel label16;
    private JTextField tfMaBacSi;
    private JLabel label17;
    private JComboBox<String> comboBoxGiaiDoan;
    private JLabel label18;
    private JComboBox comboBoxVirus;
    private JPanel panel11;
    private JButton btAdd;
    private JButton btEdit;
    private JButton btDel;
    private JButton btClear;
    private JButton btPrint;
    private JLabel label15;
    private JPanel panel4;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel6;
    private JScrollPane scrollPane4;
    private JTable table4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
