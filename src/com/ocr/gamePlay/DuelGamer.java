package com.ocr.gamePlay;

public class DuelGamer extends Game {

    public void playDuel () {
        int nombreTour = 0;
        boolean compar;
        int[] combinaison =combinaisonSystem();
        System.out.println( "Saisir votre combinaison secrete : " );
        int[] combinaisonUtilisateur = saisieUtilisateur();

        do {
            nombreTour++;
            System.out.println( "Saisir votre proposition " );
            int[] proposition = saisieUtilisateur();
            System.out.print( "\n " );
            result = compared( combinaison, proposition );
            System.out.print( "la combinaison secrete est : " );
            afficheTabInt( combinaison );
            System.out.print( "\n " );
            System.out.print( "votre proposition est: " );
            afficheTabInt( proposition );
            afficheTabString( result );
            System.out.print( "\n " );
            compar = displayResutCompared( result );

            if (compar == true) {
                System.out.println( "Félicitation vous avez deviné la combinaison secrète " );
                break;
            } else {
                System.out.println( "Vous avez raté " );
                int[] propositionSystheme = propositionSysteme(combinaisonUtilisateur);
                result = compared( propositionSystheme, combinaisonUtilisateur );
                System.out.print( "votre combinaison est: " );
                afficheTabInt( combinaisonUtilisateur );
                System.out.print( "\n " );
                System.out.print( "Ma proposition est : " );
                afficheTabInt( propositionSystheme );
                System.out.print( "\n " );
                afficheTabString( result );
                compar = displayResutCompared( result );
            }
            if (compar == true) {
                System.out.println( "J´ai deviné votre combinaison secrète " );
                break;
            } else {
                System.out.println( "J'ai raté" );
            }
        }while (!compar && nombreTour < nombreEssai) ;
        }
    }