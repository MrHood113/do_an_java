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
            try{
                login.clock.setFont(new Font("Montserrat",Font.BOLD,20));
                while (true){
                    Calendar calendar = Calendar.getInstance();
                    String hour = (calendar.getTime().getHours() > 9)  ? "" + calendar.getTime().getHours() + "" : "0" + calendar.getTime().getHours() ;
                    String minute = (calendar.getTime().getMinutes() > 9) ?
                            "" + calendar.getTime().getMinutes() + ""
                            : "0" + calendar.getTime().getMinutes();
                    String second = (calendar.getTime().getSeconds() > 9) ?
                            "" + calendar.getTime().getSeconds() + ""
                            : "0" + calendar.getTime().getSeconds();
                    login.clock.setText(hour + ":" + minute + ":" + second);
                    Thread.sleep(1000);

                }
            } catch(InterruptedException e ) {
                e.printStackTrace();
            }


        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
