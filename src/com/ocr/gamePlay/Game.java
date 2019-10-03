package com.ocr.gamePlay;

import javax.swing.*;

public class Game extends Challenger {


    public void plays() {
        System.out.println( " Règle de jeux " );
        System.out.println( " Le système va définit une combinaison de 4 chiffres aléatoirement \n" +
                " qui est afficher en bas et vous devez le deniver " );
        System.out.println( " Attention vous avez 4 essai ! " );

        int[] nb = nbAleatoir();
        for (int i = 0; i < nb.length; i++)
            System.out.print( nb[i] );
        System.out.print( "\n" );
        int i = 0;
        do {
            int[] user = proposition();
            for (int j = 0; j < nb.length; j++)
                System.out.print( nb[j] );
            System.out.print( "\n" );
            System.out.print( compared( nb, user ) );

            if (displayResut( result ) == true) {
                System.out.println( "Felicitation vous avez deviner la combainaison" );
                break;
            } else i++;
            //  }while( i<4 || (displayResut(result)== true));
        } while (i < 4);
    }





}
