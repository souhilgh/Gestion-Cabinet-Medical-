public abstract class Personne {
    
    private String nom;
    private String prenom;
    
    
    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom=prenom;
    }   

    //getters
    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

   

    // Setters
    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    

}
