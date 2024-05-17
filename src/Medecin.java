import java.util.ArrayList;

public class Medecin extends Personne{
    private String adresse;
    private String specialite ;
    private int matricule;

    public Medecin(String nom, String prenom, String adresse, String specialite, int matricule) {
        super(nom, prenom);
        this.adresse = adresse;
        this.specialite = specialite;
        this.matricule = matricule;

        //TODO Auto-generated constructor stub
    }
   
    public int getMatricule() {
		return this.matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getAdresse(){
        return this.adresse;
    }
    
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nom: " + this.getNom() +  " Prenom: " + this.getPrenom() +
          ", Adresse: " + this.getAdresse() + " Sepcialité : " + this.getSpecialite() + " Matricule : " + this.getMatricule();
    }
    public void faire_consultation( Patient patient, Consultation consultation){
        patient.getDossier().getConsultations().add(consultation);
    }
    public void remplir_ordonance(Patient patient, Dates date, ArrayList<Medicament> meds){
        patient.getDossier().getOrdonnances().add(new Ordonnance(patient, date));
        patient.getDossier().getOrdonnances().get(patient.getDossier().getOrdonnances().size()-1).medicaments= meds;

    }
    public void remplir_certificat(Patient patient,Certificat_Medical c ){
        patient.getDossier().getCertificats().add(c);
    }
}
