package com.fedevela.thread;

import java.io.IOException;
/**
 *  http://arashmd.blogspot.mx/2013/07/java-thread-example.html
 * @author fvelazquez
 */
public class Base {
    public static void main(String[] args) throws IOException {
    for(int i=0;i<10;i++){
      new Thread(new BadThread("./output/"+i+".text")).start();//any path you like, would be /home/user or C:/
    }    
  }
}
