import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        btOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email =tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                users = getAuthenticatedUser(email, password);
            }
        });
    }
    public Users users;
    private Users getAuthenticatedUser(String email, String password){
        Users users = null;
        return  users;
    }

    public static void main(String[] args) {
    LoginForm loginForm = new LoginForm(null);

    }
}
