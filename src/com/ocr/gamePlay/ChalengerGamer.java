package com.ocr.gamePlay;

public class ChalengerGamer extends Game {

    public void plays() {
        System.out.println( "Règle de jeux " );
        System.out.println( "Le système va définit une combinaison de 4 chiffres aléatoirement \n" +
                "qui est afficher en bas et vous devez le deniver " );
        System.out.println( "Attention vous avez 4 essai ! " );

        int nombreTour =0;

        int[] nb = combinaisonSystem();
        System.out.print( "la combinaison secrete est : " );
        afficheTabInt( nb );
        System.out.print( "\n" );
        int i = 0;
            boolean resultJeu;
        do {
            int [] user = saisieUtilisateur();

            System.out.print( "\n" );
            String [] result = compared( nb, user );
            afficheTabString( result );
            resultJeu= displayResutCompared( result );
            nombreTour++;

        }while( !resultJeu && nombreTour <4);
        if(resultJeu ==true){
            System.out.println( "Felicitation vous avez deviner la combainaison" );}
        else
        {System.out.println( "vous avez perdu" );}
    }
    }





