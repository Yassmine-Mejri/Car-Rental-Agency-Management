import java.util.Scanner; 
import java.time.LocalDate;

public class ProgramPrincipal {

    public static void main(String[] args){ 


        Scanner s = new Scanner(System.in);

        char op,op1,op2,op3,chc,chm,chn,chp,cha,chf,chd ; 
        String ch,ch1,ch2,ch3;
        int numMAT,etat,CIN,Prix,Montant ;
        String constr ,Marq,Nom,Prenom ,Adresse;
        LocalDate Datedeb;
        LocalDate Datefin;
        LocalDate dsdate;
        LocalDate prdate;
        boolean retard=false;
        boolean Etat=false;


        //String Datedeb , Datefin ;
        LocalDate d=LocalDate.now();

        Parc P = new Parc();
        LocEnCours LO=new LocEnCours();
        LocHistorique LOH = new LocHistorique();
        Location L;
        Client C;
        vehicule V;
        

        do{
            System.out.println("\n********* BIENVENUS DANS NOTRE AGENCE DE LOCATION DE VOITURES *********");
            System.out.println();
            System.out.println("\n**************** MENU PRINCIPALE ***************");
            System.out.println("\n1-Gestion du Parc de l Agence");
            System.out.println("2-Gestion Locations");
            System.out.println("3-Statistiques");
            System.err.println("\n************************************************");
            System.out.println("\nVotre choix sil vous plait :");
            ch=s.next();
            System.out.println("\n************************************************");
            op=ch.charAt(0);


            switch(op){

                case '1':
                    do{
                        System.out.println();
                        System.out.println("************** MENU GESTION DU PARC **************");
                        System.out.println("\n1.1-Nouvelle acquisition (Ajout d un vehicule)");
                        System.out.println("1.2-Modification de l Etat d un Vehicule");
                        System.out.println("1.3-Suppression d un Véhicule");
                        System.out.println("1.4-Consultation Parc (tous les vehicules)");
                        System.out.println("1.5-Liste des vehicules loues");
                        System.out.println("1.6-Liste des vehicules en cours de reparation");
                        System.out.println("1.7-Liste des vehicules disponibles");
                        System.out.println("\n************************************************");
                        System.out.println("\nVotre choix sil vous plait :");
                        ch1=s.next();
                        System.out.println("\n************************************************");
                        op1=ch1.charAt(0);

                        switch (op1) {

                                case '1':
                            do{
                            System.out.println("*|--Numero d'immatriculation : ");
                            numMAT=s.nextInt();
                            System.out.println("_________________________________________________________________");
                            }while (numMAT<001 || numMAT>999);
                        
                            System.out.println("*|--Constructeur : ");
                            constr=s.next();
                            System.out.println("_________________________________________________________________");
                            chc=constr.charAt(0);
                        
                            System.out.println("*|--Marque commerciale : ");
                            Marq=s.next();
                            System.out.println("_________________________________________________________________");
                            chm =Marq.charAt(0);
                            do{
                                System.out.println("*|--Etat courant: 1:Disponible, 2:Loue, 3:En Cours De Reparation ");
                                etat=s.nextInt();
                                System.out.println("_________________________________________________________________");
                            }while(etat>3 || etat==0);
                            P. ajout_P(numMAT,constr,Marq,etat); 
                            P.Affichage_Parc();


                                break;
                            
                                case '2':
                                do{
                                    System.out.println("*|--Numero d'immatriculation :");
                                    numMAT=s.nextInt();
                                    System.out.println("_________________________________________________________________");
                                }while((P.rech_P(numMAT)==-1)||(numMAT<001 || numMAT>999));

                            System.out.println("*|--1:Disponible");
                            System.out.println("*|--2:Louee");
                            System.out.println("*|--3:Cours de Reparation");
                            etat=s.nextInt();
                            System.out.println("_________________________________________________________________");
                            P.modif_etat(numMAT,etat);
                            P.Affichage_Parc();

                                break;   

                                case '3':
                                do{
                                    System.out.println("*|--Numero d'immatriculation :");
                                    numMAT=s.nextInt();
                                    System.out.println("_________________________________________________________________");
                                }while((P.rech_P(numMAT)==-1)||(numMAT<001 || numMAT>999));

                            P.supp_P(numMAT);
                            P.Affichage_Parc();

                                break;

                                case '4':
                            System.out.println("---------------------------- vehicules --------------------------");
                            P.Affichage_Parc();
                            
                                break;
                                case'5':
                            System.out.println("------------------------ vehicules loues ------------------------");
                            for(int i=0;i<P.ListeVehicule.size();i++){
                                if(P.ListeVehicule.get(i).etat==2){
                                    P.ListeVehicule.get(i).Affichage_V();
                                }
                            }

                                break;
                                case'6':
                            System.out.println("---------------- vehicules en cours de reparation ---------------");
                            for(int i=0;i<P.ListeVehicule.size();i++){
                                if(P.ListeVehicule.get(i).etat==3){
                                    P.ListeVehicule.get(i).Affichage_V();
                                }
                            }
                            
                                break;
                                case'7':
                            System.out.println("---------------------- vehicules disponible ---------------------");
                            for(int i=0;i<P.ListeVehicule.size();i++){
                                if(P.ListeVehicule.get(i).etat==1){
                                    P.ListeVehicule.get(i).Affichage_V();
                                }
                            }

                                break;
                            default:
                                break;
                                
                        }
                        
                    }while (op1!='*');
                break;
                
                
                case '2':
                do{
                    System.out.println();
                    System.out.println("\n******************************************************");
                    System.out.println("\n**************** MENU GESTION LOCATIONS **************");
                    System.out.println("2.1-Nouvelle Location (Ajout d une location)");
                    System.out.println("2.2-Fin de Location (Suppression)"); 
                    System.out.println("2.3-Consultation des locations en cours");
                    System.out.println("2.4-Consultation des Vehicules Loués par un client");
                    System.err.println("\n******************************************************");
                    System.out.println("\nVotre choix sil vous plait :");
                    ch2=s.next();
                    op2=ch2.charAt(0);


                    switch (op2) {
                        case '1':
                        
                                do{
                                System.out.println("*|--Numero d'immatriculation : ");
                                numMAT=s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while((P.rech_P(numMAT)==-1)||(numMAT<001 || numMAT>999));

                            V=P.ListeVehicule.get(P.rech_P(numMAT));

                                do{
                                System.out.println("*|--CIN : ");
                                CIN=s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while (CIN < 00000001 || CIN > 99999999);
                            
                                System.out.println("*|--Nom: ");
                                Nom=s.next();
                                System.out.println("_________________________________________________________________");
                                chn=Nom.charAt(0);
                            
                                System.out.println("*|--Prenom : ");
                                Prenom=s.next();
                                System.out.println("_________________________________________________________________");
                                chp=Prenom.charAt(0);
                            
                            
                                System.out.println("*|--Adresse : ");
                                Adresse=s.next();
                                System.out.println("_________________________________________________________________");
                                cha=Adresse.charAt(0);
                                
                            C=new Client(CIN, Nom, Prenom, Adresse);
                        
                                int jj,mm,aaaa,jjf,mmf,aaaaf;
                                System.out.println("donner date debut en forme jj/mm/aaaa");
                                do{
                                System.out.println("*|--donner jour jj : ");
                                jj= s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while( jj < 1 || jj > 31 );
                                do{
                                System.out.println("*|--donner mois mm : ");
                                mm=s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while(mm < 1 || mm > 12);
                                do{
                                System.out.println("*|--donner annee aaaa : ");
                                aaaa=s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while(aaaa < 1000 || aaaa > 2999);
                                Datedeb=LocalDate.of(aaaa,mm,jj);
                                
                                System.out.println("donner date fin en forme jj/mm/aaaa");
                                do{
                                System.out.println("*|--donner joue jj : ");
                                jjf= s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while( jjf < 1 || jjf > 31 );
                                do{
                                System.out.println("*|--donner mois mm : ");
                                mmf=s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while(mmf < 1 || mmf > 12);
                                do{
                                System.out.println("*|--donner annee aaaa : ");
                                aaaaf=s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while(aaaaf < 1000 || aaaaf > 2999);
                                Datefin=LocalDate.of(aaaaf,mmf,jjf);
            
                                System.out.println("*|--Prix : ");
                                Prix=s.nextInt();
                                System.out.println("_________________________________________________________________");
                                do{
                                System.out.println("\n--------Il faut donner une avance sur le prix de la location---------");
                                System.out.println("*|--Montant : ");
                                Montant=s.nextInt();
                                System.out.println("_________________________________________________________________");
                                }while (Montant ==0);
                            
                        L=new Location(V, C, Datedeb, Datefin, Prix, Montant);
                        
                                LO.ajout_LO(V, C, Datedeb, Datefin, Prix, Montant);
                                P.ListeVehicule.get(P.rech_P(V.numMAT)).setEtat(2);
                                LO.Affichage_LO();
                        
                        break;   

                        case '2':
                            System.out.println("----- Date aujourdhui "+d+" -----");
                            do{
                                System.out.println("*|--CIN : ");
                                CIN=s.nextInt();
                                System.out.println("_________________________________________________________________");
                            }while ((CIN < 00000001 || CIN > 99999999)||(LO.rech_LO_cin(CIN)==-1));
                            do{
                                System.out.println("*|--Numero d'immatriculation : ");
                                numMAT=s.nextInt();
                                System.out.println("_________________________________________________________________");
                            }while((LO.rech_LO_mat(numMAT)==-1)||(numMAT<001 || numMAT>999));              

                            LocalDate x=LO.ListeLocation.get(LO.rech_LO_mat(numMAT)).getDatefin();
                                if (d.compareTo(x)>0){
                                    System.out.println("----- Reclamation -----");
                                    retard=true;
                                    Etat=true;
                                }else {
                                    System.out.println("----- Client Fidele -----");
                                    retard=false;
                                    Etat=false;
                                }

                                LOH.ajout_LOH(LO.ListeLocation.get(LO.rech_LO_mat(numMAT)).getV(), LO.ListeLocation.get(LO.rech_LO_cin(CIN)).getC(), LO.ListeLocation.get(LO.rech_LO_mat(numMAT)).getDatedeb(), LO.ListeLocation.get(LO.rech_LO_mat(numMAT)).getDatefin(), LO.ListeLocation.get(LO.rech_LO_mat(numMAT)).getPrix(), LO.ListeLocation.get(LO.rech_LO_mat(numMAT)).getMontant(),retard,Etat);
                                LO.supp_LO(numMAT);
                                P.ListeVehicule.get(P.rech_P(numMAT)).setEtat(1);
                                LO.Affichage_LO();
                                LOH.Affichage_LOH();                            
                                
                        break;
                        case '3':
                            System.out.println("----- Date aujourdhui "+d+" -----");
                            for(int i=0 ;(i<LO.ListeLocation.size());i++){

                                if( LO.ListeLocation.get(i).getDatefin().compareTo(d)>0) {
                                    LO.ListeLocation.get(i).Affichage_L();;
                                }
                            } 
                        break;
                        case '4':     
                    
                        LO.Affichage_LO();                     

                        default:
                            break;
                    }
                }while (op2!='*');
                break;


                case '3':
                do{
                    System.out.println();
                    System.out.println("\n******************************************************************************");
                    System.out.println("********************************* MENU STATISTIQUES ****************************");
                    System.out.println("3.1-Nombre de locations pour une periode determinee");
                    System.out.println("3.2-Total des revenus pour une période déterminee");
                    System.out.println("3.3-Liste des clients à risque (Retard / mauvais etat de vehicules rendus)");
                    System.out.println("\n******************************************************************************");
        
                    System.out.println("\nVotre choix sil vous plait :");
                    ch3=s.next();
                    op3=ch3.charAt(0);

                    switch (op3) {
                        case '1':
                        int jjp,mmp,aaaap,jjd,mmd,aaaad;
                        System.out.println("donner la premier date  en forme jj/mm/aaaa");
                        do{
                            System.out.println("*|--donner jour jj : ");
                            jjp= s.nextInt();
                            System.out.println("_______________________________________________________________________");
                            }while( jjp < 1 || jjp > 31 );
                            do{
                                System.out.println("*|--donner mois mm : ");
                            mmp=s.nextInt();
                            System.out.println("_______________________________________________________________________");
                            }while(mmp < 1 || mmp > 12);
                            do{
                                System.out.println("*|--donner annee aaaa : ");
                            aaaap=s.nextInt();
                            System.out.println("_______________________________________________________________________");
                            }while(aaaap < 1000 || aaaap > 2999);
                        prdate=LocalDate.of(aaaap,mmp,jjp);
                        
                        System.out.println("donner la deuxieme en forme jj/mm/aaaa");
                        do{
                            System.out.println("*|--donner jour jj : ");
                            jjd= s.nextInt();
                            System.out.println("_______________________________________________________________________");
                        }while( jjd < 1 || jjd> 31 );
                        do{
                            System.out.println("*|--donner mois mm : ");
                            mmd=s.nextInt();
                            System.out.println("_______________________________________________________________________");
                        }while(mmd < 1 || mmd > 12);
                        do{
                            System.out.println("*|--donner annee aaaa : ");
                            aaaad=s.nextInt();
                            System.out.println("_______________________________________________________________________");
                        }while(aaaad < 1000 || aaaad > 2999);
                        dsdate=LocalDate.of(aaaad,mmd,jjd);

                        int nbr=0;
                        for(int i=0; (i<LO.ListeLocation.size()); i++){
                            if(prdate.compareTo(LO.ListeLocation.get(i).getDatedeb())<0 && dsdate.compareTo(LO.ListeLocation.get(i).getDatefin())>0 )
                            {
                                nbr++;
                            }
                        }
                        System.out.println("----- Nombre de Locations dans une periode: " +nbr+" -----");

                            break;

                            case '2':

                            System.out.println("donner la premier date  en forme jj/mm/aaaa");
                            do{
                                System.out.println("*|--donner joue jj : ");
                                jjp= s.nextInt();
                                System.out.println("_______________________________________________________________________");
                                }while( jjp < 1 || jjp > 31 );
                                do{
                                    System.out.println("*|--donner mois mm : ");
                                mmp=s.nextInt();
                                System.out.println("_______________________________________________________________________");
                                }while(mmp < 1 || mmp > 12);
                                do{
                                    System.out.println("*|--donner annee aaaa : ");
                                aaaap=s.nextInt();
                                System.out.println("_______________________________________________________________________");
                                }while(aaaap < 1000 || aaaap > 2999);
                            prdate=LocalDate.of(aaaap,mmp,jjp);
                            
                            System.out.println("donner la deuxieme en forme jj/mm/aaaa");
                            do{
                                System.out.println("*|--donner joue jj : ");
                                jjd= s.nextInt();
                                System.out.println("_______________________________________________________________________");
                            }while( jjd < 1 || jjd> 31 );
                            do{
                                System.out.println("*|--donner mois mm : ");
                                mmd=s.nextInt();
                                System.out.println("_______________________________________________________________________");
                            }while(mmd < 1 || mmd > 12);
                            do{
                                System.out.println("*|--donner annee aaaa : ");
                                aaaad=s.nextInt();
                                System.out.println("_______________________________________________________________________");
                            }while(aaaad < 1000 || aaaad > 2999);
                            dsdate=LocalDate.of(aaaad,mmd,jjd);
    
                            int somme=0;
                            for(int i=0; (i<LO.ListeLocation.size()); i++){
                                if(prdate.compareTo(LO.ListeLocation.get(i).getDatedeb())<0 && dsdate.compareTo(LO.ListeLocation.get(i).getDatefin())>0 )
                                {
                                    somme=somme+LO.ListeLocation.get(i).Prix;
                                }
                            } 
                            System.out.println("----- Total des couts dans une periode " +somme+" Dt -----");
                    
                            
                            case '3':
                            for(int i=0; (i<LOH.ListeLocHistorique.size());i++)
                            {
                                if(LOH.retard==false && LOH.Etat==false)
                                {
                                    LOH.ListeLocHistorique.get(i).getC().Affichage_C();
                                }
                            }
                            
                        default:
                            break;
                    }
                }while (op3!='*');
                break;

            default: System.out.println("----- ERREUR: operation invalide -----");

        }

            System.out.println("\n*********************** MERCI POUR VOTRE SERVICE **********************");

        }while(op!='&');    

        s.close();
    }

    

}
