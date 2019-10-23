package com.ocr.gamePlay;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.apache.logging.log4j.LogManager;

public class Main {
        static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {


        logger.info(" commencement de jeux ");

        logger.error("msg d'erreur");



  System.out.println("Bienvenu \r\n");
      MenuPrincipal menu = new MenuPrincipal();
      menu. runMenu();
    }
}
