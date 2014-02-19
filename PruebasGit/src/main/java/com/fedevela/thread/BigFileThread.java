package com.fedevela.thread;

//Big File Maker
//http://arashmd.blogspot.mx/2013/07/java-thread-example.html

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigFileThread {

	private static final Logger log = LoggerFactory.getLogger(BigFileThread.class);
	/**
	 * by Arash M. Dehghani arashmd.blogspot.com
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			new Thread(new BadThread("C:/EclipseWS/" + i + ".text")).start();//any path you like, would be /home/user or C:/
		}
	}
}

class BadThread implements Runnable {// it's not bad, because he does bad thing
										// :D
	public BadThread(String filePath) throws IOException {
		File f = new File(filePath);
		if (f.exists() == false) {
			f.createNewFile();
		}
		dos = new DataOutputStream(new FileOutputStream(filePath));
	}

	private DataOutputStream dos;
	double val = 0.0D;

	@Override
	public void run() {
		try {
			for (int i = 0; i < 1024000; i++) {// it could be even more
				val = Math.random();
				for (int j = 0; j < 8; j++) {
					dos.writeDouble(val + j);// there is no buffering [0]
				}
			}
			dos.flush();
			dos.close();
		} catch (Exception e) {
			return;
		}
	}

}
