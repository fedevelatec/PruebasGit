/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fedevela.cadenas;

/**
 *
 * @author fvelazquez
 */
public class SubCadenaLong {
    
    public static void main( String[] args ){
        String cuenta = "00740414005092797666";
        String subCuenta = "NTNC";
        if( cuenta.length() >= 10 ){
            subCuenta = cuenta.substring( cuenta.length() - 10 , cuenta.length() );
        }
        System.out.println( subCuenta );  
    }
    
}
