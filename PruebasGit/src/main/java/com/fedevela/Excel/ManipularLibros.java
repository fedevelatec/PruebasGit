package com.fedevela.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author fvelazquez
 */
public class ManipularLibros {
    private FileInputStream fiArchivoEntrada;
    private POIFSFileSystem poiArchivo;
    private HSSFWorkbook libro;
    private HSSFSheet hoja;

    /**
     * Este método se encarga de buscar el archivo en la ruta indicada. 
     * cargando un objeto POIFSFileSystem.
     * @param strRutaArchivoIn : ruta completa y el nombre del archivo.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void cargarArchivo(String strRutaArchivoIn) throws FileNotFoundException,
            IOException {
        StringBuilder builder;

        if (strRutaArchivoIn == null) {
            builder = new StringBuilder("Debe colocar una ruta válida, valor recibido[");
            builder.append(strRutaArchivoIn).append("]");
            throw new IOException(builder.toString());
        } else if (strRutaArchivoIn.trim().length() > 0) {
            fiArchivoEntrada = new FileInputStream(strRutaArchivoIn);
            poiArchivo = new POIFSFileSystem(fiArchivoEntrada);
        } else {
            builder = new StringBuilder("Debe colocar una ruta válida, valor recibido[");
            builder.append(strRutaArchivoIn).append("]");
            throw new IOException(builder.toString());
        }

    }

    /**
     * Retorna el objeto de tipo POIFSFileSystem cargado con el método
     * cargarArchivo(String strRutaArchivoIn) 
     * @return POIFSFileSystem
     */
    public POIFSFileSystem obtenerPOIFS() {
        return poiArchivo;
    }

    /**
     * <pre>* Con este método obtenemos el libro basado en un 
     * objeto válido de tipo  POIFSFileSystem.
     * </pre>
* @return HSSFWorkbook
     * @throws IOException 
     */
    public HSSFWorkbook obtenerLibro() throws IOException {
        if (poiArchivo != null) {
            libro = new HSSFWorkbook(poiArchivo);
        }
        return libro;
    }

    /**
     * <pre>* Con este método obtenemos la hoja indicada con un indice
     * que inicia desde 0 según la hoja que se desee procesar
     * </pre>
* @param intIndiceIn
     * @return HSSFSheet
     * @throws IOException 
     */
    public HSSFSheet obtenerHoja(int intIndiceIn) throws IOException {

        libro = obtenerLibro();
        hoja = libro.getSheetAt(intIndiceIn);

        return hoja;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder b;
        b = new StringBuilder();

        Iterator<Row> row = hoja.rowIterator();

        int i = 1, h = 1;
        while (row.hasNext()) {
            Row r = row.next();
            h = 1;
            Iterator<Cell> cel = r.cellIterator();

            b.append("Registro ").append(i++).append(":\n");
            while (cel.hasNext()) {
                b.append("    Celda ").append(h++).append(": ");
                Cell c = cel.next();
                b.append("     ").append(c.toString());
                b.append("\n");
            }
            b.append("\n");
        }

        return b.toString();
    }    
    
}
