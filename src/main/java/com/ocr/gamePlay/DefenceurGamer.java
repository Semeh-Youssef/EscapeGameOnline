package com.ocr.gamePlay;

public class DefenceurGamer extends Game{



    public void playDefenceur(){

        int nombreTour = 0;
        System.out.println( "Saisir votre combinaison secrete : " );
        int[] combinaison =saisieUtilisateur();
        System.out.print( "\n" );
        boolean comp;

             int[] premierePropositionSys = combinaisonSystem();
             System.out.print( "Ma proposition est : " );
             afficheTabInt( premierePropositionSys );

            result = compared( premierePropositionSys, combinaison );
            afficheTabString( result );
            System.out.print( "\n" );
            comp = displayResutCompared( result );
        if(comp ==true)
            System.out.print( "j ai réussi a deviné votre combinaison " );
        else {
        do {
            nombreTour ++;
            int [] propositionSysteme = rechercheDichotomique( nombreTour );
            result = compared(propositionSysteme, combinaison );
            System.out.print( "Ma proposition est : " );
            afficheTabInt( propositionSysteme );
            System.out.print( " " );
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
