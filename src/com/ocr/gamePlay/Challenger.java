package com.ocr.gamePlay;

import java.util.Random;
import java.util.Scanner;

public class Challenger {


    public int[] nbAleatoir() {
        int max = 4;
        int[] nb = new int[max];
        Random r = new Random();
        for (int i = 0; i < max; i++) {
            nb[i] = r.nextInt( 9 );

        }

        return nb;
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
    StringBuilder result = new StringBuilder();

    public StringBuilder compared(int[] nb, int[] user) {

        int i = 0;
        int j = 0;
        do {
            if (nb[i] < user[j]) {
                result.append( '+' );

            } else if (nb[i] > user[j]) {
                result.append( '-' );

            } else
                result.append( '=' );

            j++;
            i++;
        }while (i<4 && j<4);
        return result;
    }



    public boolean displayResut( StringBuilder result){
        boolean x = false;
           String recherche = null;

        for (int i=0; i < result.length(); i++)
        {
           recherche = "=";
        }
        if( result.equals(recherche))
                x= true;
        else
            x=false;


        return x;
    }


    }