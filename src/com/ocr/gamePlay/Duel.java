package com.ocr.gamePlay;

public class Duel extends Utilitaire {

    public void playDuel () {
        int nombreTour = 0;
        boolean compar;
        int[] combinaison = nbAleatoir();
        do {
            nombreTour++;

            int[] proposition = saisie();
            System.out.print( "\n " );
            result = compared( combinaison, proposition );
            System.out.print( "la combinaison secrete est : " );
            affiche( combinaison );
            System.out.print( "\n " );
            System.out.print( "votre proposition est: " );
            affiche( proposition );
            afficheString( result );
            System.out.print( "\n " );
            compar = displayResut( result );


            if (compar == true) {
                System.out.print( "Félicitation vous avez deviné la combinaison secrète " );
                break;
            } else {
                System.out.println( "Vous avez raté " );
                System.out.println( "Saisir votre combinaison secrete " );
                int[] combinaisonUtilisateur = saisie();

                nombreTour++;
                int[] propositionSystheme = nbAleatoir();
                result = compared( propositionSystheme, combinaisonUtilisateur );
                System.out.print( "votre combinaison est: " );
                affiche( combinaisonUtilisateur );
                System.out.print( "\n " );
                System.out.print( "Ma proposition est : " );
                affiche( propositionSystheme );
                System.out.print( "\n " );
                afficheString( result );
                compar = displayResut( result );
            }
            if (compar == true) {
                System.out.print( "J´ai deviné votre combinaison secrète " );
                break;
            } else {
                System.out.println( "J'ai raté" );

            }
        }while (!compar && nombreTour < 4) ;


        }
    }