import java.util.ArrayList; 

public class Dossier_medical {
    private ArrayList<Consultation>  consultations;
    private ArrayList<Ordonnance>   ordonnances;
    private ArrayList<Certificat_Medical>  certificats;
  
    public Dossier_medical(){
        consultations = new ArrayList<Consultation>();
        ordonnances = new ArrayList<Ordonnance>();
    } 
    
    public ArrayList<Consultation> getConsultations(){
        return this.consultations;
    }
    public ArrayList<Ordonnance> getOrdonnances(){
        return this.ordonnances;
    }
    public ArrayList<Certificat_Medical> getCertificats(){
        return this.certificats;
    }
}
