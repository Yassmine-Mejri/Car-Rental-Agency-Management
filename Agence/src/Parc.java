import java.util.ArrayList;
public class Parc {
    ArrayList< vehicule> ListeVehicule ;

public Parc (){
    ListeVehicule=new ArrayList< vehicule>(); 
}

//ajout
public void ajout_P(int a ,String b ,String c ,int d){
    vehicule V1 = new vehicule(a,b,c,d);
    ListeVehicule.add(V1);
}

// recherche avec matricule 
public int rech_P (int matricule){
    int i =0;
    int indice=-1;

    for( i =0;(i<ListeVehicule.size());i++){
        if (ListeVehicule.get(i).numMAT ==matricule) {
            indice=i;
        }
    }

    return indice;
}
//modification etat 
public void modif_etat(int numMAT,int etat){

    ListeVehicule.get(rech_P(numMAT)).setEtat(etat);;
}

//supp
public void supp_P(int numMAT){

    ListeVehicule.remove(rech_P(numMAT));
    
}
//Affichage
public void Affichage_Parc(){
    for(int i =0;(i<ListeVehicule.size());i++){
        System.out.println("\n----- Vehicule Numero:"+(i+1)+" -----");
        ListeVehicule.get(i).Affichage_V();
    }
}

}
