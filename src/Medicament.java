import java.util.ArrayList;

public class Medicament {
    private double dose;
    private String nom;
    private double nb_jours;

    public Medicament(String nom,double dose,double nb_jours) {
        this.dose = dose;
        this.nom = nom;
        this.nb_jours = nb_jours;
    }

    //getters

    public double getDose(){
        return this.dose;
    }

    
    public String getnom(){
        return this.nom;
    }

    
    public double getNb_jours(){
        return this.nb_jours;
    }

    //setters

    public void setDose(double dose){
        this.dose = dose;
    }

    
    public void setNom(String nom){
        this.nom = nom;
    }

    
    public void setNb_jours(double nb_jours){
        this.nb_jours = nb_jours;
    }

}
