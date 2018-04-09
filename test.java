package Projet;

public class test {
    public static void main (String args []){
        Coordoner c1 = new Coordoner (1,2);
        Coordoner c2 = new Coordoner (2,1);
        Coordoner c3 = new Coordoner (2,2);
        Coordoner c0 = new Coordoner (1,1);
        Maillon m3= new Maillon (c3, null);
        Maillon m2= new Maillon (c2, m3);
        Maillon m1= new Maillon (c1, m2);
        Maillon m0= new Maillon (c0, m1);
        Liste l = new Liste(m0);
        afficherListe (l);

    }
    public static void afficherListe (Liste l){
        Maillon tmp=l.first;
        while (tmp.suivant!= null){
            System.out.print(tmp.o);
            tmp=tmp.suivant;
        }
        System.out.println(tmp.o);
    }

}
