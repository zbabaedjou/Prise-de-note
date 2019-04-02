package projet;
/**
 * @author Fatou Ndeye
 * @author Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public abstract class Attribut {

	private String nom;
	private int type;
	
	public Attribut(String nom,int type) {
		this.type=type;
		this.nom=nom;
	}
	protected abstract void listerNotes();
	protected abstract void supprimerNote(Note  note);
	protected abstract void ajouterNote(Note note);
	
	public int getType() {
		return type;
	}
	public String getNom() {
		return nom;
	}
}
