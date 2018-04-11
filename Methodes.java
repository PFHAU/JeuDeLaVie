package com.france.JeuDeLaVie;

public class Methodes
{
    public static void affichage(Liste<Maillon> liste)
    {
        final int FRAME_SIZE = 10;
        for( int x = 1; x <= FRAME_SIZE; x++)
        {
            for( int y = 1; y <= FRAME_SIZE; y++)
            {
                Maillon<Coordonner> temp = liste.getFirst ();
                boolean marque = false;
                while(temp != null)
                {
                    if (x == temp.getCoor ().getX () && y == temp.getCoor ().getY ())
                    {
                        marque = true;
                        break;
                    }
                    temp = temp.getSuivant ();
                }
                if(marque)
                {
                    System.out.print ('*');
                }
                else
                {
                    System.out.print ('.');
                }
            }
            System.out.println ();

        }
        System.out.println ();

    }

    public static void evolution(/*Liste listeStockage*/)
    {
        Liste<Maillon> tempListe = Data.stockage.clone ();
        Maillon<Coordonner> tempMaillon =  Data.stockage.getFirst ();

        //definir ce qu'il faut supprimer
        while (tempMaillon!=null)
        {
            int count = 0;
            int x = tempMaillon.getCoor ().getX ();
            int y = tempMaillon.getCoor ().getY ();

            Maillon<Coordonner> tempRecherche = Data.stockage.getFirst ();
            while (tempRecherche != null)
            {
                if (tempRecherche.getCoor ().getX () <= (x+1) && tempRecherche.getCoor ().getX () >= (x-1)
                        && tempRecherche.getCoor ().getY () <= (y+1) && tempRecherche.getCoor ().getY () >= (y-1) )
                {
                    count++;
                }
                tempRecherche = tempRecherche.getSuivant ();
            }
            //on supprime le maillon pour lequel on a cherché les voisins car on l'a aussi calculé comme un voisin
            count--;

            if (!(count == 2 || count == 3))
            {
                tempListe.supprimer (tempMaillon);
            }
            tempMaillon = tempMaillon.getSuivant ();
        }
        //Donnee.stockage = tempListe;


        Liste<Maillon> tempListeAdd = new Liste();
        tempMaillon =  Data.stockage.getFirst ();
        while (tempMaillon != null)
        {
            int x = tempMaillon.getCoor ().getX()-1;
            int y = tempMaillon.getCoor ().getY()-1;
            for (int i = 0; i<3; i++)
            {
                for (int j = 0; j<3; j++)
                {
                    int xNear=x+j;
                    int yNear=y+i;
                    if (!Data.stockage.estDans(new Maillon<> (new Coordonner (xNear,yNear),null)))
                    {
                        int count = 0;

                        Maillon<Coordonner> tempRecherche = Data.stockage.getFirst ();
                        while (tempRecherche != null)
                        {
                            if (tempRecherche.getCoor ().getX() <= (xNear+1) && tempRecherche.getCoor ().getX() >= (xNear-1)
                                    && tempRecherche.getCoor ().getY() <= (yNear+1) && tempRecherche.getCoor ().getY() >= (yNear-1) )
                            {
                                count++;
                            }
                            tempRecherche = tempRecherche.getSuivant ();
                        }
                        if ( count == 3)
                        {
                            tempListeAdd.add (new Maillon (new Coordonner (xNear,yNear),null));
                        }
                    }
                }
            }
            tempMaillon = tempMaillon.getSuivant ();
        }
        //System.out.println ("-----------------------------------");
        //System.out.println ();
        //System.out.println ("Ce qu'on a après la suppression");
        //affichage (tempListe);


        //System.out.println ("Ce qu'on va ajouter");
        //affichage (tempListeAdd);


        Data.stockage = tempListe;
        Maillon<Coordonner> tempMaillonAdd = tempListeAdd.getFirst ();
        while (tempMaillonAdd!=null)
        {
            Data.stockage.add (new Maillon (new Coordonner (tempMaillonAdd.getCoor ().getX (),tempMaillonAdd.getCoor ().getY ()),null));
            tempMaillonAdd= tempMaillonAdd.getSuivant ();
        }


       // System.out.println ("résultat");
        //supprimer les doublons
        tempMaillon =  Data.stockage.getFirst ();
        while (tempMaillon != null) {
            Maillon<Coordonner> tempMaillon1 =  Data.stockage.getFirst ();
            int count = 0;
            while (tempMaillon1 != null)
            {
                if (tempMaillon.compareTo (tempMaillon1)==0)
                {
                    count++;
                }
                if(count>1)
                {
                    count--;
                    Data.stockage.supprimer (tempMaillon);
                }
                tempMaillon1 = tempMaillon1.getSuivant ();
            }
            tempMaillon = tempMaillon.getSuivant ();
        }
        //affichage (Data.stockage);

    }

}
