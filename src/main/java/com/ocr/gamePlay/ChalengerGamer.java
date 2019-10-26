package com.ocr.gamePlay;

/**
 * cette class presente le premier mode de jeu qui est le chalenger ,
 * l'utilisateur doit deviner la combinaison secréte saisi par l’intelligence artificielle de l’ordinateur.
 */

public class ChalengerGamer extends Game {

    /**
     * methode qui fait appel a tout  les
     */
    public void plays() {
        System.out.println( "Règle de jeux " );
        System.out.println( "Le système va définit une combinaison de "+tailleCombinaison +" chiffres aléatoirement \n" +
                "qui est afficher en bas et vous devez le deniver " );
        System.out.println( "Attention vous avez "+ nombreEssai +" essai ! " );

        int nombreTour =0;
        int[] combinaisonSys = combinaisonSystem();
        if (!isModeDevloppeur()) {
            System.out.print( "(la combinaison secrete est : ");
            afficheTabInt( combinaisonSys );
            System.out.print( " )");
            System.out.print( "\n" );
        }
        int i = 0;
            boolean resultJeu;
        do {
            System.out.print( "Saisir votre proposition : " );
            int [] propositionUtilisateur = saisieUtilisateur();

            String [] result = compared( combinaisonSys, propositionUtilisateur );
            System.out.print( "Proposition : " );
            afficheTabInt( propositionUtilisateur );
            System.out.print( " -> Réponse : " );
            afficheTabString( result );
            System.out.print( "\n" );
            resultJeu= displayResutCompared( result );
            nombreTour++;
        }while( !resultJeu && nombreTour <nombreEssai);
        if(resultJeu ==true){
            System.out.println( "Felicitation vous avez deviner la combainaison" );}
        else
        {System.out.println( "vous avez perdu" );}
    }
    }






