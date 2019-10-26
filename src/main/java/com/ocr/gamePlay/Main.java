package com.ocr.gamePlay;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.apache.logging.log4j.LogManager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


public class Main {
        static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream("config.properties")) {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("taille.combinaison", "4");
            prop.setProperty("nombre.essai", "4");
            prop.setProperty("mode.developpeur", "inactive");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException e) {
            e.printStackTrace();
        }


        logger.info("commencement du jeux ");
        System.out.println("Bienvenu \r\n");
        MenuPrincipal menu = new MenuPrincipal();
        menu. runMenu();
    }
}
