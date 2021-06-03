
package com.fedevela.Excel;

import static com.fedevela.Excel.ImageFilter.getExtension;
import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author fvelazquez
 */
public class ExcelFilter  extends FileFilter {
 
    //Accept all directories and all gif, jpg, tiff, or png files.
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
 
        String extension = getExtension(f);
        if (extension != null) {
            if ( extension.equals("xls") ) {
                    return true;
            } else {
                return false;
            }
        }
 
        return false;
    }
 
    /**
     *The description of this filter
     * @return
     */
    @Override
    public String getDescription() {
        return "Hasta Excel 2003, *.xls";
    }
    
    /*
     * Get the extension of a file.
     */  
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
}
