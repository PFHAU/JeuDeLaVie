package Projet;

public class Coordoner {

    int x;
    int y;
    public  Coordoner (int x,int y){
        this.x=x;
        this.y=y;
    }

    public void augmenterX(int i) {
        this.x=x+i;
    }

    public void augmenterY(int i){
        this.y=y+i;
    }

    public int compareTo(Coordoner d){// a Faire, ici c'est un test.
        return -1;
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
}

