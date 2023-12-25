import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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

                if (users != null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Email or Password Invalid",
                            "try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public Users users;
    private Users getAuthenticatedUser(String email, String password){
        Users users = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/login_schema";
        final String USERNAME = "root";
        final String PASSWORD = "Danang2018@";

try { Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    // connected to database successfully..

    Statement stmt = conn.createStatement();

}
catch (Exception e){
    e.printStackTrace();
}


        return  users;
    }

    public static void main(String[] args) {
    LoginForm loginForm = new LoginForm(null);

    }
}
