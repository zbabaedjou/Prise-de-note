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
//https://dzone.com/articles/design-patterns-command
public class List_Attribut extends Attribut{
	private static List_Attribut uniqueInstance;
	private List<Note>list_all;
	private List<Groupe>projets;
	private List<Groupe>contextes;
	private List<Groupe>dates;


	private List_Attribut() {
		this.list_all=new ArrayList<Note>();
		this.projets=new ArrayList<Groupe>();
		this.contextes=new ArrayList<Groupe>();
		this.dates=new ArrayList<Groupe>();

	}

	public static List_Attribut getInstance()
	    {
	            if(uniqueInstance==null)
	            {
	                    uniqueInstance = new List_Attribut();
	            }
	            return uniqueInstance;
	}
	    
	/**listerNotes
	 * @param
	 * @return
	 */
	@Override
	public String listerNotes() {
		String listeNote="";
		for(Note n: this.list_all) {
			listeNote= listeNote+"          "+n.getNom()+" Contexte: "+n.getContext()+" Projet: "+n.getProjet()+" Date: "+n.getDate()+"\n";
		}
		return listeNote;
		
	}	
	
	/**supprimerNote
	 * @param Note à supprimer
	 * @return true si le fichier est trouvé et supprimé et false sinon
	 */
	@Override
	public boolean supprimerNote(Note note) {
		
		if(this.list_all.contains(note)) {
			
			for(Groupe n: this.contextes)
				if(n.getNom().equals(note.getContext())) {
					n.supprimerNote(note);
			}
			
			for(Groupe n: this.projets)
				if(n.getNom().equals(note.getProjet())) {
					n.supprimerNote(note);
			}
			
			//IL RESTE DATE
				
			this.list_all.remove(note);
			
			return true;			
		}
		
		else
			return false;
		
	}

	/**ajouterNote
	 * @param
	 * @return
	 */
	@Override
	public void ajouterNote(Note note) {
		int exist=0; 
		this.list_all.add(note);
		for(Groupe n : this.projets)
			if(n.getNom().equals(note.getProjet())) {
				n.ajouterNote(note);
				exist=1;
				break;
			}
		if(exist==0) {
			this.projets.add(new Groupe(note.getProjet(),2));		
		}
		
		exist=0; 
		for(Groupe n : this.contextes)
			if(n.getNom().equals(note.getContext())) {
				n.ajouterNote(note);
				exist=1;
				break;
			}
		if(exist==0) {
			this.contextes.add(new Groupe(note.getContext(),1));		
		}
		
		exist=0; 
		for(Groupe n : this.dates)
			if(n.getNom().equals(note.getDate())) {
				n.ajouterNote(note);
				exist=1;
				break;
			}
		if(exist==0) {
			this.dates.add(new Groupe(note.getDate(),3));		
		}
		
	}
	
	/**listerDansFichier
	 * 
	 * @return list String qui contient toutes les infos
	 */
	public String listerDansFichier() {
		
		String list, list_projet, list_context,list_date;
		list_projet="Par Projet:\n \n \n";
		for(Groupe n : this.projets)
			list_projet=list_projet+n.listerNotes()+"\n \n";
		
		list_context="Par Context:\n \n \n";
		for(Groupe n : this.contextes)
			list_context=list_context+n.listerNotes()+"\n \n";
		
		list_date="Par Date:\n \n \n";
		for(Groupe n : this.contextes)
			list_date=list_date+n.listerNotes()+"\n \n";
		
		list=list_projet+"\n \n \n \n"+list_context+"\n \n \n \n"+list_date;
		
		return list;
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
