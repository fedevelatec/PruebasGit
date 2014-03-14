package com.fedevela.Excel;

/**
 *
 * @author fvelazquez
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ProcesarDatosHoja extends ManipularLibros {

    /**
     *
     * @param strArchivoIn
     * @param intIndice
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws FormatoUsuariosException
     */
    public List cargarDatos(String strArchivoIn, int intIndice) throws FileNotFoundException,
            IOException, FormatoUsuariosException {


        Iterator<Row> row = tomarRegistros(strArchivoIn, intIndice);

        ArchivoVO archivoVO = null;

        List lista = new ArrayList();
        
        //Para brincarnos la cabecera
        row.next();
        int rowNumber = 1;
        while (row.hasNext()) {
            rowNumber++;
            Row r = row.next();

            Iterator<Cell> celda = r.cellIterator();

            archivoVO = new ArchivoVO();
            int columNumber = 0;
            while (celda.hasNext()) {
                
                Cell cel = celda.next();

                //System.out.println("Celda: " + columNumber + " " + cel.getCellType());
                if (columNumber == 0) {
                    if ( cel.getCellType() == Cell.CELL_TYPE_STRING ) {
                        archivoVO.setTipoTramite(cel.getStringCellValue() );
                    } else {
                        archivoVO.setMensaje( archivoVO.getMensaje() + establecerException(cel, rowNumber, columNumber) );
                    }
                }
                if (columNumber == 1) {
                    if (cel.getCellType() == Cell.CELL_TYPE_STRING) {
                        archivoVO.setNumeroTramite(cel.getStringCellValue() );
                    } else {
                        archivoVO.setMensaje( archivoVO.getMensaje() + establecerException(cel, rowNumber, columNumber) );
                    }
                }
                if (columNumber == 2) {
                    if (cel.getCellType() == Cell.CELL_TYPE_STRING) {
                        archivoVO.setCiudad( cel.getStringCellValue() );
                    } else {
                        archivoVO.setMensaje( archivoVO.getMensaje() + establecerException(cel, rowNumber, columNumber) );
                    }
                }
                if (columNumber == 3) {
                    if (cel.getCellType() == Cell.CELL_TYPE_STRING) {

                        archivoVO.setCiudadDivisional( cel.getStringCellValue() );
//                        double d = HSSFDateUtil.getExcelDate(cel.getDateCellValue());
//
//                        if (HSSFDateUtil.isCellDateFormatted(cel)) {
//                            Date fecha = HSSFDateUtil.getJavaDate(d);
//                            usuarios.setFecha(fecha);
//                        } else {
//                            establecerException(cel, columNumber);
//                        }
                    } else {
                        archivoVO.setMensaje( archivoVO.getMensaje() + establecerException(cel, rowNumber, columNumber) );
                    }
                }
                columNumber++;
            }
            if( archivoVO.getMensaje().length() == 0 ){
                archivoVO.setMensaje("Exito");
            }
            lista.add(archivoVO);
        }
        return lista;
    }

    /**
     *
     * @param strArchivoIn
     * @param intIndice
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Iterator<Row> tomarRegistros(String strArchivoIn, int intIndice) throws FileNotFoundException,
            IOException {
        cargarArchivo(strArchivoIn);

        Sheet hoja = obtenerHoja(intIndice);

        Iterator<Row> row = hoja.rowIterator();
        return row;

    }

    public String establecerException(Cell cel, int rowNumber, int columNumber) throws FormatoUsuariosException {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("La fila [").append( rowNumber ).append("] en la columna [").append( columNumber+1 );
        builder.append("] tiene un valor incorrecto [");
        switch(cel.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                builder.append( cel.getNumericCellValue() ).append("]\n");
            break;
            case Cell.CELL_TYPE_STRING:
                builder.append( cel.getStringCellValue() ).append("]\n");
            break;
            default:
                builder.append( cel.toString() ).append("]\n");
        }
        
        //builder.append( cel.getStringCellValue() ).append("]\n");
        return builder.toString();
        //throw new FormatoUsuariosException(builder.toString());
    }
}