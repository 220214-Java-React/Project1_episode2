package SQL;

import Controllers.ConnectionService;
import Services.Encryption;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CheckUserLogin {

    String username;
    String password;
    ConnectionService connectionService = new ConnectionService();
    Scanner scanner = new Scanner(System.in);
    Encryption encryption = new Encryption();

    public CheckUserLogin() {}

    public Boolean DoesUserExist(String username, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {

        Statement st = null;
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        ConnectionService.getConnection();
        Boolean userExists = false;

        st = ConnectionService.c.createStatement();
        rs = st.executeQuery("select * from ers_users where username = " + username + ";");
        username = rs.getString(username);
        password = rs.getString(password);

        rs = st.executeQuery("Select * From ers_users where username = " + username + ";");
        if(!rs.next()){
            String noUser = "There is no user with your credentials, try again";
        } else {
            userExists = encryption.Auth(password);
        }

        return userExists;
    }

}
