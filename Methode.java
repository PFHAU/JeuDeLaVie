package Projet;

   public class Methode {
       /**
        * @author Khomenko Stepan
        * @param liste
        * Liste dont l'on souhaite afficher les cellules
        */
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

       /**
        * @author Khomenko Stepan
        */
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
