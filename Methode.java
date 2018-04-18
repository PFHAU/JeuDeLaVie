package Projet;


//comande de liste
   /*public void add (Coordoner c) {
       Maillon m = new Maillon(c, null);
       if (Liste.first == null) Liste.first = m;
       else {
           Maillon tmp = Liste.first;

           while (m.compareTo(tmp) == -1) {
               tmp = tmp.suivant;
           }
           m.suivant = tmp.suivant;
           tmp.suivant = m;
       }
   }
*/
  /* public void addMaillon (Maillon m,Liste l) {
       if (l.first == null) l.first = m;
       else {
           Maillon tmp = l.first;
           while (m.compareTo(tmp) == -1) {
               tmp = tmp.suivant;
           }
           m.suivant = tmp.suivant;
           tmp.suivant = m;
       }
   }*/

        /* last.suivant=m;
        last=m;*/
    //}
   /* public void remove (Maillon m){
      /*if(vide()){
            throw new Exeption("liste vide");
        }*/
      /*  if (Liste.first==m){
            Liste.first=m.suivant;
        }
        Maillon tmp=Liste.first;
        while (tmp.suivant!=m||tmp.suivant==null){
            tmp=tmp.suivant;
        }
        if(tmp.suivant==null){
            System.out.println("maillon inexistant");
        }
        tmp.suivant=tmp.suivant.suivant;
    }*/
//methode de maillon
/*public int compareTo (Maillon m) {// la solution est peut etre de la faire dans coordoner et ensuite un compare to des maillon qui utilise le compare to des coordoner
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
 /*   public boolean estDans(Maillon m,Liste l){
        Maillon tmp=l.first;
        while (tmp.suivant!=null){
            if (tmp.equals(m)){//tmp==this est pas bon
                return true;
            }
            tmp=tmp.suivant;
        }
        return false;
    }*/

   /* public void evolve (Liste vivante){// ne marche pas attention!
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
     /*   Liste fvivante =new Liste();
        Liste fmorte=new Liste();

        Maillon tmp=vivante.first;//tmp est la cellules vivante que l'on visite


        while (tmp.suivant!=null) {
            //on va d'abort tester si les voisine morte de tmp doivent vivre
            Maillon tmpx1=tmp;
            augmenterX(tmpx1.getO(),1);

            if (estDans(tmpx1,vivante)==false) {
                if (estDans(tmpx1,fvivante) == false) {
                    if (estDans(tmpx1,fmorte) == false) {
                        //on verifie si elle doit vivre ou non et si oui on l'a met dans fvivre
                        //on a verifier si une cellule morte doit vivre
                    }
                }
            }
            //maintenant on fais pareil avec tmp mais pour verifier si elle doit mourire
            //on a verifier si une cellule vivante doit mourire
        }

    }*/

   /* public void augmenterX(Object o, int i) {
        Coordoner c = (Coordoner) o;
        c.setX(c.getX() + i);
        o = c;
    }

    public void augmenterY(Object o, int i) {
        Coordoner c = (Coordoner) o;
        c.setY(c.getY() + i);
        o = c;
    }*/

//faire une classe de tout ce qui est bon et leur demander de corriger pour le compareTo qui ne marche inexplicablement pas la haut

   public class Methode {
        public static void affichage(Liste<Maillon> liste) {
            final int FRAME_SIZE = 10;
            for (int x = 1; x <= FRAME_SIZE; x++) {
                for (int y = 1; y <= FRAME_SIZE; y++) {
                    Maillon<Coordoner> temp = liste.getFirst();
                    boolean marque = false;
                    while (temp != null) {
                        if (x == temp.getO().getX() && y == temp.getO().getY()) {
                            marque = true;
                            break;
                        }
                        temp = temp.getSuivant();
                    }
                    if (marque) {
                        System.out.print('*');
                    } else {
                        System.out.print('.');
                    }
                }
                System.out.println();

            }
            System.out.println();

        }

        public static void evolution() {
            Liste<Maillon> tempListe = Data.stockage.clone();
            Maillon<Coordoner> tempMaillon = Data.stockage.getFirst();

            //definir ce qu'il faut supprimer
            while (tempMaillon != null) {
                int count = 0;
                int x = tempMaillon.getO().getX();
                int y = tempMaillon.getO().getY();

                Maillon<Coordoner> tempRecherche = Data.stockage.getFirst();
                while (tempRecherche != null) {
                    if (tempRecherche.getO().getX() <= (x + 1) && tempRecherche.getO().getX() >= (x - 1)
                            && tempRecherche.getO().getY() <= (y + 1) && tempRecherche.getO().getY() >= (y - 1)) {
                        count++;
                    }
                    tempRecherche = tempRecherche.getSuivant();
                }
                //on supprime le maillon pour lequel on a cherché les voisins car on l'a aussi calculé comme un voisin
                count--;

                if (!(count == 2 || count == 3)) {
                    tempListe.remove(tempMaillon);
                }
                tempMaillon = tempMaillon.getSuivant();
            }
            //Donnee.stockage = tempListe;


            Liste<Maillon> tempListeAdd = new Liste();
            tempMaillon = Data.stockage.getFirst();
            while (tempMaillon != null) {
                int x = tempMaillon.getO().getX() - 1;
                int y = tempMaillon.getO().getY() - 1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int xNear = x + j;
                        int yNear = y + i;
                        if (!Data.stockage.estDans(new Maillon<>(new Coordoner(xNear, yNear), null))) {
                            int count = 0;

                            Maillon<Coordoner> tempRecherche = Data.stockage.getFirst();
                            while (tempRecherche != null) {
                                if (tempRecherche.getO().getX() <= (xNear + 1) && tempRecherche.getO().getX() >= (xNear - 1)
                                        && tempRecherche.getO().getY() <= (yNear + 1) && tempRecherche.getO().getY() >= (yNear - 1)) {
                                    count++;
                                }
                                tempRecherche = tempRecherche.getSuivant();
                            }
                            if (count == 3) {
                                tempListeAdd.addMaillon(new Maillon(new Coordoner(xNear, yNear), null));
                            }
                        }
                    }
                }
                tempMaillon = tempMaillon.getSuivant();
            }
            //System.out.println ("-----------------------------------");
            //System.out.println ();
            //System.out.println ("Ce qu'on a après la suppression");
            //affichage (tempListe);


            //System.out.println ("Ce qu'on va ajouter");
            //affichage (tempListeAdd);


            Data.stockage = tempListe;
            Maillon<Coordoner> tempMaillonAdd = tempListeAdd.getFirst();
            while (tempMaillonAdd != null) {
                Data.stockage.addMaillon(new Maillon(new Coordoner(tempMaillonAdd.getO().getX(), tempMaillonAdd.getO().getY()), null));
                tempMaillonAdd = tempMaillonAdd.getSuivant();
            }


            // System.out.println ("résultat");
            //supprimer les doublons
            tempMaillon = Data.stockage.getFirst();
            while (tempMaillon != null) {
                Maillon<Coordoner> tempMaillon1 = Data.stockage.getFirst();
                int count = 0;
                while (tempMaillon1 != null) {
                    if (tempMaillon.compareTo(tempMaillon1) == 0) {
                        count++;
                    }
                    if (count > 1) {
                        count--;
                        Data.stockage.remove(tempMaillon);
                    }
                    tempMaillon1 = tempMaillon1.getSuivant();
                }
                tempMaillon = tempMaillon.getSuivant();
            }
            //affichage (Data.stockage);

        }

   }
