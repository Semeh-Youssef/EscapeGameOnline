package com.ocr.gamePlay;

import java.util.Random;
import java.util.Scanner;

public class Defenceur {


    public Defenceur() {
    }


    static Scanner input = new Scanner(System.in);
    int numNoms;
    public  int[] combinaison() {
        System.out.println( "Règle de jeux " );
        System.out.println( "Vous devez saisir la taille de votre combinaison \n" +
                "puis vous devez les saisirs un par un \n" +
                "par suite c´est a moi de deviner votre combinaison " );
        int[] combinaisonUser = new int[0];
        try {


             numNoms = getInt( "Quelle est la Taille de votre combinaison ?" );
            combinaisonUser = new int[numNoms];
            for (int i = 0; i < combinaisonUser.length; i++) {
                combinaisonUser[i] = getInt( "Nombre n°" + (i + 1) );
            }
            for (int i = 0; i < combinaisonUser.length; ++i) {
                System.out.print( +combinaisonUser[i] );
            }
        } catch (Exception e) {
            System.out.println( "erreur de saisi" );

        }
        return combinaisonUser;
    }

    public static int getInt(String prompt) {
        System.out.print(prompt + " ");
        int entier = input.nextInt();
        return entier;
    }

    public static int getString(int prompt) {
        System.out.print(prompt + " ");
        return input.nextInt();
    }

    public int[] nbAleatoir() {
        int max = numNoms;
        int[] nb = new int[max];
        Random r = new Random();
        for (int i = 0; i < max; i++) {
            nb[i] = r.nextInt( 9 );
        }
        return nb;
    }


    /*
     * compared the number put for user with the number random
     *put the result in the String
     */
    StringBuilder result = new StringBuilder();

    public StringBuilder compared(int[] nb, int[] combinaisonUser) {

        int i = 0;
        int j = 0;
        do {
            if (nb[i] < combinaisonUser[j]) {
                result.append( '+' );

            } else if (nb[i] > combinaisonUser[j]) {
                result.append( '-' );

            } else
                result.append( '=' );

            j++;
            i++;
        }while (i<numNoms && j<numNoms);
        return result;
    }






}