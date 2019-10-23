package com.ocr.gamePlay;

public class ChalengerGamer extends Game {

    public void plays() {
        System.out.println( "Règle de jeux " );
        System.out.println( "Le système va définit une combinaison de "+tailleCombinaison +" chiffres aléatoirement \n" +
                "qui est afficher en bas et vous devez le deniver " );
        System.out.println( "Attention vous avez "+ nombreEssai +" essai ! " );

        int nombreTour =0;

        int[] combinaisonSys = combinaisonSystem();
        //if (isModeDevloppeur() == true) {
            System.out.print( "la combinaison secrete est : " );
            afficheTabInt( combinaisonSys );
            System.out.print( "\n" );
       // }
        int i = 0;
            boolean resultJeu;
        do {
            int [] propositionUtilisateur = saisieUtilisateur();
            System.out.print( "\n" );
            String [] result = compared( combinaisonSys, propositionUtilisateur );
            afficheTabString( result );
            resultJeu= displayResutCompared( result );
            nombreTour++;

        }while( !resultJeu && nombreTour <nombreEssai);
        if(resultJeu ==true){
            System.out.println( "Felicitation vous avez deviner la combainaison" );}
        else
        {System.out.println( "vous avez perdu" );}
    }
    }






