package com.fedevela.Excel;

/**
 *
 * @author fvelazquez
 */
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadExcelFile {

    public ReadExcelFile() {
    }

    public static void main(String args[]) {
        String fileName = "C:\\Users\\fvelazquez\\Downloads\\Base Seguros Monterrey.xls";
        List<ArchivoVO> contenidoArchivi;
        Vector dataHolder = ReadCSV(fileName);
        //printCellDataToConsole(dataHolder);
    }

    public static synchronized Vector ReadCSV(String fileName) {
        ArchivoVO row = new ArchivoVO();
        Vector cellVectorHolder = new Vector();
        try {
            FileInputStream myInput = new FileInputStream(fileName);
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
            int noOfsheets = myWorkBook.getNumberOfSheets();
            for (int i = 0; i < noOfsheets; i++) {
                HSSFSheet mySheet = myWorkBook.getSheetAt(i);
                Vector cellStoreVector;
                for (Iterator rowIter = mySheet.rowIterator(); rowIter.hasNext(); cellVectorHolder.addElement(cellStoreVector)) {
                    HSSFRow myRow = (HSSFRow) rowIter.next();
                    Iterator cellIter = myRow.cellIterator();
                    cellStoreVector = new Vector();
                    HSSFCell myCell;
                    for (; cellIter.hasNext(); cellStoreVector.addElement(myCell)) {
                        myCell = (HSSFCell) cellIter.next();
                        System.out.println( myCell.getStringCellValue() );
                    }
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellVectorHolder;
    }

    private static synchronized void printCellDataToConsole(Vector dataHolder) {
        for (int i = 0; i < dataHolder.size(); i++) {
            Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
            System.out.println("Start getting rows");
            for (int j = 0; j < cellStoreVector.size(); j++) {
                HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
                System.out.println((new StringBuilder()).append("reading column no -").append(myCell.getCellNum()).toString());
                String stringCellValue = "";
                if (myCell.getCellNum() == 0)//1st column is string based cell
                {
                    stringCellValue = String.valueOf(myCell.getStringCellValue());
                }
                if (myCell.getCellNum() == 1)//2nd column is string based cell
                {
                    stringCellValue = String.valueOf(myCell.getStringCellValue());
                }
                if (myCell.getCellNum() == 2)//3rd column is string based cell
                {
                    stringCellValue = String.valueOf(myCell.getStringCellValue());
                }
                if (myCell.getCellNum() == 3)//4th column is string based cell
                {
                    stringCellValue = String.valueOf(myCell.getStringCellValue());
                }
                if (myCell.getCellNum() == 4)//5th column is Number based cell
                {
                    stringCellValue = String.valueOf(myCell.getNumericCellValue());
                }
                if (myCell.getCellNum() == 5)//6th column is string based cell
                {
                    stringCellValue = String.valueOf(myCell.getStringCellValue());
                }
                System.out.println((new StringBuilder()).append(stringCellValue).append("\t").toString());
            }

            System.out.println("end getting rows");
        }

    }
}