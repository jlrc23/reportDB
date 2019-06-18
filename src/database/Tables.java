/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itzel
 */
public class Tables {
    public static ArrayList<String> getTables(Statement st){
        ArrayList<String> result = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SHOW TABLES");
             while (rs.next()) 
                result.add(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Tables.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(rs != null)
                try {
                    rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
}
