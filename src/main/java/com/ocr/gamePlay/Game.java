package com.ocr.gamePlay;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

/**
 * class mere qui regroupe toute les methodes quand va utiliser tout au long de notre jeux
 */
public class Game {
    static Logger logger = LogManager.getLogger(Game.class);
    int tailleCombinaison ;
    int nombreEssai ;
    String mode_Devloppeur;
    String [] tableau ;
    int []combinaison;
    int[] combinaisonAleatoire ;
    protected boolean modeDevloppeur;
    String [] result;
    int[] min ;
    int[] max ;
    String[] signe ;
    int []propositionSysteme ;
    static boolean modeDev= false;
    Scanner sc = new Scanner( System.in );
    InputStream input;

    /**
     * constructeur par defaut qui telecharge les variable qui se trouve dans le ficher config.properties,
     */

    public Game() {
        try {

            input = new FileInputStream(new File( "resources/config.properties" ));
            Properties prop = new Properties();

            // load a properties file

            prop.load(input);
            tailleCombinaison = Integer.parseInt( prop.getProperty( "taille.combinaison" ) );
            nombreEssai = Integer.parseInt( (prop.getProperty("nombre.essai")) );
            if (modeDev){
                mode_Devloppeur = "active" ;}
            else {
                mode_Devloppeur =  (prop.getProperty("mode.developpeur"));}

        } catch (IOException ex) {
            tailleCombinaison=4;
            logger.error("Probleme de telechargement de fichier config.properties");
            ex.printStackTrace();
        }
        max= new int[tailleCombinaison];
        min = new int [tailleCombinaison];
        for (int i=0; i<tailleCombinaison; i++)
        {
            min[i]=0;
            max[i]=9;
        }
        tableau = new String[tailleCombinaison];
        combinaison=new int[tailleCombinaison];
        combinaisonAleatoire = new int[tailleCombinaison];
        signe = new String[tailleCombinaison];
        propositionSysteme = new int[tailleCombinaison];
        result = new String[tailleCombinaison];

    }

    /**
     * isModeDevloppeur verivier si le mode devloppeur active ou non
     * @return boolean modeDevloppeur
     */

    public boolean isModeDevloppeur() {
        modeDevloppeur =false;
        if(mode_Devloppeur.equals( "active" ))
            modeDevloppeur =true;
        return modeDevloppeur;
    }

    /**
     * saisieUtilisateur permet a l´utilisateur de saisir sa combainaison
     * @return int [] combinaison
     */

    public int [] saisieUtilisateur()
    {
        combinaison=new int[tailleCombinaison];
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
     * combinaision  proposer par le systeme
     * @return int [] combinaison
     */

    public int[] combinaisonSystem() {
        Random r = new Random();
        for (int i = 0; i < tailleCombinaison; i++) {
            combinaisonAleatoire[i] = r.nextInt( 9 );
        }
        return combinaisonAleatoire;
    }

    /**
     *afficheTabInt affiche les element d'un tableau d'entier
     * @param   tableau  [] int
     */
    public void afficheTabInt(int [] tableau)
    {
        for (int i = 0; i < tableau.length; i++)
            System.out.print( tableau [i]);
    }

    /**
     *afficheTabString affiche les éléments d'un tableau de chaine de caractaire
     * @param tableau [] String
     */
    public void afficheTabString(String [] tableau)
    {
        for (int i = 0; i < tableau.length; i++)
            System.out.print( tableau [i]);
    }

    /**
     * comparer deux combinaisions, qui prend en parametre deux tableaux
     * la combinaison secréte et la proposition
     * @param combinaisonAleatoire [] int
     * @param combinaison [] int
     * @return String [] result
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
     * displayResutCompared affiche la  resultat du comapraision des deux combinaisons,
     * elle prend en parametre String [], si tout le tabeau contient = elle retourne true
     * si non false
     * @param result [] String
     * @return boolean x
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
     * rechercheDichotomique retourne une proposition  proposé par l'ordinateur,
     * prend en parametre la combinaisonSecrete de l'utilisateur
     * @param combinaisonSecrete [] int
     * @return int [] propositionSysteme
     */
    public int[] rechercheDichotomique(int [] combinaisonSecrete) {
        int milieu;
        for (int j = 0; j <combinaisonSecrete.length; j++) {
            if (min[j] <= max[j]) {
                milieu = ((min[j] + max[j]) / 2);
                propositionSysteme[j] = milieu;
                if (combinaisonSecrete[j] == milieu) {
                    signe[j] = "=";
                }
                else if (milieu < combinaisonSecrete[j]) {

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