import javax.swing.*;
import java.awt.*;

public class LoginForm extends JDialog{
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btOK;
    private JButton btCancel;
    private JPanel loginForm;

    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginForm);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
    LoginForm loginForm = new LoginForm(null);
    }
}
