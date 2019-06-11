package com.app.util;

import java.util.logging.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBConnectionUtility {
    public static Connection getRemoteConnection() {
        if (System.getProperty("RDS_HOSTNAME") != null) {
        try {
        Class.forName("org.postgresql.Driver");
        String dbName = System.getProperty("RDS_DB_NAME");
        String userName = System.getProperty("RDS_USERNAME");
        String password = System.getProperty("RDS_PASSWORD");
        String hostname = System.getProperty("RDS_HOSTNAME");
        String port = System.getProperty("RDS_PORT");
        String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
        log("Getting remote connection with connection string from environment variables.");
        Connection con = DriverManager.getConnection(jdbcUrl);
        log("Remote connection successful.");
        return con;
        }
        catch (ClassNotFoundException ex) { log("class not found");}
        catch (SQLException ex) { log("class not found");}
        }
        return null;
    }
}
