public class Client {
    int CIN ; 
    String Nom ; 
    String Prenom ; 
    String Adresse;

public Client(int cin, String nom, String prenom, String adresse) {
        CIN = cin;
        Nom = nom;
        Prenom = prenom;
        Adresse = adresse;
    }

public Client(){
    CIN=00000000;
    Nom="";
    Prenom="";
    Adresse="";
}



//Affichage client
public void Affichage_C (){

    System.out.println("\n*****************************************************************");
    System.out.println("_________________________________________________________________\n");
    System.out.println("*|--CIN :     "+CIN);
    System.out.println("*|--Nom:      "+Nom);
    System.out.println("*|--Prenom :  "+Prenom);
    System.out.println("*|--Adresse : "+Adresse);
    System.out.println("_________________________________________________________________");
    System.out.println("\n*****************************************************************");

}

public int getCIN() {
    return CIN;
}

public void setCIN(int cIN) {
    CIN = cIN;
}

public String getNom() {
    return Nom;
}

public void setNom(String nom) {
    Nom = nom;
}

public String getPrenom() {
    return Prenom;
}

public void setPrenom(String prenom) {
    Prenom = prenom;
}

public String getAdresse() {
    return Adresse;
}

public void setAdresse(String adresse) {
    Adresse = adresse;
}
}
