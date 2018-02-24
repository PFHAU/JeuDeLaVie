package Projet;

import java.io.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Event;

public class Affichageplateau {
    public Liste liste;

    public Affichageplateau (Liste liste){
       liste=liste;
    }
    public static void affichage (Liste liste) {
        if (liste.first.c.x > 0) {
            for (int i = 0; i >= liste.first.c.x; i++) {
                System.out.print(" ");

            }
        }
        if (liste.first.c.y > 0) {
            for (int i = 0; i >= liste.first.c.y; i++) {
                System.out.print("\n");
            }
        }
        System.out.print("*");
    }



    static public void main(String[] args) {
    Coordoner c =new Coordoner(5,6);

    }
}