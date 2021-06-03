package com.fedevela.File;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * http://www.devtroce.com/2009/12/09/transferir-ficheros-con-por-sftp-con-java/
 * @author fvelazquez
 */

public class DescargarPorSFTP00{

    public static void DescargarPorSFTP(String pUser, String pPass,
                                        String pHost, int pPort, String pOutputStream, String pPathFile)
            throws Exception {
        JSch sftp = new JSch();
        // Instancio el objeto session para la transferencia
        Session session = null;
        // instancio el canal sftp
        ChannelSftp channelSftp = null;
        try {
            // Inciciamos el JSch con el usuario, host y puerto
            session = sftp.getSession(pUser, pHost, pPort);
            // Seteamos el password
            session.setPassword(pPass);
            // El SFTP requiere un intercambio de claves
            // con esta propiedad le decimos que acepte la clave
            // sin pedir confirmación
            Properties prop = new Properties();
            prop.put("StrictHostKeyChecking", "no");
            session.setConfig(prop);

            session.connect();

            // Abrimos el canal de sftp y conectamos
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            // Convertimos el archivo a transferir en un OutputStream
            OutputStream os = new BufferedOutputStream(new FileOutputStream(
                    pOutputStream));
            // Iniciamos la transferencia
            channelSftp.get(pPathFile, os);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            // Cerramos el canal y session
            if (channelSftp.isConnected())
                channelSftp.disconnect();
            if (session.isConnected())
                session.disconnect();
        }// end try
    }// end DescargarPorSFTP

    public static void main(String[] args){
        try {
            // El ejemplo es de una ejecucion Cliente Windows y Servidor Linux aunque esto no es relevante
            DescargarPorSFTP("miusuario", "clavesupersecreta", "192.168.1.100", 22, "C:\\devtroce.jpg", "/media/devtroce.jpg");
            System.out.println("descarga satisfactoria...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

