import java.util.ArrayList;
import java.time.LocalDate;
public class LocEnCours {
    ArrayList<Location> ListeLocation ;
    

    public LocEnCours (){
        ListeLocation=new ArrayList<Location>(); 
    }
    public void ajout_LO(vehicule v, Client c,LocalDate Datedeb,LocalDate Datefin ,int prix, int montant){
        Location L1 = new Location(v, c, Datedeb, Datefin, prix, montant);
        ListeLocation.add(L1);
    }

    public void Affichage_LO(){
    for(int i =0;(i<ListeLocation.size());i++){
        ListeLocation.get(i).Affichage_L();
    }
    
}
// recherche avec CIN
public int rech_LO_cin (int CIN){
    int i =0;
    int indice=-1;
    for( i =0;(i<ListeLocation.size());i++){
        if (ListeLocation.get(i).getC().CIN ==CIN) {
            indice=i;
        }
    }

    return indice;
}
// recherche avec MAT
public int rech_LO_mat (int matricule){
    int i =0;
    int indice=-1;
    for( i =0;(i<ListeLocation.size());i++){
        if (ListeLocation.get(i).getV().numMAT ==matricule) {
            indice=i;
        }
    }

    return indice;
}

public void supp_LO(int numMAT){
    
    ListeLocation.remove(ListeLocation.get(rech_LO_mat(numMAT)));
    
}

}
