import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Login login = new Login();
            login.setVisible(true);
            login.setDefaultCloseOperation(3);


        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
