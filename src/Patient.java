import java.util.ArrayList;

public class Patient extends Personne{
    private static int matricule =0;
    private int age;
    private char sexe;
    private int telephone ;
    private String adresse;
    private Dossier_medical dossier;
    public Patient(String nom, String prenom, String adresse, int age, char sexe, int telephone) {
        super(nom, prenom);
        this.adresse = adresse;
        this.matricule ++;
        this.age = age;
        this.sexe = sexe;
        this.telephone = telephone;
        this.dossier = new Dossier_medical();
        //TODO Auto-generated constructor stub
    }
    
    //getters

    public Dossier_medical getDossier(){
        return this.dossier;
    }

    public String getAdresse(){
        return this.adresse;
    }
    public int getMatricule(){
        return this.matricule;
    }
    public int getAge(){
        return this.age;
    }
    
    public char getSexe(){
        return this.sexe;
    }
    public int getTelephone(){
        return this.telephone;
    }
    //setters

    public void setTelephone(int telephone){
        this.telephone = telephone;
    }

    public void setAge(int age){
        this.age = age;
    }
    
    public void setSexe(char sexe){
        this.sexe = sexe;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Nom : " + this.getNom() + " Prenom : " + this.getPrenom();
    }

    public void lister_Consultation(){
        int i = 0;
        System.out.println("Consultations !");
        while(i < this.dossier.getConsultations().size() ){
            System.out.println(this.dossier.getConsultations().get(i).toString());
            i++;
        }
    }

    public void lister_ordonnance(){
        int i = 0;
        System.out.println("Ordonnance !");
        while(i < this.dossier.getOrdonnances().size() ){
            System.out.println(this.dossier.getOrdonnances().get(i).toString());
            i++;
        }
    }
}
