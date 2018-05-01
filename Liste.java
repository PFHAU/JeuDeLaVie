package Projet;
import java.io.*;

public class Liste <T extends Maillon> {

    private T first;

    /**
     * @author Pierre-Francois Hau
     */
    public Liste (){
        first=null;

    }

    /**
     * @author Pierre-Francois Hau
     * @param m
     */
    public Liste (T m){
        first=m;
    }

    /**
     * @author Pierre-Francois Hau
     * @return true si la liste est vide, false sinon
     */
    public boolean vide(){
        return first == null;
    }

    /**
     * @author Pierre-Francois Hau
     * @return le premier element de la liste
     */
    public  T getFirst() {
        return first;
    }

    /**
     * @author Pierre-Francois Hau
     * @param first
     */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * @author Pierre-Francois Hau
     * @param m
     */
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

    /**
     * @author Pierre-Francois Hau
     * @param m
     */
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

    /**
     * @author Pierre-Francois Hau
     * @param m
     * @return un boolean
     */
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

    /**
     * @author Khomenko Stepan
     * @return un clone de la liste
     */
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

    /**
     * @author Khomenko Stepan
     * @return Le String de la liste que l'on souhaite obtenire
     */
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
