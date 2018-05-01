package Projet;

    import java.io.IOException;

    public class JeuDeLaVie
    {
        public static void main(String[] args)
        {

            if (args.length!=0)
            {
                switch (args[0])
                {
                    case "test":
                        Liste<Maillon> testListe = new Liste<> ();
                        try{
                            Methode.lireFichier("C:\\Users\\Sony\\IdeaProjects\\src\\com\\france\\JeuDeLaVie\\data.lif");
                        }
                        catch (IOException e )
                        {
                            System.out.println ("Problems with file");
                        }
                        Methode.affichage (Data.stockage);
                        Methode.mondeAvecFrontieres ();
                        Methode.affichage (Data.stockage);

                   /* testListe.add (new Maillon (new Coordonner (10,10),null));
                    testListe.add (new Maillon (new Coordonner (3,8),null));
                    testListe.add (new Maillon (new Coordonner (5,5),null));
                    testListe.add (new Maillon (new Coordonner (3,3),null));
                    testListe.add (new Maillon (new Coordonner (4,4),null));
                    testListe.add (new Maillon (new Coordonner (4,5),null));
                    testListe.add (new Maillon (new Coordonner (4,6),null));
                    System.out.println (testListe.toString ());
                    System.out.println ();
                    Data.stockage = testListe;
                    Methodes.affichage (Data.stockage);
                    Methodes.evolution ();
                    Methodes.affichage (Data.stockage);
                    Methodes.evolution ();
                    Methodes.affichage (Data.stockage);*/
                        break;
                    case "-name":
                        afficherNoms();
                        break;
                    case "-h":
                        help();
                        break;
                    case "-d":
                        execution(Integer.parseInt (args[1]),args[2]);
                        break;
                    case "-c":
                        calculerType(Integer.parseInt (args[1]),args[2],true);
                        break;
                    case "-w" :
                        calculerType(Integer.parseInt (args[1]),args[2]);
                        break;
                    default:
                        System.out.println ("Commande incorrecte. Saisissez -h pour plus d'infotmation");
                        break;
                }
            }
            else
            {
                System.out.println ("L'execution sans paramètres");
            }

        }



        private static void calculerType(int max, String chemin)
        {

        }
        private static void execution(int d, String image)
        {

        }
        private static void calculerType(int max, String image,boolean b)
        {

        }

        private static void help()
        {
            System.out.println ( "\'java -jar JeuDeLaVie.jar -name\'               affiche vos noms et prénoms\n" +
                    "\'java -jar JeuDeLaVie.jar -h\'                  rappelle la liste des options du programme\n" +
                    "\'java -jar JeuDeLaVie.jar -s d fichier.lif\'    exécute une simulation du jeu d’une durée d\'affichant les configurations du jeu avec le numéro de génération\n" +
                    "\'java -jar JeuDeLaVie.jar -c max fichier.lif\'  calcule le type d’évolution du jeu avec ses caractéristiques (taille de la queue, période et déplacement), max représente la durée maximale de simulation pour déduire les résultats du calcul\n" +
                    "\'java -jar JeuDeLaVie.jar -w max dossier\'      calcule le type d’évolution de tous les jeux contenus dans le dossier passé en paramètre et affiche les résultats sous la forme d’un fichier html");
        }
        private static void afficherNoms()
        {
            System.out.println ( Data.NOM_1 + "; " + Data.NOM_2 + "; " + Data.NOM_3 +"; " + Data.NOM_4);
        }
    }
}
