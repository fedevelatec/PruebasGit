package com.fedevela.File;

import java.io.File;
import java.io.IOException;

/**
 * http://examples.javacodegeeks.com/core-java/io/file/construct-a-file-path-in-java-example/
 */

public class JavaFilePathExample {

    public static void main(String[] args) {
        try {

            String filename = "newfile.txt";
            String createFilePath = "";
            String userHomeDirectory = System.getProperty("user.home");

            String user_operatingSystem = System.getProperty("os.name").toLowerCase();

            if (user_operatingSystem.contains("windows")) {

                createFilePath = userHomeDirectory + "\\" + filename;

            } else if (user_operatingSystem.contains("nix")	|| user_operatingSystem.contains("nux")) {
                createFilePath = userHomeDirectory + "/" + filename;
            } else {
                createFilePath = userHomeDirectory + "{smth_else}" + filename;
            }

            System.out.println("File path to create : " + createFilePath);

            File file = new File(createFilePath);

            if (file.createNewFile()) {
                System.out.println("New File created in the home directory");
            } else {
                System.out.println("The File already exists");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}