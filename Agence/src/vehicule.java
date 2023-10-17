public class vehicule {
    int numMAT ;
    String constr ;
    String Marq ;
    int etat;
   // String Etat [] = new String []{"1:Disponible","2:Loue","3:EnCoursDeReparation"}; 
public vehicule(){
    numMAT=000;
    constr="";
    Marq="";
    etat=0; 
}
public vehicule(int a ,String b ,String c ,int d ){
    numMAT=a;
    constr=b;
    Marq=c;
    etat=d; 
}
public int getNumMAT() {
    return numMAT;
}
public void setNumMAT(int numMAT) {
    this.numMAT = numMAT;
}
public String getConstr() {
    return constr;
}
public void setConstr(String constr) {
    this.constr = constr;
}
public String getMarq() {
    return Marq;
}
public void setMarq(String marq) {
    Marq = marq;
}
public int getEtat() {
    return etat;
}
public void setEtat(int etat) {
    this.etat = etat;
}
public void Affichage_V(){

    System.out.println("\n*****************************************************************");
    System.out.println("_________________________________________________________________\n");
    System.out.println("*|--Numero d'immatriculation: "+numMAT);
    System.out.println("*|--Constructeur:              "+constr);
    System.out.println("*|--Marque commerciale:        "+Marq);
    
    if(etat==1){
        System.out.println("*|--Etat: Disponible");
    }else if(etat==2){
        System.out.println("*|--Etat: Louee");
    }else if (etat==3){
        System.out.println("*|--Etat: En cours de Reparation");
    }   
    System.out.println("_________________________________________________________________");
    System.out.println("\n*****************************************************************");
}
}
