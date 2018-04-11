package com.france.JeuDeLaVie;


public class Maillon <T extends Coordonner> implements MaillonInt<T>
{
    private T c;
    private Maillon <T> suivant;

    public Maillon (T c, Maillon <T> suivant)
    {
        this.c = c;
        this.suivant = suivant;
    }

    public  Maillon<T> getInstanceMaillon(T c, Maillon <T> suivant)
    {
        return new Maillon<> (c,suivant);
    }

    public T getCoor()
    {
        return c;
    }

    public Maillon <T> getSuivant()
    {
        return suivant;
    }

    public void setSuivant(Maillon <T> suivant)
    {
        this.suivant = suivant;
    }


    public int compareTo (Object temp)
    {
        Maillon<T> m = (Maillon<T>)temp;
        return c.compareTo(m.getCoor ());
    }
}
