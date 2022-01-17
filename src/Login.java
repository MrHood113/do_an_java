import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
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
    private void quenpassword(MouseEvent e) {
        System.out.println("OK");
    }
    public View view;
    String tenbacsi;
    private void dangnhap(ActionEvent e) {
        boolean check = false;
        try{

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyhosobenhan","dangnguyen","123456");
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM doctors ");

            while (rst.next()) {

                if (rst.getString(1).equals(tfUserName.getText()) && rst.getString(2).equals(String.valueOf(password.getPassword()))) {
                    tenbacsi = rst.getString(3);
                    check = true;
                    break;
                }
            }
            if (check) {
                setVisible(false);
                view = new View(tenbacsi);
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
        clock = new JLabel();
        Forgotpass = new JLabel();
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
                panel1.add(clock);
                clock.setBounds(25, 315, 190, 75);

                //---- Forgotpass ----
                Forgotpass.setText("Qu\u00ean m\u1eadt kh\u1ea9u?");
                Forgotpass.setForeground(Color.blue);
                Forgotpass.setFont(Forgotpass.getFont().deriveFont(Font.ITALIC, Forgotpass.getFont().getSize() + 3f));
                Forgotpass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Forgotpass.setIcon(new ImageIcon(getClass().getResource("/img/confusion.png")));
                Forgotpass.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        quenpassword(e);
                    }
                });
                panel1.add(Forgotpass);
                Forgotpass.setBounds(440, 370, 135, Forgotpass.getPreferredSize().height);

                //---- btLogin ----
                btLogin.setText("\u0110\u0102NG NH\u1eacP");
                btLogin.setFont(new Font("Montserrat Black", Font.PLAIN, 10));
                btLogin.setBackground(new Color(51, 204, 0));
                btLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btLogin.addActionListener(e -> dangnhap(e));
                panel1.add(btLogin);
                btLogin.setBounds(320, 285, 115, 35);

                //---- btExit ----
                btExit.setText("THO\u00c1T");
                btExit.setFont(new Font("Montserrat Black", Font.PLAIN, 10));
                btExit.setBackground(new Color(255, 51, 0));
                btExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btExit.addActionListener(e -> exit(e));
                panel1.add(btExit);
                btExit.setBounds(440, 285, 115, 35);

                //---- password ----
                password.setBackground(new Color(70, 164, 164));
                password.setFont(new Font("Consolas", Font.PLAIN, 18));
                password.setForeground(Color.white);
                password.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                panel1.add(password);
                password.setBounds(260, 230, 295, 30);

                //---- icon ----
                icon.setIcon(new ImageIcon(getClass().getResource("/img/medical-team.png")));
                panel1.add(icon);
                icon.setBounds(255, 25, 125, 118);

                //---- lbPassword ----
                lbPassword.setText("M\u1eacT KH\u1ea8U :");
                lbPassword.setFont(new Font("Montserrat Black", Font.PLAIN, 20));
                lbPassword.setForeground(new Color(229, 85, 74));
                lbPassword.setIcon(new ImageIcon(getClass().getResource("/img/mechanical-key.png")));
                lbPassword.setLabelFor(password);
                panel1.add(lbPassword);
                lbPassword.setBounds(20, 205, 175, 78);

                //---- tfUserName ----
                tfUserName.setBackground(new Color(70, 164, 164));
                tfUserName.setFont(new Font("Consolas", Font.PLAIN, 18));
                tfUserName.setForeground(Color.white);
                tfUserName.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                panel1.add(tfUserName);
                tfUserName.setBounds(260, 180, 295, 30);

                //---- lbUserName ----
                lbUserName.setText("T\u00caN \u0110\u0102NG NH\u1eacP :");
                lbUserName.setFont(new Font("Montserrat Black", Font.PLAIN, 20));
                lbUserName.setForeground(new Color(229, 85, 74));
                lbUserName.setIcon(new ImageIcon(getClass().getResource("/img/login.png")));
                lbUserName.setLabelFor(tfUserName);
                panel1.add(lbUserName);
                lbUserName.setBounds(20, 155, 235, 78);

                //---- background ----
                background.setIcon(new ImageIcon(getClass().getResource("/img/hand-painted-watercolor-pastel-sky-background_23-2148902771.jpg")));
                panel1.add(background);
                background.setBounds(0, 5, 613, background.getPreferredSize().height);

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
            panel1.setBounds(0, -5, 615, 415);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(615, 445);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel panel1;
    private JLabel clock;
    private JLabel Forgotpass;
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
