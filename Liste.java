package Projet;
import java.io.*;

public class Liste <T extends Comparable> {

    public static Maillon first;

    public Liste (){
        first=null;

    }

    public Liste (Maillon m){
        first=m;
    }

    public boolean vide(){
        return first == null;
    }

    public static Maillon getFirst() {
        return first;
    }

    public static void setFirst(Maillon first) {
        Liste.first = first;
    }

    public void addMaillon (Maillon m,Liste l) {
        if (l.first == null) l.first = m;
        else {
            Maillon tmp = l.first;
            while (m.compareTo(tmp) == -1) {
                tmp = tmp.suivant;
            }
            m.suivant = tmp.suivant;
            tmp.suivant = m;
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
