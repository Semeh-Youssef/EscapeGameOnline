package com.ocr.gamePlay;

import java.io.*;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        // ecrire dans le fichier config.properties
        try (OutputStream output = new FileOutputStream("config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("taille.combinaison", "4");
            prop.setProperty("nombre.essai", "4");
            prop.setProperty("mode.developpeur", "active");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);



        } catch (IOException io) {
            io.printStackTrace();
        }
        // lire le fichier config.properties

        try (InputStream input = new FileInputStream("config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            // get the property value and print it out
            System.out.println(prop.getProperty("taille.combinaison"));
            System.out.println(prop.getProperty("nombre.essai"));
            System.out.println(prop.getProperty("mode.developpeur"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        System.out.println("Bienvenu \r\n");
      MenuPrincipal menu = new MenuPrincipal();
      menu. runMenu();




    }
}
