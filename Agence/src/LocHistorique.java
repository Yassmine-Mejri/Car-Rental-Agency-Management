import java.util.ArrayList;
import java.time.LocalDate;
public class LocHistorique {
    ArrayList <Location> ListeLocHistorique;
    boolean retard;
    boolean Etat;


    public LocHistorique() {
        ListeLocHistorique = new ArrayList<Location>();
    }


    public void ajout_LOH(vehicule v, Client c,LocalDate Datedeb,LocalDate Datefin ,int prix, int montant,boolean Retard, boolean etat){
        Location L1 = new Location(v, c, Datedeb, Datefin, prix, montant);
        ListeLocHistorique.add(L1);
        retard=Retard;
        Etat=etat;

    }

    public void Affichage_LOH(){
        for(int i =0;(i<ListeLocHistorique.size());i++){
            System.out.println("\n----- Vehicule Numero:"+(i+1)+" -----");
            ListeLocHistorique.get(i).Affichage_L();
            if(retard==false && Etat==false)
            {
                System.out.println("----- Sans Retard -----");
                System.out.println("----- Bon Etat -----");
            }
            else{
                System.out.println("----- Il ya un Retard -----");
                System.out.println("----- Mauvais Etat -----");
            }
            System.out.println("_________________________________________________________________");
            System.out.println("\n*****************************************************************");
        
        }
    }






    public ArrayList<Location> getListeLocHistorique() {
        return ListeLocHistorique;
    }


    public void setListeLocHistorique(ArrayList<Location> listeLocHistorique) {
        ListeLocHistorique = listeLocHistorique;
    }


    public boolean isRetard() {
        return retard;
    }


    public void setRetard(boolean retard) {
        this.retard = retard;
    }


    public boolean isEtat() {
        return Etat;
    }


    public void setEtat(boolean etat) {
        this.Etat = etat;
    }

    
}
