package com.france.JeuDeLaVie;


public class Liste <E extends Maillon>
{
    private E first;

    public Liste ()
    {
        first = null;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public Liste clone( )
    {
        Liste listeClone = new Liste ();
        E temp = first;
        while(temp!=null)
        {
            E temporaire = (E)(new Maillon<> (temp.getCoor (),null));
            //E temporery1 = (E) temp.getInstanceMaillon (temp.getCoor (),null);
            listeClone.add (temporaire);
            temp= (E)temp.getSuivant ();
        }
        return listeClone;
    }

    public void add(E addition)
    {
        if(first == null || first.compareTo (addition)== -1)
        {
            E temp = first;
            first = addition;
            first.setSuivant (temp);
        }
        /*else if(first.compareTo (addition)==0)
        {
            //против дублей эволюции
            //break;
        }*/
        else
        {
            E temp = first;

            while ( temp != null)
            {
                if( temp.getSuivant () != null)
                {
                   /* if (temp.compareTo (addition)==0)
                    {

                        //против дублей эволюции
                        break;
                    }*/
                    if(temp.compareTo (addition) > -1 &&  temp.getSuivant ().compareTo (addition) < 1)
                    {
                        E conteneur = (E)temp.getSuivant ();
                        temp.setSuivant( addition);
                        addition.setSuivant(conteneur);
                        break;
                    }
                }
                else
                {
                    temp.setSuivant( addition);
                    break;
                }
                temp = (E) temp.getSuivant ();
            }
        }
    }

    public boolean estDans(E m)
    {
        E temp = first;
        while (temp!=null)
        {
            if (temp.getCoor ().compareTo (m.getCoor ())==0)
            {
                return  true;
            }
            temp = (E)temp.getSuivant ();
        }
        return false;
    }

    public void supprimer (E m)
    {
        if (first.getCoor ().compareTo (m.getCoor ()) == 0)
        {
            first = (E) first.getSuivant ();
        } else {
            //tmp-dexièm élément de la liste
            E tmp = (E) first.getSuivant ();
            //tmpPrevious-premier élément
            E précédent = first;

            while (tmp != null)
            {
                if (tmp.getCoor ().compareTo (m.getCoor ()) == 0)
                {
                    précédent.setSuivant (tmp.getSuivant ());
                    break;
                }
                précédent = (E) précédent.getSuivant ();
                tmp = (E) tmp.getSuivant ();

            }
        }
    }
    public String toString() {
        String str = new String ();
        Maillon temp = first;
        while (temp!=null)
        {
            str = str + temp.getCoor ().getX () + " " + temp.getCoor ().getY () + "\n";
            temp=temp.getSuivant ();
        }
        return str;
    }
}
