package Projet;

public class Coordoner implements Comparable<Coordoner> {

    int x;
    int y;

    /**
     * @author Pierre-Francois Hau
     * @param x
     * @param y
     */
    public  Coordoner (int x,int y){
        this.x=x;
        this.y=y;
    }

    /**
     * @aurhor Pierre-Francois Hau
     * @param i
     */
    public void augmenterX(int i) {
        this.x=x+i;
    }

    /**
     * @author Pierre-Francois Hau
     * @param i
     */
    public void augmenterY(int i){
        this.y=y+i;
    }

    /**
     * @author Pierre-Francois Hau
     * @param c
     * @return -1 si la Coordoner souhaiter est inferieur
     */
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

    /**
     * @author Pierre-Francois Hau
     * @return l'entier x
     */
    public int getX() {
        return x;
    }

    /**
     * @author Pierre-Francois Hau
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @author Pierre-Francois Hau
     * @return l'entier y
     */
    public int getY() {
        return y;
    }

    /**
     * @author Pierre-Francois Hau
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @author Pierre-Francois Hau
     * @return la coordoner souhaiter sous forme de String
     */
    public String toString(){
        String str =x+" "+y;
        return str;
    }
}

