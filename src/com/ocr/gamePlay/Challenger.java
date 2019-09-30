package com.ocr.gamePlay;

import java.util.Random;
import java.util.Scanner;

public class Challenger {


    public int[] nbAleatoir(int max) {
        int[] nb = new int[max];
        Random r = new Random();
        for (int i = 0; i < max; i++) {
            nb[i] = r.nextInt( 9 );
        }
        return nb;
    }

    /**
     * Run .
     */

    public void runNbAleatoir() {
        int max = 4;
        for (int i = 0; i < max; i++) {
            int[] tab = this.nbAleatoir( max );

            System.out.println( tab[i] );
        }
    }

    /**
     * user proposition.
     */
    public int[] user = new int[4];

    public int[] proposition() {

        //int[] user = new int[4];
        try (Scanner sc = new Scanner( System.in )) {
            for (int i = 0; i < 4; i++) {
                int j = i + 1;
                System.out.println( "Saisir le " + j + " chifre(s)" );
                user[i] = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println( "Erreur de saisi " );
            System.out.println( "Il faut saisir des valeurs pas des carcteres special ni des chaines de catractaire" );
        }
        return user;
    }


    /*
     * compared the number put for user with the number random
     *put the result in the String
     */
    String[] result;

    public String[] compared(int[]nb){
        this.proposition();
        for (int i = 0; i < nb.length; i++) {
            for (int j = 0; j < proposition().length; j++) {
                for (int k = 0; k < user.length; k++) {
                    if (nb[i] == user[j]) {
                        result[k] = "=";

                    } else if (nb[i] > user[j]) {
                        result[k] = "+";
                    } else
                        result[k] = "-";
                }
            }
        }
        return result;
    }


    public void resultCompared (String [] result){

        String resultCombinaison = null;
        for( int i=0; i< result.length; i++){

            resultCombinaison = result[i];
        }
        System.out.println( resultCombinaison);
    }


    public boolean displayResut( String[] result){
        boolean x = false;

        for (int i = 0; i < result.length; i++)
        {
            while  (result[i] == "+" || result[i]== "-")
            {
                x= true;
            }
        }
        return x;
    }

}
