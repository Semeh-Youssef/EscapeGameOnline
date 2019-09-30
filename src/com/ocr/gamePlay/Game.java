package com.ocr.gamePlay;

public class Game extends Challenger {


    public void plays(){
        System.out.println(" Règle de jeux ");
        System.out.println(" Le système va définit une combinaison de 4 chiffres aléatoirement \n" +
                " qui est afficher en bas et vous devez le deniver ");
        System.out.println(" Attention vous avez 4 essai ! ");

         runNbAleatoir();
        int i=0;
         do {
             proposition();
                i++;
         }while( i<4 || (displayResut()= true));

    }
}
