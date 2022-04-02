package SQL;

import Controllers.ConnectionService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GetUsers extends HttpServlet {

    String username;
    String password;
    ConnectionService connectionService = new ConnectionService();
    Scanner scanner = new Scanner(System.in);

    public GetUsers() {
    }

    public String ReturnAllUsers() throws SQLException, IOException, ClassNotFoundException {

        Statement st = null;
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        ConnectionService.getConnection();
        String userName = null;

        st = ConnectionService.c.createStatement();
        rs = st.executeQuery("select * from ers_users;");

        while (rs.next()) {  //while there is record in row
            userName = rs.getString("username");
        }
        st.close();
        return userName;

    }
}
