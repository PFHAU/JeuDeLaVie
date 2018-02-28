public class evolution {


    // test si un index de tableau est valide
// on travaille avec des matrices 20x20
    boolean indexValide (int n)
    {
        return ((n>=0)&& (n<20));
    }
    // pour compter les voisins
// du point d'ndices (i,j) de la matrice A
    int compter_Voisins ( int i, int j)
    {
        int compteur = 0;
        int u, v;

        for (u=i-1; u<=i+1; u++)
            for (v=j-1; v<=j+1; v++)
                if (indexValide(u)&&indexValide(v)&& A[u][v]) compteur ++;
        if (A[i][j]) compteur --;
        return compteur;
    }

    // passage d'une étape à la suivante
    void etapeSuivant()
    {
        int i, j, n;
        boolean[][] A=Null;
        boolean[][] B=Null;
        for (i=0; i<20; i++)
            for (j=0; j<20; j++)
            {
                n= compter_Voisins(i,j);
                if ((!A[i][j]) && n==3) {
                    B[i][j]=1; // 3 voisins : naissance
                } else if (A[i][j] && n<2) {
                    B[i][j]=0; // moins de 2 voisins: mort
                } else if (A[i][j] && n>3) {
                    B[i][j] =0; // 4 et plus: mort
                } else if (A[i][j]) {
                    B[i][j] =1;
                } else {
                    B[i][j]=0; // ne doit pas se produire juste pour éviter le warning
                }
            }
        for (i=0; i<20; i++) // recopie de B dans A
            for (j=0; j<20; j++)
                A[i][j]=B[i][j];
    }

    // test de l'état stable
    int Stab()
    {
        int i, j, n;
        int r=1;
        boolean[][] A=Null;
        boolean[][] B=Null;
        for (i=0; i<20; i++)
            for (j=0; j<20; j++)
            {
                n= compter_Voisins(i,j);
                if ((!A[i][j]) && n==3) {
                    B[i][j] = 1;
                } else if (A[i][j] && n<2) {
                    B[i][j]=0;
                } else if (A[i][j] && n>3) {
                    B[i][j] =0;
                } else if (A[i][j]) {
                    B[i][j] =1;
                } else {
                    B[i][j]=0;
                }
            }

        for (i=0;i<20;i++)
            for (j=0;j<20;j++)
                if (A[i][j]!=B[i][j]) r=0;
        return r;
    }
    // Itération
    int Go()
    {
        int c = 0;
        while (1)
        {
            etapeSuivant();
            c++;
            if (Stab()) break;// soit on a un état stable
            if (c==1000) break; // soit on s'arrête après 1000 itérations
        }
        return c;
    }
}
