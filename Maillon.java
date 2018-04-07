package Projet;
import java.util.*;

public class Maillon  <T extends Comparable<T>> {
    T o;
    Maillon<T> suivant;

    public Maillon(T o, Maillon suivant) {
        this.o = o;
        this.suivant = suivant;
    }

    public Object getO() {
        return o;
    }

    public void setO(T o) {
        this.o = o;
    }

    public Maillon getSuivant() {
        return suivant;
    }

    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }

    public boolean equals(Maillon l) {
        return l.getO() == this.getO();
    }

    public void remove(Liste l) {
        Maillon tmp = l.first;
        while (tmp.compareTo(null) == 0) {
            if (tmp.suivant.compareTo((T)this) == 0) {
                tmp.suivant = tmp.suivant.suivant;
            }
            tmp = tmp.suivant;
        }
    }

   public boolean estDans(Liste l) {
        Maillon tmp = l.first;
        while (tmp.suivant.compareTo(null) == 0) {
            if (tmp.compareTo((T) this) == 0) {
                return true;
            }
            tmp = tmp.suivant;
        }
        return false;
    }
 /* public boolean estDans(Liste l,T obj){
      Maillon tmp = l.first;
      while (tmp.suivant!=null){
          if (compareTo(tmp,obj)==0)
      }
  }*/

    public int compareTo(T obj) {

        return ((Maillon) this.o).compareTo(((Maillon) obj).o);

   }
    /*public int compareTo(T obj,T obj2){
        return ((Maillon) obj).o.compareTo(((Maillon) obj).o);
    }*/

}
    /* public int compareTo (Maillon m) {
        if (m.c.x < this.c.x) {
            return 1;
        } else {
            if (this.c.x < m.c.x) {
                return -1;
            } else {
                if (this.c.x == m.c.x) {
                    if (m.c.y < this.c.y) {
                        return 1;
                    }
                    if (this.c.y < m.c.y) {
                        return -1;
                    }
                    if (this.c.x == m.c.x) {
                        return 0;
                    }
                }
            }
        } return 404;
    }*/






