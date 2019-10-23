package com.ocr.gamePlay;

public class DefenceurGamer extends Game{



    public void playDefenceur(){

        int nombreTour = 0;
        System.out.println( "Saisir votre combinaison secrete : " );
        int[] combinaison =saisieUtilisateur();
        System.out.print( "\n" );
        boolean comp;

             int[] premierePropositionSys = combinaisonSystem();
             System.out.println( "Ma proposition est : " );
             afficheTabInt( premierePropositionSys );
             System.out.print( "\n" );
            result = compared( premierePropositionSys, combinaison );
            System.out.println( "la Resultat de la comparaison est :" );
            afficheTabString( result );
            System.out.print( "\n" );
            comp = displayResutCompared( result );
        if(comp ==true)
            System.out.print( "j ai réussi a deviné votre combinaison " );
        else {
        do {
            nombreTour ++;
            int [] propositionSysteme = rechercheDichotomique( nombreTour );
            System.out.println( "Ma proposition est : " );
            afficheTabInt( propositionSysteme );
            System.out.print( "\n" );
            result = compared(propositionSysteme, combinaison );
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

}
