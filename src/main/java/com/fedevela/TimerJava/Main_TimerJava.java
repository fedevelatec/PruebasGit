package com.fedevela.TimerJava;

/**
 *  http://www.devtroce.com/2010/04/12/crear-un-timer-en-java/comment-page-1/#comment-1463
 * @author fvelazquez
 */
public class Main_TimerJava {

    TimerJava r = new TimerJava();

    public static void main(String[] args) {
        Main_TimerJava m = new Main_TimerJava();
        try {
            m.r.Start(1);
        } catch (Exception e) {
        }
    }
}
