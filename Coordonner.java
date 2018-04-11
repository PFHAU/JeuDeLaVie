package com.france.JeuDeLaVie;

public class Coordonner implements CoordonnerInt {
    private int x;
    private int y;

    public Coordonner(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {

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
}
