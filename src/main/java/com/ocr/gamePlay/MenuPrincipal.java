package com.ocr.gamePlay;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

/**
 * Cette class presente le menu de jeu
 */

public class MenuPrincipal {
    static Logger logger = LogManager.getLogger(MenuPrincipal.class);
    /**
     * affiche la liste de menu principal
     */
    public void displayMenu() {
        System.out.print("1 - Challenger \r\n");
        System.out.print("2 - Défenseur \r\n");
        System.out.print("3 - Duel \r\n");
        System.out.print("4 - Quitter \r\n");
        System.out.println("choisissez le mode de jeu qui vous convient : \r\n");
    }
    /**
     * Affiche  le mode de jeu , elle prend en parametre un variable de type entier,
     * selon cette variable affiche le mode de jeu
     * @param nbMode numero saisir par l'utilisateur.
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
     * Exécuter le processus de demande pour le menu.
     * affiche le menu principal,
     * donne l'accès a l'utilisateur de saisir sont choix de jeu
     * qui l'on passe en parametre dans la methode displaySelectedMeu
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