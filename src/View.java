import java.awt.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Mon Jan 17 15:23:41 ICT 2022
 */



/**
 * @author unknown
 */
public class View extends JFrame {
    public View() {
        initComponents();


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label5 = new JLabel();
        panel3 = new JTabbedPane();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("B\u1ec6NH VI\u1ec6N QU\u1ea6N QU\u00c8");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0, 204, 204));
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("PH\u1ea6N M\u1ec0M QU\u1ea2N L\u00dd H\u1ed2 S\u01a0 B\u1ec6NH \u00c1N");
            label1.setFont(new Font("Montserrat Black", Font.PLAIN, 26));
            label1.setIcon(new ImageIcon(getClass().getResource("/img/medical-report.png")));
            label1.setForeground(new Color(51, 51, 255));
            panel1.add(label1);
            label1.setBounds(820, 5, 625, label1.getPreferredSize().height);

            //---- label5 ----
            label5.setIcon(new ImageIcon(getClass().getResource("/img/1632393487_728_Hinh-anh-bac-si-dep.jpg")));
            panel1.add(label5);
            label5.setBounds(0, 0, 1450, 70);

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

            //======== panel5 ========
            {
                panel5.setLayout(null);

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
        setSize(1450, 810);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label5;
    private JTabbedPane panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
