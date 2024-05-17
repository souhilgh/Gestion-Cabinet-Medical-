public class Dates {
    private int annee;
    private int mois;
    private int jours;

    public Dates(int jours, int mois, int annee){
        this.annee = annee;
        this.mois = mois;
        this.jours = jours;
    }
    public int getAnnee(){
        return this.annee;
    }
    public int getMois(){
        return this.mois;
    }
    public int getJours(){
        return this.jours;
    }

    
    public void setAnnee(int annee){
        this.annee = annee;
    }
    public void setMois(int mois){
        this.mois = mois;
    }
    public void setJours(int jour){
        this.jours = jour;
    }
}
