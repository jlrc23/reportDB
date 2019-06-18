/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportdb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import beans.Column;
import database.ConnectJDBC;
import database.Tables;
import utils.ReporteTablas;
import utils.TypeField;

/**
 *
 * @author itzel
 */
public class ReportDB {
    private static final int COL_NO_NULLS = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> fields = new HashMap<>();
        ConnectJDBC con = null;
        try {
            con = new ConnectJDBC();
            Statement st = con.getStament();
            ArrayList<String>  tables = Tables.getTables(st);
            if (tables.size() > 0) {
                for (int i = 0; i < tables.size(); i++) {
                    try{
                        ResultSet rsFields = st.executeQuery("SELECT * FROM " + tables.get(i) + " limit 1 ");
                        System.out.println((i + 1) + " .-Table: " + tables.get(i));
                        ReporteTablas report = new ReporteTablas(tables.get(i));
                        for (int x = 1; x <= rsFields.getMetaData().getColumnCount(); x++) {
                            Column col = new Column();
                            col.setPresicion(rsFields.getMetaData().getPrecision(x));
                            col.setMax(rsFields.getMetaData().getColumnDisplaySize(x));
                            col.setIsKey(rsFields.getMetaData().isAutoIncrement(x));
                            int isNull = rsFields.getMetaData().isNullable(x) == COL_NO_NULLS ? 0: 1;
                            col.setIsNull(isNull);
                            col.setType(TypeField.getTypeField(rsFields.getMetaData().getColumnType(x)));       
                            col.setName(rsFields.getMetaData().getColumnName(x));
                            report.addColumn(col);
                        }
                        report.save();
                        rsFields.close();

                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                   
                }

            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(con!= null)
                con.closeConnection();
        }

    }
    
    
    
    
}
