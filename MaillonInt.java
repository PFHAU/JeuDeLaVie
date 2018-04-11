package com.france.JeuDeLaVie;

public interface MaillonInt<E extends  Coordonner> extends Comparable {
    public E getCoor();
    public Maillon <E> getSuivant();
    public  Maillon<E> getInstanceMaillon(E c, Maillon <E> suivant);
    public void setSuivant(Maillon <E> suivant);
   //public int compareTo (Maillon <E> m);
}
