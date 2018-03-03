package Projet;

public class Maillon {
    Object o;
    Maillon suivant;
    public Maillon (Object o,Maillon suivant){
        this.o=o;
        this.suivant=suivant;
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

   /* public boolean estDans(Liste l){
        Maillon tmp=l.first;
        while (tmp.suivant.compareTo(null)==0){
            if (tmp.compareTo(this)==0){
                return true;
            }
            tmp=tmp.suivant;
        }
        return false;
    }*/


}

