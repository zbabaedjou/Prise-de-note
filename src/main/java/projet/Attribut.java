package projet;
/**
 * @author Fatou Ndeye
 * @author Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public abstract class Attribut {

	protected String nom;
	protected int type;
	
	public Attribut(String nom,int type) {
		this.type=type;
		this.nom=nom;
	}
	public abstract String listerNotes();
	public abstract boolean supprimerNote(Note  note);
	public abstract void ajouterNote(Note note);
	
	public int getType() {
		return type;
	}
	public String getNom() {
		return nom;
	}
}
