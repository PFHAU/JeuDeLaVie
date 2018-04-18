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
    public void remove(Maillon m) {
        Maillon tmp = this.getFirst();
        while (tmp!=null&& tmp.getSuivant()!=null) {
            if (tmp.compareTo(this.getFirst()) == 0) {
                this.setFirst((T) this.getFirst().getSuivant());
            }
            if (tmp.getSuivant().compareTo(m) == 0) {
                tmp.setSuivant(tmp.getSuivant().getSuivant());
            }
            tmp = tmp.getSuivant();
        }
    }

    public boolean estDans(Maillon m) {
        Maillon tmp = this.getFirst();
        while (tmp.getSuivant()!=null) {
            if (tmp.compareTo(m) == 0) {
                return true;
            }
            tmp = tmp.getSuivant();
        }
        return false;
    }

    public Liste clone()
    {
        Liste listeClone = new Liste ();
        T temp = first;
        while(temp!=null)
        {
            T temporaire = (T)(new Maillon<> (temp.getO (),null));
            listeClone.addMaillon (temporaire);
            temp= (T)temp.getSuivant ();
        }
        return listeClone;
    }

    public String toString(){

       String string="";
        T temp=first;
        while (temp!=null){
            string=string+temp.toString()+ "\n";
            temp=(T)temp.getSuivant();

        }
        return string;
    }

}
