package com.ocr.gamePlay;
/**
 * cette class presente le deuxième mode de jeu Défenseur:
 * l’intelligence artificielle de l’ordinateur doit deviner la combinaison secréte saisi par l'utilisateur
 */
public class DefenceurGamer extends Game{

    public void playDefenceur(){
        int nombreTour = 0;
        System.out.println( "Saisir votre combinaison secrete : " );
        int[] combinaison =saisieUtilisateur();
        System.out.print( "\n" );
        boolean comp;

             int[] premierePropositionSys = rechercheDichotomique( combinaison );
             result = compared( premierePropositionSys, combinaison );
             System.out.print( "Proposition : " );
             afficheTabInt( premierePropositionSys );
             System.out.print( " -> Réponse : " );
             afficheTabString( result );
             System.out.print( "\n" );
             comp = displayResutCompared( result );
        if(comp ==true)
            System.out.println( "J ai réussi a deviné votre combinaison " );
        else {
        do {
            nombreTour ++;
            int [] propositionSysteme = rechercheDichotomique( combinaison );
            result = compared(propositionSysteme, combinaison );
            System.out.print( "Proposition : " );
            afficheTabInt( propositionSysteme );
            System.out.print( "-> Réponse : " );
            afficheTabString( result );
            System.out.print( "\n" );
            comp = displayResutCompared( result );
          }while( !comp && nombreTour <nombreEssai);
            if(comp ==true)
            System.out.println( "J'ai réussi a deviné votre combinaison " );
            else
                System.out.println( "J'ai perdu " );
        }
    }
}
