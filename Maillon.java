package Projet;
import java.util.*;

public class Maillon <T extends Comparable<T>> implements Comparable<Maillon<T>> {
   private T o;
   private Maillon suivant;

    /**
     * @author Pierre-Francois Hau
     * @param o
     * @param suivant
     */
    public Maillon(T o, Maillon suivant) {
        this.o = o;
        this.suivant = suivant;
    }

    /**
     * @author Pierre-Francois Hau
     * @return o
     */
    public T getO() {
        return o;
    }

    /**
     * @author Pierre-Francois Hau
     * @param o
     */
    public void setO(T o) {
        this.o = o;
    }

    /**
     * @author Pierre-Francois Hau
     * @return le maillon suivant du maillon souhaiter
     */
    public Maillon<T> getSuivant() {
        return suivant;
    }

    /**
     * @author Pierre-Francois Hau
     * @param suivant
     */
    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }

    /**
     * @author Pierre-Francois Hau
     * @param l
     * @return true si le parametre est egale au maillon souhaiter et false sinon
     */
    public boolean equals(Maillon l) {
        return l.getO() == this.getO();
    }

    /**
     * @author Pierre-Francois Hau
     * @param l
     */
    public void remove(Liste l) {
        Maillon tmp = l.getFirst();
        while (tmp!=null&& tmp.suivant!=null) {
            if (tmp.compareTo(l.getFirst()) == 0) {
                l.setFirst(l.getFirst().getSuivant());
            }
            if (tmp.getSuivant().compareTo(this) == 0) {
                tmp.setSuivant(tmp.suivant.suivant);
            }
            tmp = tmp.suivant;
        }
    }

    /**
     * @author Pierre-Francois Hau
     * @param l
     * @return true si le maillon souhaiter est dans la liste indiquer en parametre et false sinon
     */
   public boolean estDans(Liste l) {
        Maillon tmp = l.getFirst();
        while (tmp.suivant.compareTo(null) == 0) {
            if (tmp.compareTo(this) == 0) {
                return true;
            }
            tmp = tmp.suivant;
        }
        return false;
    }

    /**
     * @author Pierre-Francois Hau
     * @param obj
     * @return -1 si le maillon est inferieur au parametre m, 0 si ils sont egaux et 1 si le parametre m est inferieur au maillon
     */
    public int compareTo(Maillon<T> obj) {

        return this.o.compareTo(obj.o);

   }

    /**
     * @author Pierre-Francois Hau
     * @return le Maillon souhaiter sous forme de String
     */
    public String toString(){
        String str =new String();
        return str = o.toString();
    }

}





