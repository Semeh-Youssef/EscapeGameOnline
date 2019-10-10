package com.ocr.gamePlay;

public class DefenceurGame extends Defenceur{

    public void playDefenceur(){

        int nombreTour = 0;
        int[] comb =saisie();
        System.out.print( "\n" );
        boolean comp;
        do {
             nombreTour ++;
              int[] nb = nbAleatoir();

              affiche( nb );
              System.out.print( "\n" );
              result = compared( nb, comb );

              afficheString( result );
            System.out.print( "\n" );
              comp = displayResut( result );

          }while( !comp && nombreTour <4);
            if(comp ==true)
            System.out.print( "j ai réussi a deviné votre combinaison " );
            else
                System.out.println( "vous avez perdu" );
        }






}
