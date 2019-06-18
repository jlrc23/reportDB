/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.csvreader.CsvWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import beans.Column;

/**
 *
 * @author itzel
 */
public class ReporteTablas {
    public String name;
    public ArrayList<Column> cols;
    
                            //File file = new File("reportTable_" +  + ".txt");

    public ReporteTablas(String tabla) {
        this.name = tabla;
        this.cols = new ArrayList<>();
    }
    
    public void addColumn(Column col){
        this.cols.add(col);
    }
    public void save() throws IOException{
        /*BufferedWriter bw = Files.newBufferedWriter(p);
		bw.write("Curso de Java 8 para programadores Java en www.openwebinars.net");
		bw.close();*/
                //new FileWriter(file, true), ','
                
        File file = new File( "reportTable_" + this.name + ".csv");  

        CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');
        //Create Header for CSV
        csvOutput.write("Name");
        csvOutput.write("Type");
        csvOutput.write("Size");
        csvOutput.write("IsNull");
        
        csvOutput.endRecord();
        for (Column col : cols) {
            csvOutput.write(col.getName());
            csvOutput.write(col.getType());
            csvOutput.write(col.getMax()+"");
            String isNull= col.getIsNull() == 0? "Si": "No";
            csvOutput.write(isNull);
            csvOutput.endRecord();
        }
        csvOutput.flush();
        csvOutput.close();
    }
      
    
    
    
}
