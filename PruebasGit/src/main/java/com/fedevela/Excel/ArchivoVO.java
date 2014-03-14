package com.fedevela.Excel;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author fvelazquez
 */
public class ArchivoVO {
    private String tipoTramite;
    private String numeroTramite;
    private String ciudad;
    private String ciudadDivisional;
    private Character estatus;
    private BigInteger nunicodoc;
    private String usuario;
    private Date fecha;
    private String mensaje = "";

    
    public ArchivoVO() {
    }
    
    public ArchivoVO(String tipoTramite, String numeroTramite, String ciudad, String ciudadDivisional, Character estatus, BigInteger nunicodoc, String usuario, Date fecha, String mensaje) {
        this.tipoTramite = tipoTramite;
        this.numeroTramite = numeroTramite;
        this.ciudad = ciudad;
        this.ciudadDivisional = ciudadDivisional;
        this.estatus = estatus;
        this.nunicodoc = nunicodoc;
        this.usuario = usuario;
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(String numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudadDivisional() {
        return ciudadDivisional;
    }

    public void setCiudadDivisional(String ciudadDivisional) {
        this.ciudadDivisional = ciudadDivisional;
    }

    public Character getEstatus() {
        return estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }

    public BigInteger getNunicodoc() {
        return nunicodoc;
    }

    public void setNunicodoc(BigInteger nunicodoc) {
        this.nunicodoc = nunicodoc;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ArchivoVO{" 
                + "tipoTramite=" + tipoTramite 
                + ", numeroTramite=" + numeroTramite 
                + ", ciudad=" + ciudad 
                + ", ciudadDivisional=" + ciudadDivisional 
                + ", estatus=" + estatus 
                + ", nunicodoc=" + nunicodoc 
                + ", usuario=" + usuario 
                + ", fecha=" + fecha 
                + ", mensaje=" + mensaje + '}';
    }

    
    
}
