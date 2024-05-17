import java.util.ArrayList;

public class Rendezvous_s {
    private ArrayList<Rendez_vous>  rendez_vous;

	public ArrayList<Rendez_vous> getRendez_vous() {
		return rendez_vous;
	}

	public void setRendez_vous(ArrayList<Rendez_vous> rendez_vous) {
		this.rendez_vous = rendez_vous;
	}  
	public Rendezvous_s() {
		rendez_vous = new ArrayList<Rendez_vous> ();
	}

}
