package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
@Authored by William Bukowski

    Class that creates a connection to the AWS database and returns and connection object c
 */


public class ConnectionService {

    public static Connection c = null;

    // "jdbc:<dialect>://<host name>:<port>/<database name>?currentSchema=<schema name>"
    private static final String url = "jdbc:postgresql://postgres.ckheurx0twws.us-east-1.rds.amazonaws.com:5432/postgres"; //AWS link
    private static final String username = "postgres";
    private static final String password = "Bilbuk.1994";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        if(c == null){
            // url, username, password ->
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, username, password);
        }
        if(c != null){
            System.out.println("Connection established");
        }

        return c;
    }

    public ConnectionService(){}
}

