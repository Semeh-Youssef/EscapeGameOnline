package com.ocr.gamePlay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Game {
    InputStream input;
    int tailleCombinaison ;
    int nombreEssai ;
    String mode_Devloppeur;
    String [] tableau ;
    int []combinaison;
    int[] combinaisonAleatoire ;
    protected boolean modeDevloppeur;
    String [] result = new String[4];


    Scanner sc = new Scanner( System.in );

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
            tailleCombinaison=4;
            ex.printStackTrace();
        }
        tableau = new String[tailleCombinaison];
        combinaison=new int[tailleCombinaison];
        combinaisonAleatoire = new int[tailleCombinaison];
    }




    /**
     * methode permet de verivier si le mode devloppeur active ou non
     * @return
     */

    public boolean isModeDevloppeur() {
        if(mode_Devloppeur == "active")
            modeDevloppeur =true;
        else modeDevloppeur = false;
        return modeDevloppeur;
    }


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
     * cette methode affiche la  resultat du comapraision des deux combinaisons,
     * elle prend en parametre un tableau chaine de caractaire, si tout le tabeau contient = elle retourne true
     * si non false
     * @param result tableau de chaine de caractaire (+,-,=)
     * @return boolean
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
     * methode de recherche dichotomique elle prend deux variables, un tableau trier de 0 a 9 et element a rechercher
     * elle retrourne l´element rechercher
     * @param tableauTrier
     * @param elt element a rechercher
     * @return variable de type int
     */
   /** public static int rechercheDichotomique(int[] tableauTrier, int elt) {
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
     * methode permet de trouver la combinaison secrette saisie par l´utilisateur,
     * elle prend en parametre ta combinaison secrette et fait appel la methode rechercheDichotomique
     * et finalement elle return un tableau de proposition systeme
     * @param combinaison tableau contient la combinaison secrette de l´utilisateur
     * @return
     */
    /**
    public int [] propositionSysteme (int []combinaison)
    {
        int [] tableauTrier  = {0,1,2,3,4,5,6,7,8,9};
        int [] proposition = new int [tailleCombinaison];

        for (int i=0;i<combinaison.length;i++){
            proposition[i]= rechercheDichotomique( tableauTrier,combinaison[i] );}
        for (int i=0;i<proposition.length;i++)
            System.out.println( proposition[i] );

        return proposition;
    }
     **/

    public static int[][] rechercheDichotomique(int[] tableauTrier, int[] combinaison, int[]min ,int []max) {
        int n = tableauTrier.length - 1;
        int milieu;
        int[] propositionSysteme = new int[4];

        for (int j = 0; j < combinaison.length; j++) {

            if (min[j] <= max[j]) {
                milieu = (min[j] + max[j]) / 2;

                if (combinaison[j] == tableauTrier[milieu])
                    propositionSysteme[j] = milieu;
                else if (tableauTrier[milieu] < combinaison[j]) min[j] = milieu + 1;
                else max[j] = milieu - 1;
            }
        }

        int[][] proposition = {propositionSysteme, min, max };
        return proposition;
    }
    public int [][] propositionSysteme (int []combinaison) {
        int[] tableauTrier = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] prop = new int[tailleCombinaison][tailleCombinaison];

        int[] min = {0, 0, 0, 0};
        int[] max = {9, 9, 9, 9};
        int[][] prop1 = new int[tailleCombinaison][tailleCombinaison];
        prop = rechercheDichotomique( tableauTrier, combinaison, min, max );
        for (int i = 0; i < prop.length; i++) {
            for (int j = 0; j < prop[i].length; j++)
                System.out.print( prop[i][j] );
            System.out.println();
            prop1 = rechercheDichotomique( tableauTrier, combinaison, prop[1], prop[2] );
            for (int k = 0; k < prop1.length; k++) {
                for (int j = 0; j < prop1[k].length; j++)
                    System.out.print( prop1[k][j] );
                System.out.println();
            }
        }
    return prop;
}
}