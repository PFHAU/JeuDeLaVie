package Projet;
import java.io.*;

public  class Liste {

    public Maillon first;
    public Maillon last;


    public Liste (){
        first=null;
        last=null;
    }
    public boolean vide(){
        return last == null;
    }
    public void add (Coordoner c){
        Maillon m= new Maillon(c,null);
        if (first==null) first=m;
        else{
            Maillon tmp=first;

            while (m.compareTo(tmp.suivant)==-1){
                tmp=tmp.suivant;
            }
            m.suivant=tmp.suivant;
            tmp.suivant=m;
        }
        /* last.suivant=m;
        last=m;*/
    }
    public void remove (Maillon m){
      /*if(vide()){
            throw new Exeption("liste vide");
        }*/
        if (first==m){
            first=m.suivant;
        }
        Maillon tmp=first;
        while (tmp.suivant!=m||tmp==last){
            tmp=tmp.suivant;
        }
        if(tmp==last){
            System.out.println("maillon inexistant");
        }
        tmp.suivant=tmp.suivant.suivant;
    }

    public void evolve (Liste vivante){
        /*pour chaque cellule vivante on verifie chaque cellule qui l'entoure, si cette cellule n est morte on regarde les 4 qui l'entour une pa une avec un compteur
        si ce compteur respect certaine regle la cellule peux passer de morte a Fvivante (elle sera vivante au prochain tour, pas maintenant pour ne pas influer
        les cellule autoure, les cellule vivante on aussi le droit a une verification pour qu'elle puisse mourire, la aussi on utilise fmorte et pas morte tous de suite
        vivante corespond a la liste que l'on va afficher
        fvivante est une autre liste pour les cellules qui vont vivre au prochain tour
        fmorte liste pour les cemllules qui vont mourire au prochain tour
        les celules =null sont considere comme morte, pour tuer une cellule on la sorte de la liste fmorte
        avant de fair passer une cellule dans la liste fmorte il faut verifier qu'elle apartien a la liste vivante
        pareil pour fvivante il faut verifier qu'elle n'apartien a aucune des trois liste avant.
         */
        Liste fvivante =new Liste();
        Liste fmorte=new Liste();

        Maillon tmp=vivante.first;//tmp est la cellules vivante que l'on visite


        while (tmp.suivant.compareTo(null)==0) {
            //on va d'abort tester si les voisine morte de tmp doivent vivre
            Maillon tmpx1=tmp;
            tmpx1.c.x++;
           if (tmpx1.estDans(vivante)==false) {
                if (tmpx1.estDans(fvivante) == false) {
                    if (tmpx1.estDans(fmorte) == false) {
                        //on verifie si elle doit vivre ou non et si oui on l'a met dans fvivre
                        //on a verifier si une cellule morte doit vivre

                    }
                }
            }
            //maintenant on fais pareil avec tmp mais pour verifier si elle doit mourire
            //on a verifier si une cellule vivante doit mourire
        }

    }



    public String toString(){
        String string="";
        for(Maillon m= first; m!=null; m=m.suivant){
            string=string +String.valueOf(m.c)+""; //valueOf pour transformer en String
        }
        return string;
    }

}
