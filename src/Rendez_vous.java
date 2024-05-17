import java.util.Date;

public class Rendez_vous {
    Dates date ;
    int heure;
    int minute;
    Patient patient;
    Medecin medecin;
    public Rendez_vous(Dates date, int heure, int minute, Patient patient, Medecin medecin ){
        this.date = date;
        this.heure= heure;
        this.minute = minute;
        this.patient = patient;
        this.medecin= medecin;
    }
    public Rendez_vous(Dates date, int heure, int minute,  Medecin medecin) {
        this.date = date;
        this.heure= heure;
        this.minute = minute;
        this.medecin= medecin;
        }
	public int compareTo(Rendez_vous other) {
        if(this.date.getAnnee() == other.date.getAnnee() && 
        this.date.getMois() == other.date.getMois() &&
        this.date.getJours() == other.date.getJours()&&
        this.heure == other.heure && this.minute == other.minute && this.medecin.getMatricule() == other.medecin.getMatricule()){
            return 0;
        }
        else return 1;
    }

	   @Override
	    public String toString() {
	        return this.date.getJours() + "/" + this.date.getMois() + "/" + this.date.getAnnee() + " - "
	                +  this.heure + "H" + this.minute + " Pour Patient - " + this.patient.toString();
	    }  
	   public String toString2() {
	        return this.date.getJours() + "/" + this.date.getMois() + "/" + this.date.getAnnee() + " - "
	                +  this.heure + "H" + this.minute ;
	    }
}
