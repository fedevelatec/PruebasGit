package com.fedevela.Excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fvelazquez
 */
public class LeerArchivoExcelMain {
    
    public static void main(String arg[]) {
        try {
            ProcesarDatosHoja hoja = new ProcesarDatosHoja();
            
           List registros = hoja.cargarDatos("C:\\Users\\fvelazquez\\Downloads\\Base Seguros Monterrey.xls", 0);
            int f, longitud=registros.size();
            for ( f = 0; f < longitud; f++) {
                ArchivoVO u = (ArchivoVO) registros.get(f);
                System.out.println(f + 1);
                System.out.println("    Tipo Tramite;              " + u.getTipoTramite());
                System.out.println("    Numero Tramite;            " + u.getNumeroTramite());
                System.out.println("    Ciudad;                    " + u.getCiudad());
                System.out.println("    Ciudad Divisional;         " + u.getCiudadDivisional());
//                if (u.getFecha() != null) {
//                    SimpleDateFormat sdf;
//                    sdf = new SimpleDateFormat("dd/MM/yyyy");
//                    System.out.println("    Fecha==&gt;        " + sdf.format(u.getFecha()));
//                }
                System.out.println();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerArchivoExcelMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatoUsuariosException ex) {
            Logger.getLogger(LeerArchivoExcelMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProcesarDatosHoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
