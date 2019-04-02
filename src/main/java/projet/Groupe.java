package projet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fatou Ndeye
 * @author Maryem 
 * @author Ziadath BABAEDJOU
 * 
 * Cette classe est l'élément unitaire du composite.
 * Elle permet de créer des gorupes d'attribut qui sont: 
 * Soit un Context: type=1
 * Soit un Projet: type=2
 * Soit une Date: type=3
 * 
 */
public class Groupe extends Attribut{
	
	
	private List<Note>list_note=new ArrayList<Note>();
	
	public Groupe(String nom, int type) {
		super(nom,type);
	}
	
	@Override
	protected void listerNotes() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void supprimerNote(Note note) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void ajouterNote(Note note) {
		// TODO Auto-generated method stub
		
	}
	
	
}
