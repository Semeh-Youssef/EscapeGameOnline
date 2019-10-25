package com.ocr.gamePlay;

public class DuelGamer extends Game {

    public void playDuel () {
        int nombreTour = 0;
        boolean compar;
        int[] combinaisonSys =combinaisonSystem();
        System.out.println( "Saisir votre combinaison secrete : " );
       int [] combinaisonUser = saisieUtilisateur();

        do {
            nombreTour++;
            if(!isModeDevloppeur()){
                System.out.print( "(la combinaison secrete est : " );
                afficheTabInt( combinaisonSys );
                System.out.print( " ) " );
                System.out.print( "\n " );
            }
            System.out.println( "Saisir votre proposition :" );
            int[] proposition = saisieUtilisateur();
            result = compared( combinaisonSys, proposition );
            System.out.print( "votre proposition est: " );
            afficheTabInt( proposition );
            System.out.print( " " );
            afficheTabString( result );
            System.out.print( "\n " );
            compar = displayResutCompared( result );

            if (compar == true) {
                System.out.println( "Félicitation vous avez deviné la combinaison secrète " );
                break;
            } else {

                System.out.println("Vous avez raté " );
                System.out.print( "votre combinaison secrete est: ");
                afficheTabInt( combinaisonUser );
                System.out.print( "\n " );
                int[] propositionSystheme = rechercheDichotomique( nombreTour ) ;
                System.out.print("Ma proposition est : ");
                afficheTabInt( propositionSystheme );
                System.out.print( " " );
                afficheTabString( signe );
                System.out.print( "\n " );
                compar = displayResutCompared( signe );
            }
            if (compar == true) {
                System.out.println("J´ai deviné votre combinaison secrète " );
                break;
            } else {
                System.out.println("J'ai raté" );
            }
        }while (!compar && nombreTour < nombreEssai) ;
        }
    }