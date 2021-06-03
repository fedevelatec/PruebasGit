package com.fedevela.fechas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//@author  Henry Joe Wong Urquiza
public class ManejadorFechas {

    //Metodo usado para obtener la fecha actual
    //@return Retorna un <b>STRING</b> con la fecha actual formato "dd-MM-yyyy"
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    //Metodo usado para obtener la hora actual del sistema
    //@return Retorna un <b>STRING</b> con la hora actual formato "hh:mm:ss"
    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }

    //Sumarle dias a una fecha determinada
    //@param fch La fecha para sumarle los dias
    //@param dias Numero de dias a agregar
    //@return La fecha agregando los dias
    public static java.sql.Date sumarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Restarle dias a una fecha determinada
    //@param fch La fecha
    //@param dias Dias a restar
    //@return La fecha restando los dias
    public static synchronized java.sql.Date restarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, -dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas
    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = new Date( System.currentTimeMillis() );
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
            return null;
        }
    }

    public static synchronized String restaHoras(Date fechaMenor, Date  fechaMayor ){
        long diferenciaMils = fechaMayor.getTime() - fechaMenor.getTime();
        long segundos = diferenciaMils / 1000;
        long horas = segundos / 3600;
        segundos -= horas * 3600;
        long minutos = segundos / 60;
        segundos -= minutos * 60;
        return horas + ":" + minutos + ":" + segundos;
        //System.out.println(horas + ":" + minutos + ":" + segundos);
    }
    
    public static void main(String[] args) {
        System.out.println(getFechaActual());
        System.out.println(getHoraActual());
        System.out.println(sumarFechasDias(new java.sql.Date(System.currentTimeMillis()), 40));
        System.out.println(restarFechasDias(new java.sql.Date(System.currentTimeMillis()), 40));

        java.util.Date fechaMenor = new java.util.Date(2011, 03, 15, 8, 15, 23);
        java.util.Date fechaMayor = new java.util.Date(2011, 03, 15, 11, 20, 40);
        
        System.out.println( restaHoras(fechaMenor, fechaMayor) );
        StringBuilder sql = new StringBuilder();
        
        sql.append("Cualquie query");
        sql.append("No importa como se ponga");
        
        System.out.println( sql.toString() );
    }
}
