package com.ocr.gamePlay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Game {

    int tailleCombinaison ;
    int nombreEssai ;
    String mode_Devloppeur;
    protected boolean modeDevloppeur;

    InputStream input;

    public Game() {

        try {
            input = new FileInputStream("config.properties");
            Properties prop = new Properties();

            // load a properties file

            prop.load(input);

            tailleCombinaison = Integer.parseInt( prop.getProperty( "taille.combinaison" ) );
            nombreEssai = Integer.parseInt( (prop.getProperty("nombre.essai")) );
            mode_Devloppeur =  (prop.getProperty("mode.developpeur"));

        } catch (IOException ex) {
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
    int []combinaison=new int[tableau.length];
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
                combinaison [i] = Integer.parseInt( tableau[i]) ;
            }

        } catch (Exception e) {
            System.out.println( "Erreur de saisi " );
            System.out.println( "Il faut saisir des valeurs pas des carcteres special ni des chaines de catractaire" );
        }
        return combinaison;
   }

    /**
     * inisialiser un tableau d´entier
     */
    int[] combinaisonAleatoire = new int[tailleCombinaison];

    /**
     * combinaision de proposer par le systeme
     * @return combinaison de systeme dans un tabeau
     */
    public int[] combinaisonSystem() {
        Random r = new Random();
        for (int i = 0; i < tailleCombinaison; i++) {
            combinaisonAleatoire[i] = r.nextInt( 9 );
        }
        return combinaisonAleatoire;
    }


    /**
     *afficher les element d´un tableau d´entier
     * @param tableau (tableau de  combinaison)
     */
    public void afficheTabInt(int [] tableau)
    {
        for (int i = 0; i < tableau.length; i++)
            System.out.print( tableau [i]);
    }

    /**
     *afficher les element d´un tableau chaine de caractaire
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
     * comparer deux combinaisions, qui prend en parametre deux tableaux
     * la combinaison proposer et proposition
     * @param combinaisonAleatoire
     * @param combinaison
     * @return
     */
    public String [] compared(int[] combinaisonAleatoire, int[] combinaison) {

        int i = 0;

        do {
            if (combinaisonAleatoire[i] < combinaison[i]) {
                result[i] = "+";
            } else if (combinaisonAleatoire[i] > combinaison[i]) {
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


    /**
     *
     * @param tableauTrier
     * @param elt
     * @return
     */
    public static int rechercheDichotomique(int[] tableauTrier, int elt) {
        int n = tableauTrier.length-1;
        int min =  1;
        int  max =  n;
        int milieu ;
        int  propositionSysteme =0;

        do{
            milieu =  (min + max) / 2;
            if ( elt == tableauTrier[milieu])
                propositionSysteme =  milieu ;
            else if  (tableauTrier[milieu] < elt )  min =  milieu + 1 ;
            else max =  milieu-1 ;
        }
        while ( ( elt != tableauTrier[milieu] ) & ( min <= max ) );

        return propositionSysteme;
    }

    /**
     *
     * @param combinaison
     * @return
     */

    public int [] propositionSysteme (int []combinaison)
    {
        int [] tableauTrier  = {0,1,2,3,4,5,6,7,8,9};
        int [] proposition = new int [4];

        for (int i=0;i<combinaison.length;i++){
            proposition[i]= rechercheDichotomique( tableauTrier,combinaison[i] );}
        for (int i=0;i<proposition.length;i++)
            System.out.println( proposition[i] );

        return proposition;
    }
}
