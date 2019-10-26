package com.ocr.gamePlay;
/**
 * cette class presente la troisième mode de jeu : Duel,
 * l'utilisateur et l’intelligence artificielle de l’ordinateur jouent tour à tour.
 * Le premier à trouver la combinaison secrète de l'autre a gagné.
 */
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
            System.out.print( "Votre proposition : " );
            afficheTabInt( proposition );
            System.out.print( " -> Réponse : " );
            afficheTabString( result );
            System.out.print( "\n " );
            compar = displayResutCompared( result );

            if (compar == true) {
                System.out.println( "Félicitation vous avez deviné la combinaison secrète " );
                break;
            } else {
               // System.out.println("Vous avez raté " );
               // System.out.print( "votre combinaison secrete est: ");
                // afficheTabInt( combinaisonUser );
              //  System.out.print( "\n " );
                int[] propositionSystheme = rechercheDichotomique( combinaisonUser ) ;
                System.out.print("Ma proposition est : ");
                afficheTabInt( propositionSystheme );
                System.out.print( " -> Réponse : " );
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