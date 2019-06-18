/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Types;

/**
 *
 * @author itzel
 */
public class TypeField {
    public static String getTypeField(int typeIndex){
        String result = "Indefinido";
        switch (typeIndex) {
                            case Types.BINARY:
                            case Types.CHAR:
                            case Types.LONGVARCHAR:
                            case Types.VARCHAR:
                            case Types.VARBINARY:
                            case Types.NCHAR:
                            case Types.NVARCHAR:
                            case Types.LONGNVARCHAR:
                                result = "Cadena";
                                break;
                            case Types.DATE:
                            case Types.TIME:
                            case Types.TIMESTAMP:
                                result = "Fecha";
                                break;
                            case Types.TINYINT:
                            case Types.SMALLINT:
                            case Types.FLOAT:
                            case Types.REAL:
                            case Types.DOUBLE:
                            case Types.NUMERIC:
                            case Types.DECIMAL:
                            case Types.BIGINT:
                            case Types.BIT:
                            case Types.INTEGER:
                                result = "Numerico";
                                break;
                            case Types.BLOB:
                                result = "Imagenes";
                        }
        return result;
    
    }
    
}
