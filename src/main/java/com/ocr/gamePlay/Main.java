package com.ocr.gamePlay;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
        static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("modeDev"))
        {
            Game.modeDev= true;
        }
        logger.info("commencement du jeux ");
        System.out.println("   Bienvenu \r\n");
        MenuPrincipal menu = new MenuPrincipal();
        menu. runMenu();
    }
}
