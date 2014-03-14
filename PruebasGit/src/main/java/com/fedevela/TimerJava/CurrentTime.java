package com.fedevela.TimerJava;

import java.util.Date;

/**
 *
 * @author fvelazquez
 */
public class CurrentTime {
    
    public static void main( String[] args ){
        System.out.println(  System.currentTimeMillis() );
        Date fecha = new Date( System.currentTimeMillis() );
        System.out.println(  fecha );
        fecha.getTime();
    }
    
}
