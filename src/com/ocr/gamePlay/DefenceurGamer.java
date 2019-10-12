package com.ocr.gamePlay;

public class DefenceurGamer extends Game{



    public void playDefenceur(){

        int nombreTour = 0;
        System.out.println( "Saisir votre combinaison secrete : " );
        int[] comb =saisieUtilisateur();
        System.out.print( "\n" );
        boolean comp;
        do {
             nombreTour ++;
              int[] nb = combinaisonSystem();
            System.out.println( "Ma proposition est : " );
              afficheTabInt( nb );
              System.out.print( "\n" );
              result = compared( nb, comb );
            System.out.println( "la Resultat de la comparaison est :" );
              afficheTabString( result );
            System.out.print( "\n" );
              comp = displayResutCompared( result );

          }while( !comp && nombreTour <nombreEssai);
            if(comp ==true)
            System.out.print( "j ai réussi a deviné votre combinaison " );
            else
                System.out.println( "vous avez perdu" );
        }

}
