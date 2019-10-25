package com.ocr.gamePlay;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

/**
 * menu de jeu
 */

public class MenuPrincipal {
    static Logger logger = LogManager.getLogger(MenuPrincipal.class);
    /**
     * Affiche tous les modes disponibles dans le jeu.
     */
    public void displayMenu() {
        System.out.print("1 - Challenger \r\n");
        System.out.print("2 - Défenseur \r\n");
        System.out.print("3 - Duel \r\n");
        System.out.print("4 - Quitter \r\n");
        System.out.println("choisissez le mode de jeu qui vous convient : \r\n");
    }
    /**
     * Afficher un mode choisi par l´utilisateur
     * @param nbMode The selected menu.
     */
    public void displaySelectedMenu(int nbMode) {

            switch (nbMode) {
                case 1:
                    System.out.println( "Vous avez choisi le mode : Challenger" );
                    ChalengerGamer user = new ChalengerGamer();
                    user.plays();
                    runMenu();
                    break;
                case 2:
                    System.out.println( "Vous avez choisi le mode : Défenseur" );
                    DefenceurGamer utilisateur = new DefenceurGamer();
                    utilisateur.playDefenceur();
                    runMenu();
                    break;
                case 3:
                    System.out.println( "Vous avez choisi le mode : Duel" );
                    DuelGamer duel=new DuelGamer();
                    duel.playDuel();
                    runMenu();
                    break;
                case 4:
                    System.out.println( "Vous avez choisi le mode : Quitter" );

                    break;
                default:
                    System.out.println( "Vous n'avez pas choisi le mode parmi les choix proposés" );
                    runMenu();
                    break;
            }
    }
    /**
     * Run asking process for a menu.
     *
     */
    public void runMenu() {
        this.displayMenu();
            int nb=0;
       try {
           Scanner sc = new Scanner(System.in);
            nb = sc.nextInt();
       }catch (Exception e)
       {logger.error ("Erreur de saisi ");}
       this.displaySelectedMenu(nb);
  }

}