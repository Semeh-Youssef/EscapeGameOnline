package com.ocr.gamePlay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public Game() {
    }

    int tailleCombinaison ;
    int nombreEssai ;
    String mode_Devloppeur;
    protected boolean modeDevloppeur;


       InputStream input;

    {
        try {
            input = new FileInputStream("config.properties");
            Properties prop = new Properties();

            // load a properties file

            prop.load(input);

            tailleCombinaison = Integer.parseInt( prop.getProperty( "taille.combinaison" ) );
             nombreEssai = Integer.parseInt( (prop.getProperty("nombre.essai")) );
            mode_Devloppeur =  (prop.getProperty("mode.developpeur"));

        } catch (
             IOException ex) {
                 ex.printStackTrace();
             }
          }



    public boolean isModeDevloppeur() {
        if(mode_Devloppeur == "active")
            modeDevloppeur =true;
        else modeDevloppeur = false;
        return modeDevloppeur;
    }

    String [] tableau = new String[tailleCombinaison];
    int []tab=new int[tableau.length];
    Scanner sc = new Scanner( System.in );

    /**
     * methode qui permet a l´utilisateur de saisir sa combainaison
     * @return tableau d´entier
     */

    public int [] saisieUtilisateur()
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

    public int[] combinaisonSystem() {
        int[] nb = new int[tailleCombinaison];
        Random r = new Random();
        for (int i = 0; i < tailleCombinaison; i++) {
            nb[i] = r.nextInt( 9 );
        }
        return nb;
    }

    /**
     *
     * @param tableau
     */
    public void afficheTabInt(int [] tableau)
    {
        for (int i = 0; i < tableau.length; i++)
            System.out.print( tableau [i]);
    }

    /**
     *
     * @param tableau
     */
    public void afficheTabString(String [] tableau)
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

    public boolean displayResutCompared( String [] result){
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
