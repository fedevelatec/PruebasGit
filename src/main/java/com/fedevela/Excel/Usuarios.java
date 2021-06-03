package com.fedevela.Excel;

import java.util.Date;

/**
 *
 * @author fvelazquez
 */
public class Usuarios {
    
    private String nombre;
    private String apellido;
    private Integer edad;
    private Date fecha;

    public Usuarios() {
    }

    public Usuarios(String nombre, String apellido, Integer edad, Date fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Usuarios{" 
                + "nombre=" + nombre 
                + ", apellido=" + apellido 
                + ", edad=" + edad 
                + ", fecha=" + fecha + '}';
    }
    
    
    
}
