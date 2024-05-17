public class Consultation {
   
   private Dates date;
   private String symptomes;
   
   public Consultation(Dates date, String symptomes){
        this.symptomes = symptomes;
        this.date = date;
   } 
   @Override
   public String toString() {
       return  this.date.getJours() + "/" + this.date.getMois() + "/" + this.date.getAnnee() + " - " +
               this.symptomes;
   }
}
