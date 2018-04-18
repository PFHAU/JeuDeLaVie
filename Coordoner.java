package Projet;

public class Coordoner implements Comparable<Coordoner> {

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

    public int compareTo(Coordoner c){
     /*   if(this==null){return -2;}
        if(c==null){return -2;}*/
     if(c==null){
         return 0;
     }
            if(this.getX()<c.getX()){
                return -1;
            }else{
                if (this.getX()>c.getX()){
                    return 1;
                }else{
                    if (this.getY()<c.getY()){
                        return -1;
                    }else{
                        if(this.getY()>c.getY()){
                            return 1;
                        }else{
                            return 0;
                        }
                    }
                }
            }


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

    public String toString(){
        String str =x+" "+y;
        return str;
    }
}

