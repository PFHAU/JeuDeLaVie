package Projet;

public class test {
    public static void main (String args []){
        Coordoner c0 = new Coordoner (1,1);
        Maillon m0= new Maillon (c0, null);
        Liste testListe = new Liste(m0);

        testListe.add (new Maillon (new Coordoner (10,10),null));
        testListe.add (new Maillon (new Coordoner (3,8),null));
        testListe.add (new Maillon (new Coordoner (5,5),null));
        testListe.add (new Maillon (new Coordoner (3,3),null));
        testListe.add (new Maillon (new Coordoner (4,4),null));
        testListe.add (new Maillon (new Coordoner (4,5),null));
        testListe.add (new Maillon (new Coordoner (4,6),null));
        System.out.printf(testListe.toString());
        Methode.affichage(testListe);
        testListe.remove(new Maillon (new Coordoner (4,4),null));
        Methode.affichage(testListe);

       /* Data.stockage=testListe;
        Methode.evolution();
        Methode.affichage(Data.stockage);*/
      /*  Coordoner c1 = new Coordoner (1,2);
        Coordoner c2 = new Coordoner (2,1);
        Coordoner c3 = new Coordoner (2,4);
        Coordoner c0 = new Coordoner (1,1);
        Maillon m3= new Maillon (c3, null);
        Maillon m2= new Maillon (c2, m3);
        Maillon m1= new Maillon (c1, m2);
        Maillon m0= new Maillon (c0, m1);
        Liste l = new Liste(m0);
       Maillon m4=new Maillon (c2,null);
       Maillon m5= new Maillon (c1,null);
         //System.out.printf(l.toString());
        Data.stockage=l;
        l.addMaillon(m4);
        l.addMaillon(m5);
        System.out.printf(l.toString());*/
      /*  Methode.affichage(Data.stockage);
        Methode.evolution();
        Methode.affichage(Data.stockage );*/
     //  System.out.println( m2.compareTo(m3));
      // c2.compareTo(c3);
       // m2.remove(l);
    //    m2.compareTo(m3);
        //afficherListe(l);
       // System.out.println(l.toString());

    }
    /*public static void afficherListe (Liste l){
        Maillon tmp=l.first;
        while (tmp.suivant!= null){
            System.out.print(tmp.o);
            tmp=tmp.suivant;
        }
        System.out.println(tmp.o);
    }*/

}
