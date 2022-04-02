package Controllers;

import SQL.CheckUserLogin;
import SQL.GetUsers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/*
@Authored by William Bukowski

    Class that creates the http requests to the client and receives their responses.

 */
@WebServlet("/Server")
public class Servlets extends HttpServlet {

    GetUsers getUsers = new GetUsers();
    CheckUserLogin checkUserLogin = new CheckUserLogin();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Boolean userExists = false;
        String username ="";
        String password = "";

        try {
            userExists = checkUserLogin.DoesUserExist(username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if(userExists) {
            resp.getOutputStream().println(username + "Exists: logging in...");
        }













    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
}
