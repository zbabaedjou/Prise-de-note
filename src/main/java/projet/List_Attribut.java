package projet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fatou Ndeye
 * @author Maryem 
 * @author Ziadath BABAEDJOU
 * 
 * Cette classe est l'élément composé du composite.
 * Elle permet de créer des groupes d'attribut qui sont: 
 * Soit un Context: type=1
 * Soit un Projet: type=2
 * Soit une Date: type=3
 * 
 */

public class List_Attribut extends Attribut{
	private List<Note>list_all=new ArrayList<Note>();
	private List<Groupe>projets=new ArrayList<Groupe>();
	private List<Groupe>contextes=new ArrayList<Groupe>();
	private List<Groupe>dates=new ArrayList<Groupe>();


	public List_Attribut(String nom, int type) {
		super(nom, type);
		// TODO Auto-generated constructor stub
	}

	
	/**listerNotes
	 * @param
	 * @return
	 */
	@Override
	public String listerNotes() {
		String listeNote="";
		for(Note n: list_all) {
			listeNote= listeNote + n.getNom()+n.getContext()+n.getProjet()+n.getDate();
			
		}
		return listeNote;
		
	}
	
	
	/**supprimerNote
	 * @param
	 * @return
	 */
	@Override
	public void supprimerNote(Note note) {
		// TODO Auto-generated method stub
		
	}

	/**ajouterNote
	 * @param
	 * @return
	 */
	@Override
	public void ajouterNote(Note note) {
		// TODO Auto-generated method stub
		
	}
	
	
	 /**getters
	  * 
	  * @return array of note or note
	  */
	public List<Note> getList_all() {
		return list_all;
	}

	public List<Groupe> getProjets() {
		return projets;
	}

	

	public List<Groupe> getContextes() {
		return contextes;
	}

	

	public List<Groupe> getDates() {
		return dates;
	}


}
