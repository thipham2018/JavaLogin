import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
    String sql = "SELECT * FROM users WHERE email=? AND password=?";
    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    preparedStatement.setString(1,email);
    preparedStatement.setString(2,password);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
        users = new Users();
        users.name = resultSet.getString("name");
        users.email = resultSet.getString("email");
        users.phone = resultSet.getString("phone");
        users.address = resultSet.getString("adress");
        users.password = resultSet.getString("password");
    }

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
