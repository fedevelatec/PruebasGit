package com.fedevela.fechas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author fvelazquez
 */
public class DiaSemana {
    
    public static void main( String[] args ){
        GregorianCalendar cal = new GregorianCalendar();
	cal.setTime( new Date(System.currentTimeMillis()) );
	System.out.println(cal.get(Calendar.DAY_OF_WEEK) );
    }
    
}
