package com.fedevela.ftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;

/**
 *
 * @author fvelazquez
 */
public class FTPConector {

    public static void main(String[] args) throws JSchException, SftpException{
        String host = "221.211.14.5";
        String user="transfer";
        String pass="pt25VC%";
        Integer port=59830;
        
        
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        UserInfo ui = new SUserInfo(pass, null);

        session.setUserInfo(ui);
        session.setPassword(pass);
        session.connect();
        
        ChannelSftp sftp = (ChannelSftp)session.openChannel("sftp");
        sftp.connect();
        
        System.out.println("Directorio Actual: " + sftp.pwd() );
        
        //  /emc2z/expunico/L0000155/U0074353879
        
        sftp.cd("/emc2z/expunico/L0000155/U0074353879");
        
        System.out.println("Directorio Actual: " + sftp.pwd() );
        
        sftp.exit();
        sftp.disconnect();
        session.disconnect();
 
        System.out.println("----------------- FIN");




////        FTPClient ftpCliente = new FTPClient();
////        String ip = "221.211.14.5";
////        String user="transfer";
////        String pass="pt25VC%";
////        Integer port=59830;
////        Boolean login;
////        
////        ftpCliente.connect( ip, port);
////        login = ftpCliente.login( user , pass);
////        System.out.println("login: " + login);
    }
}
