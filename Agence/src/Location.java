import java.time.LocalDate;
public class Location {
    vehicule V ;
    Client C ;
    LocalDate Datedeb;
    LocalDate Datefin; 
    int Prix;
    int Montant;
    
public Location(vehicule v, Client c, LocalDate datedeb,LocalDate datefin ,int prix, int montant) {
        V = v;
        C = c;
        Datedeb = datedeb;
        Datefin = datefin;
        Prix = prix;
        Montant = montant;
    }


//Affichage location

public void Affichage_L (){


    V.Affichage_V();
    C.Affichage_C();
    System.out.println("\n*****************************************************************");
    System.out.println("_________________________________________________________________\n");
    System.out.println("*|--Date Debut : "+Datedeb);
    System.out.println("*|--Date Fin :   "+Datefin);
    System.out.println("*|--Prix :       "+Prix+"Dt");
    System.out.println("*|--Montant :    "+Montant+"Dt");
    System.out.println("_________________________________________________________________");
    System.out.println("\n*****************************************************************");

}

public vehicule getV() {
    return V;
}

public void setV(vehicule v) {
    V = v;
}

public Client getC() {
    return C;
}

public void setC(Client c) {
    C = c;
}

public LocalDate getDatedeb() {
    return Datedeb;
}

public void setDatedeb(LocalDate datedeb) {
    Datedeb = datedeb;
}

public LocalDate getDatefin() {
    return Datefin;
}

public void setDatefin(LocalDate datefin) {
    Datefin = datefin;
}

public int getPrix() {
    return Prix;
}

public void setPrix(int prix) {
    Prix = prix;
}

public int getMontant() {
    return Montant;
}

public void setMontant(int montant) {
    Montant = montant;
}

}




