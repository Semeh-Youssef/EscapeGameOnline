package com.ocr.gamePlay;

import java.util.Random;
import java.util.Scanner;

public class Utilitaire {


    String [] tableau = new String[4];
    int []tab=new int[tableau.length];
    Scanner sc = new Scanner( System.in );

    /**
     * methode qui permet a l´utilisateur de saisir sa combainaison
     * @return tableau d´entier
     */

    public int [] saisie()
    {
        try    {
            String chiffre= Integer.toString(sc.nextInt());

            for(int i=0; i<chiffre.length();i++)
            {
                tableau[i] = String.valueOf( chiffre.charAt( i ) );
            }

            for(int i=0;i<tableau.length;i++){
                tab [i] = Integer.parseInt( tableau[i]) ;
            }

            affiche( tab );
        } catch (Exception e) {
            System.out.println( "Erreur de saisi " );
            System.out.println( "Il faut saisir des valeurs pas des carcteres special ni des chaines de catractaire" );
        }
        return tab;
   }

    /**
     *
     * @return
     */

    public int[] nbAleatoir() {
        int[] nb = new int[4];
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            nb[i] = r.nextInt( 9 );
        }
        return nb;
    }

    /**
     *
     * @param tableau
     */
    public void affiche(int [] tableau)
    {
        for (int i = 0; i < tableau.length; i++)
            System.out.print( tableau [i]);
    }

    /**
     *
     * @param tableau
     */
    public void afficheString(String [] tableau)
    {
        for (int i = 0; i < tableau.length; i++)
            System.out.print( tableau [i]);
    }

    /**
     *
     */
    String [] result = new String[4];

    /**
     *
     * @param nb
     * @param user
     * @return
     */
    public String [] compared(int[] nb, int[] user) {

        int i = 0;

        do {
            if (nb[i] < user[i]) {
                result[i] = "+";
            } else if (nb[i] > user[i]) {
                result[i] = "-";
            } else
                result[i] = "=";

            i++;
        }while (i<4);
        return result;
    }

    /**
     *
     * @param result
     * @return
     */

    public boolean displayResut( String [] result){
        boolean x = true;

        for (int i = 0; i < result.length; i++)
        {
            if  (result[i].equals( "+" )  || result[i].equals( "-" ))
            {
                x= false;

            }
        }
        return x;
    }


}
