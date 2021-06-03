package com.fedevela.swing;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

public class JavaSwingJInternalFrame extends JFrame {

    JDesktopPane desktop;

    public JavaSwingJInternalFrame() {
        super("Java-Buddy");

        int inset = 50;
        setBounds(inset, inset, 500, 400);

        desktop = new JDesktopPane();
        createFrame();
        createFrame(50, 100);
        setContentPane(desktop);
    }

    private void createFrame() {
        MyInternalFrame frame = new MyInternalFrame();
        frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    private void createFrame(int x, int y) {
        MyInternalFrame frame = new MyInternalFrame(x, y);
        frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JavaSwingJInternalFrame myFrame = new JavaSwingJInternalFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

    }

    private class MyInternalFrame extends JInternalFrame {

        public MyInternalFrame() {
            super("MyInternalFrame",
                    true, //resizable
                    true, //closable
                    true, //maximizable
                    true);//iconifiable

            setSize(300, 200);
        }

        public MyInternalFrame(int offsetX, int offsetY) {
            super("MyInternalFrame",
                    true, //resizable
                    true, //closable
                    true, //maximizable
                    true);//iconifiable

            setSize(300, 200);
            setLocation(offsetX, offsetY);
        }
    }

}