import java.util.ArrayList; 

public class Ordonnance {
    private Patient patient ;
    private Dates date;
    private static int code  = 0;
    ArrayList<Medicament> medicaments ; //= new ArrayList<Medicament>(); 
    
    public Ordonnance(Patient pat,Dates date){
        this.patient = pat;
        this.medicaments = new ArrayList<Medicament>();
        this.date = date;
        this.code ++;
    }
    
    public void add_medicament(String nom, double dose, double nb_jours){
        this.medicaments.add(new Medicament(nom, dose, nb_jours));
    }

    ArrayList<Medicament> getMedicaments(){
        return this.medicaments;
    }
    @Override
    public String toString() {
        return this.patient.toString() + " - " + this.date.getJours() + "/" + this.date.getMois() + "/" + this.date.getAnnee() + " - ";
    }
}
