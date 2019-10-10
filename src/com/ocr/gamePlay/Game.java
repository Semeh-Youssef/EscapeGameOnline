package com.ocr.gamePlay;

public class Game extends Challenger {


    public void plays() {
        System.out.println( " Règle de jeux " );
        System.out.println( " Le système va définit une combinaison de 4 chiffres aléatoirement \n" +
                " qui est afficher en bas et vous devez le deniver " );
        System.out.println( " Attention vous avez 4 essai ! " );

        int nombreTour =0;

        int[] nb = nbAleatoir();
        System.out.print( "la combinaison secrete est : " );
        affiche( nb );
        System.out.print( "\n" );
        int i = 0;
            boolean resultJeu;
        do {
            int [] user = saisie();

            System.out.print( "\n" );
            String [] result = compared( nb, user );
            afficheString( result );
            resultJeu= displayResut( result );
            nombreTour++;

        }while( !resultJeu && nombreTour <4);
        if(resultJeu ==true){
            System.out.println( "Felicitation vous avez deviner la combainaison" );}
        else
        {System.out.println( "vous avez perdu" );}
    }
    }






