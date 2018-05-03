package Classes;


import java.util.Iterator;

public class Comportement {

    int  taille_generationFisrt = 0;
    int  taille_generationSuivant = 0;
    int  taille_queue = 0;

    //on declare deux generations

    Liste generationX = new Liste();
    Liste generationY = new Liste();

    int periode;

    Liste l;

    Liste genX = l;

    Liste genY = l;
    // univers doit etre creer a l'avance
    private Liste a;



    public int calculePeriode(Liste a){

        Liste<Maillon> liste = new Liste();



        int periode =1;
        Iterator<Maillon> it = null Methodes.evolution();
        //ici on doit creer univers pour pouvoir iterer passer de generation a une autre
        //pour pouvoir mettre ici it.hasNext
        while (it.suivant()){
            Maillon celluleI = Maillon.it.suivant();
            liste.add(Coordonner.x,Coordonner.y);

        }
        // it.next
        it.hasNext();//it.NextGeneration();
 
        while(generationX!=generationY) {
            it.hasNext();
            periode++;
        }


    return periode;
    }

    public int taille8queue(){

        int taille_queue=0;

        while (periode > 1){
            genX= genX.generationX;
            genY= genY.generationY;


            taille_queue ++ ;
        }
        return taille_queue;
    }


    //sarreter car les deux generations sont egales
    //
        public boolean Siidentique(Liste<Maillon>) {
        boolean identique;
        int GoX = Liste.suivant().getCoorX;
        int GoY = Liste.suivant().getCoorY;
        identique = true;

        while (suivant() && identique) {
            Methodes.evolution();
        }
        return identique;

}

}
