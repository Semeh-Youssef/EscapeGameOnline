package com.ocr.gamePlay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * class mere qui regroupe toute les methodes quand va utiliser tout au long de notre jeux
 */
public class Game {
    static Logger logger = LogManager.getLogger(Game.class);
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

    /**
     * constructeur par defaut qui telecharge les variable qui se trouve dans le ficher config.properties,
     */

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
            logger.error("Problème de télécharger le fichier .properties");
            ex.printStackTrace();
        }
        tableau = new String[tailleCombinaison];
        combinaison=new int[tailleCombinaison];
        combinaisonAleatoire = new int[tailleCombinaison];
        signe = new String[tailleCombinaison];
        propositionSysteme = new int[tailleCombinaison];
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
            logger.error( "Erreur de saisi" );

            logger.error( "Il faut saisir des valeurs pas des carcteres special ni des chaines de catractaire" );
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

     int[] tableauTrier = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
     int[] min = {0, 0, 0, 0};
     int[] max = {9, 9, 9, 9};
    String[] signe ;
     int []propositionSysteme ;

    public int[] rechercheDichotomique(int i) {
        int milieu;
        for (int j = 0; j <combinaison.length; j++) {
            if (min[j] <= max[j]) {
                milieu = (min[j] + max[j]) / 2;
                if (combinaison[j] == tableauTrier[milieu])
                {  signe[j] = "=";
                    propositionSysteme[j] = milieu;}
                else if (tableauTrier[milieu] < combinaison[j]) {
                    min[j] = milieu + 1;
                    signe[j] = "-";}
                else {
                    max[j] = milieu - 1;
                    signe[j] =  "+";
                }
            }
        }
        return propositionSysteme;
    }

}