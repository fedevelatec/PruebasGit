package com.fedevela.File;

import java.io.*;

/**
 * http://www.devtroce.com/2010/06/30/copiar-ficheros-y-directorios-con-java/
 * @author fvelazquez
 */
public class CopiarArchivoLocal {

    public static void CopiarDirectorio(File dirOrigen, File dirDestino) throws Exception {
        try {
            if (dirOrigen.isDirectory()) {
                if (!dirDestino.exists()) {
                    dirDestino.mkdir();
                }

                String[] hijos = dirOrigen.list();
                for (int i = 0; i < hijos.length; i++) {
                    CopiarDirectorio(new File(dirOrigen, hijos[i]),
                            new File(dirDestino, hijos[i]));
                } // end for
            } else {
                Copiar(dirOrigen, dirDestino);
            } // end if
        } catch (Exception e) {
            throw e;
        } // end try
    } // end CopiarDirectorio

    public static void Copiar(File dirOrigen, File dirDestino) throws Exception {

        InputStream in = new FileInputStream(dirOrigen);
        OutputStream out = new FileOutputStream(dirDestino);

        byte[] buffer = new byte[1024];
        int len;

        try {
            // recorrer el array de bytes y recomponerlo
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            } // end while
            out.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            in.close();
            out.close();
        } // end ty
    } // end Copiar

    public static void Copiar(String dirOrigen, String dirDestino) throws Exception {
        InputStream in = new FileInputStream(dirOrigen);
        OutputStream out = new FileOutputStream(dirDestino);

        byte[] buffer = new byte[1024];
        int len;

        try {
            // recorrer el array de bytes y recomponerlo
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            } // end while
            out.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            in.close();
            out.close();
        } // end ty
    } // end Copiar
}
