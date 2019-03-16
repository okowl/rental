package models.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    private static DB ourInstance = new DB();

    public static DB getInstance() {
        return ourInstance;
    }


    //all parameters
    private Connection conn;
    private Statement st;
    private String db_user = "root"; //here goes root username
    private String db_password = "voiD556-"; //here goes password from mysql server


    private DB() {

        try { //connection itself
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //here stays pass for the database
            //!!!!
            //should be changed if different
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca2_barbers?useSSL=false", db_user, db_password);
            st = conn.createStatement();

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            conn.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
