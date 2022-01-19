import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.border.*;


/**
 * @author unknown
 */
public class Login extends JFrame {
    private Connection conn;
    private Statement stm;

    public Login() {
        initComponents();

    }
    private void showMessage(String mess){
        JOptionPane.showMessageDialog(this,mess);

    }
    private void quenpassword(MouseEvent e) throws MessagingException, UnsupportedEncodingException {


    }
    public View view;
    String tenbacsi,mabacsi,matkhau;
    String[] thongtinbacsi = new String[0];

    private void dangnhap(ActionEvent e) {
        boolean check = false;
        try{

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyhosobenhan","dangnguyen","123456");
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM doctors ");

            while (rst.next()) {
                if (rst.getString(1).equals(tfUserName.getText())) {
                    matkhau = rst.getString(2);
                }
                if (rst.getString(1).equals(tfUserName.getText()) && rst.getString(2).equals(String.valueOf(password.getPassword()))) {
                    thongtinbacsi = new String[]{rst.getString(3), rst.getString(4), rst.getString(7), rst.getString(6), rst.getString(8), rst.getString(9),rst.getString(10)};
                    tenbacsi = rst.getString(3);
                    mabacsi = rst.getString(1);
                    check = true;
                    break;
                }
            }
            if (check) {
                setVisible(false);
                view = new View(tenbacsi,mabacsi,thongtinbacsi);
                view.setVisible(true);
                view.setDefaultCloseOperation(3);

            } else {
                showMessage("ĐĂNG NHẬP THẤT BẠI!");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        clock = new JLabel();
        btLogin = new JButton();
        btExit = new JButton();
        password = new JPasswordField();
        icon = new JLabel();
        lbPassword = new JLabel();
        tfUserName = new JTextField();
        lbUserName = new JLabel();
        background = new JLabel();

        //======== this ========
        setTitle("\u0110\u0102NG NH\u1eacP");
        setIconImage(new ImageIcon(getClass().getResource("/img/medical-team.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //---- label1 ----
                label1.setText("\u0110\u0102NG NH\u1eacP");
                label1.setFont(new Font("Montserrat Black", Font.PLAIN, 30));
                label1.setForeground(new Color(14, 123, 209));
                label1.setIcon(new ImageIcon(getClass().getResource("/img/enter.png")));
                panel1.add(label1);
                label1.setBounds(25, 20, 250, 35);

                //---- clock ----
                clock.setFont(new Font("Montserrat Black", Font.PLAIN, 14));
                clock.setBorder(new TitledBorder(null, "NG\u00c0Y - GI\u1edc ", TitledBorder.RIGHT, TitledBorder.DEFAULT_POSITION,
                    new Font("Tahoma", Font.PLAIN, 14)));
                panel1.add(clock);
                clock.setBounds(305, 15, 260, 45);

                //---- btLogin ----
                btLogin.setText("\u0110\u0102NG NH\u1eacP");
                btLogin.setFont(new Font("Montserrat Black", Font.PLAIN, 10));
                btLogin.setBackground(new Color(51, 204, 0));
                btLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btLogin.addActionListener(e -> dangnhap(e));
                panel1.add(btLogin);
                btLogin.setBounds(330, 330, 105, 35);

                //---- btExit ----
                btExit.setText("THO\u00c1T");
                btExit.setFont(new Font("Montserrat Black", Font.PLAIN, 10));
                btExit.setBackground(new Color(255, 51, 0));
                btExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btExit.addActionListener(e -> exit(e));
                panel1.add(btExit);
                btExit.setBounds(450, 330, 95, 35);

                //---- password ----
                password.setBackground(new Color(70, 164, 164));
                password.setFont(new Font("Consolas", Font.PLAIN, 18));
                password.setForeground(Color.white);
                password.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                panel1.add(password);
                password.setBounds(270, 290, 280, 30);

                //---- icon ----
                icon.setIcon(new ImageIcon(getClass().getResource("/img/medical-team.png")));
                panel1.add(icon);
                icon.setBounds(250, 80, 125, 118);

                //---- lbPassword ----
                lbPassword.setText("M\u1eacT KH\u1ea8U :");
                lbPassword.setFont(new Font("Montserrat Black", Font.PLAIN, 20));
                lbPassword.setForeground(new Color(229, 85, 74));
                lbPassword.setIcon(new ImageIcon(getClass().getResource("/img/mechanical-key.png")));
                lbPassword.setLabelFor(password);
                panel1.add(lbPassword);
                lbPassword.setBounds(35, 265, 175, 78);

                //---- tfUserName ----
                tfUserName.setBackground(new Color(70, 164, 164));
                tfUserName.setFont(new Font("Consolas", Font.PLAIN, 18));
                tfUserName.setForeground(Color.white);
                tfUserName.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                panel1.add(tfUserName);
                tfUserName.setBounds(270, 235, 280, 30);

                //---- lbUserName ----
                lbUserName.setText("T\u00caN \u0110\u0102NG NH\u1eacP :");
                lbUserName.setFont(new Font("Montserrat Black", Font.PLAIN, 20));
                lbUserName.setForeground(new Color(229, 85, 74));
                lbUserName.setIcon(new ImageIcon(getClass().getResource("/img/login.png")));
                lbUserName.setLabelFor(tfUserName);
                panel1.add(lbUserName);
                lbUserName.setBounds(30, 210, 240, 78);

                //---- background ----
                background.setIcon(new ImageIcon(getClass().getResource("/img/hand-painted-watercolor-pastel-sky-background_23-2148902771.jpg")));
                panel1.add(background);
                background.setBounds(0, 5, 585, 420);

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
            dialogPane.add(panel1);
            panel1.setBounds(0, -5, 585, 425);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(585, 450);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel panel1;
    private JLabel label1;
    public JLabel clock;
    private JButton btLogin;
    private JButton btExit;
    private JPasswordField password;
    private JLabel icon;
    private JLabel lbPassword;
    private JTextField tfUserName;
    private JLabel lbUserName;
    private JLabel background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
