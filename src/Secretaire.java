import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Secretaire extends Personne{
    private  int matricule ;
    private Rendezvous_s rendez_vous;
    public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public Secretaire(int matricule, String nom, String prenom) {
        super(nom, prenom);
        this.matricule = matricule;
        rendez_vous = new Rendezvous_s();
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nom: " + this.getNom() +  " Prenom: " + this.getPrenom();
    }
    public void fixer_rendezVous(Rendez_vous rdv){
        boolean b = false;
        int i = 0;
        while (i < rendez_vous.getRendez_vous().size() && b == false) {
            int n = rendez_vous.getRendez_vous().get(i).compareTo(rdv);
            if (n == 0) b = true;   
            i++; 
        }
        if (b == false) {
        	rendez_vous.getRendez_vous().add(rdv);
        	JOptionPane.showMessageDialog(new JFrame(),
        			rdv.toString() + " Fixé !!");
            System.out.println(rdv.toString() + " Fixé !!");
        }
        else {
        	rendez_vous.getRendez_vous().add(rdv);
    	JOptionPane.showMessageDialog(new JFrame(),
    			 rdv.toString() + " Rendez-vous deja pris !!");
        System.out.println( rdv.toString() + " Rendez-vous deja pris !!");}
           
    }
    public void lister_rendez_vous(){
        int i = 0;
        System.out.println("Rendez-vous occuppé !");
        while(i < this.rendez_vous.getRendez_vous().size() ){
            System.out.println(this.rendez_vous.getRendez_vous().get(i).toString());
            i++;
        }
    }
}
