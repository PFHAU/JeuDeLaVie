package com.france.JeuDeLaVie;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Methodes
{
    //supprimer des doublons
    public static void supprimerDublons ()
    {
        Maillon<Coordonner> tempMaillon = Data.stockage.getFirst ();
        while (tempMaillon != null)
        {
            Maillon<Coordonner> tempMaillon1 = Data.stockage.getFirst ();
            int count = 0;
            while (tempMaillon1 != null)
            {
                if (tempMaillon.compareTo (tempMaillon1) == 0)
                {
                    count++;
                }
                if (count > 1)
                {
                    count--;
                    Data.stockage.supprimer (tempMaillon);
                }
                tempMaillon1 = tempMaillon1.getSuivant ();
            }
            tempMaillon = tempMaillon.getSuivant ();
        }
    }

    public static void affichage(Liste<Maillon> liste)
    {
        final int FRAME_SIZE = 20;
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

    public  static void mondeCirculaire(Liste<Maillon> liste)
    {
        //размеры поля
        int xWidth = ((Coordonner)(liste.getFirst ().getCoor ())).getX () ;
        int yHigh=((Coordonner)(liste.getFirst ().getCoor ())).getY () ;
        Maillon<Coordonner> temp = liste.getFirst ();
        while(temp.getSuivant () != null)
        {
            temp = temp.getSuivant ();
        }
        xWidth=((Coordonner)(temp.getCoor ())).getX ()-xWidth;
        yHigh=((Coordonner)(temp.getCoor ())).getY ()-yHigh;
        //
    }

    public static void mondeAvecFrontieres() {
        int sizePlace = 10;
        int xStart = ((Coordonner) (Data.stockage.getFirst ().getCoor ())).getX ();
        int yStart = ((Coordonner) (Data.stockage.getFirst ().getCoor ())).getY ();

        Maillon<Coordonner> tempMaillon = Data.stockage.getFirst ();
        while (tempMaillon != null)
        {
            int x = tempMaillon.getCoor ().getX ();
            int y = tempMaillon.getCoor ().getY ();
            if (x<xStart||y<yStart||x>xStart+sizePlace||y>yStart+sizePlace)
            {
                Data.stockage.supprimer (tempMaillon);
            }
            tempMaillon = tempMaillon.getSuivant ();
        }
        affichage (Data.stockage);
        evolution();
        affichage (Data.stockage);

        tempMaillon = Data.stockage.getFirst ();
        while (tempMaillon != null)
        {
            int x = tempMaillon.getCoor ().getX ();
            int y = tempMaillon.getCoor ().getY ();
            if (x<xStart||y<yStart||x>xStart+sizePlace||y>yStart+sizePlace)
            {
                Data.stockage.supprimer (tempMaillon);
            }
            tempMaillon = tempMaillon.getSuivant ();
        }
        affichage (Data.stockage);
    }

    public static void evolution()
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

        Data.stockage = tempListe;
        Maillon<Coordonner> tempMaillonAdd = tempListeAdd.getFirst ();
        while (tempMaillonAdd!=null)
        {
            Data.stockage.add (new Maillon (new Coordonner (tempMaillonAdd.getCoor ().getX (),tempMaillonAdd.getCoor ().getY ()),null));
            tempMaillonAdd= tempMaillonAdd.getSuivant ();
        }

        supprimerDublons ();
    }

    public static void lireFichier(String chemin) throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get(chemin), StandardCharsets.UTF_8);
        int x=0;
        int y=0;
        for(String line: lines)
        {
            if( line.compareTo ("") !=0 &&  line.compareTo (".") !=0 && (line.substring (0,2)).compareTo ("#P")==0 )
            {
                String[] xy =  line.split (" ");
                x = Integer.parseInt (xy[1]);
                y = Integer.parseInt (xy[2]);
            }
            else if(line.compareTo ("") !=0 &&
                    ((line.substring (0,1)).compareTo ("*")==0 ||((line.substring (0,1)).compareTo (".")==0)))
            {
                int temp = line.lastIndexOf ('*');

                while (temp!=-1)
                {
                    Data.stockage.add (new Maillon<Coordonner>(new Coordonner (x,y+temp),null));
                    line = line.substring (0,temp);
                    temp = line.lastIndexOf ('*');
                }
                x++;
            }

        }

        supprimerDublons ();
    }
}
