package com.fedevela.swing.tablaRadio.expunico;

/**
 *
 * @author fvelazquez
 */
public class CometariosCalidadBean {
    
    private String error;
    private String comentario;
    private ErrorDe errorDe;
    private Boolean autorizado;

    public CometariosCalidadBean() {
        this.error = "No ingreso Error";
        this.comentario = "";
        this.errorDe = ErrorDe.Capturista;
        this.autorizado = true;
    }

    public CometariosCalidadBean( String error ) {
        this.error = error;
        this.comentario = "";
        this.errorDe = ErrorDe.Capturista;
        this.autorizado = true;
    }

    public CometariosCalidadBean(String error, String comentario, ErrorDe errorDe, Boolean autorizado) {
        this.error = error;
        this.comentario = comentario;
        this.errorDe = errorDe;
        this.autorizado = autorizado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        System.out.println("CometariosCalidadBean - setComentario:" + comentario);
        this.comentario = comentario;
        System.out.println("CometariosCalidadBean - setComentario:" + this.comentario);
    }

    public ErrorDe getErrorDe() {
        return errorDe;
    }

    public void setErrorDe(ErrorDe errorDe) {
        this.errorDe = errorDe;
    }

    public Boolean getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Boolean autorizado) {
        this.autorizado = autorizado;
    }

    @Override
    public String toString() {
        return "CometariosCalidadBean{" + "error=" + error + ", comentario=" + comentario + ", errorDe=" + errorDe + ", autorizado=" + autorizado + '}';
    }
    
}
