package Projet;
import java.io.*;

public class Liste {

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


    public String toString(){
        String string="";
        for(Maillon m= first; m!=null; m=m.suivant){
           // string += String.valueOf(m.getO) + ""; //valueOf pour transformer en String
        }
        return string;
    }

}
