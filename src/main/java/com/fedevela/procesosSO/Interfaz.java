package com.fedevela.procesosSO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author fvelazquez
 */
public class Interfaz {
 
	public Interfaz(){
		  if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) {
			  procesosWin();
		  } else if (System.getProperty("os.name").toLowerCase().indexOf("linux") > -1) {
			  procesosLin();
		  }
 
	}
 
	private static void procesosWin(){
		try{
		String consola = System.getenv("windir")+"\\System32\\"+"tasklist.exe";
 
		Process proceso=Runtime.getRuntime().exec(consola);
		BufferedReader entrada = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		String tmp;
		while((tmp=entrada.readLine())!=null){
			System.out.println(tmp);
 
		}
		entrada.close();
	}catch(Exception e){
		e.printStackTrace();
	}
		}
 
	private static void procesosLin(){
		try{
 
			Process proceso=Runtime.getRuntime().exec("ps -A");
			BufferedReader entrada = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String tmp;
			while((tmp=entrada.readLine())!=null){
				System.out.println(tmp);
 
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new Interfaz();
	}
}