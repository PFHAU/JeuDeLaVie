package Projet;
import java.io.*;

public class Liste <T extends Maillon> {

    private T first;

    public Liste (){
        first=null;

    }

    public Liste (T m){
        first=m;
    }

    public boolean vide(){
        return first == null;
    }

    public  T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void addMaillon (T m) {
        if (this.first == null) this.first = m;
        else {
            T tmp = this.first;
            while (m.compareTo(tmp) == -1) {
                tmp = (T) tmp.getSuivant();
            }
            m.setSuivant(tmp.getSuivant());
            tmp.setSuivant(m);
        }
    }


    public String toString(){

       String string="";
        for(T m= first; m!=null; m= (T) m.getSuivant()){
            string += m.getO() + ""; //valueOf pour transformer en String
        }
        return string;

    }

}
