package Projet;
import java.io.*;

public class Liste <T extends Comparable> {

    public Maillon first;

    public Liste (){
        first=null;

    }

    public Liste (Maillon m){
        first=m;
    }

    public boolean vide(){
        return first == null;
    }

    public  Maillon getFirst() {
        return first;
    }

    public void setFirst(Maillon first) {
        this.first = first;
    }

    public void addMaillon (Maillon m) {//mettre en get et set suivant !!!!!!!!!
        if (this.first == null) this.first = m;
        else {
            Maillon tmp = this.first;
            while (m.compareTo(tmp) == -1) {
                tmp = tmp.getSuivant();
            }
            m.setSuivant(tmp.getSuivant());
            tmp.setSuivant(m);
        }
    }


    public String toString(){
        String string="";
        for(Maillon m= first; m!=null; m=m.suivant){
           // string += String.valueOf(m.getO) + ""; //valueOf pour transformer en String
        }
        return string;
    }

}
