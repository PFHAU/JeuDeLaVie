package com.france.JeuDeLaVie;

public class Coordonner implements Comparable {
    private int x;
    private int y;

    public Coordonner(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Object o)
    {
        Coordonner temp = (Coordonner)o;
        switch ((this.getX () < temp.getX()) ? 1 : ((this.getX () == temp.getX()) ? 0 : -1))
        {
            case 1:
                return 1;
            case 0:
                return (this.getY () < temp.getY ()) ? 1 : ((this.getY () == temp.getY ()) ? 0 : -1);
            case -1:
                return -1;
            default:
                return  404;
        }
    }

    public String toString()
    {
        String str = x + " " + y ;
        return  str;
    }
}
