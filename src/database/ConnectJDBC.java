/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itzel
 */
public class ConnectJDBC {
    Connection con = null;
    private final  String dns ="jdbc:mysql://localhost:3306/avmv";

    public ConnectJDBC() {
        try {
            this.connect();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Properties getProperties(){
        Properties props = new Properties();
        props.put("user", "");
        props.put("password", "");
        return props;

    }
    
    public void connect() throws SQLException{
        this.con = DriverManager.getConnection(this.dns, this.getProperties());
    }
    
    
    public Statement getStament() throws SQLException{
        Statement result = null;
        if(this.con == null)
            this.connect();
        result = this.con.createStatement();
        return result;
       
    }
    
    
    public void closeConnection(){
        if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    
    
    
}
