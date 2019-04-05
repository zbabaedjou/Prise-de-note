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
	
	/**
	 * Liste le nom de toutes les notes qui appartiennent a ce groupe spécifique
	 * @return String list: liste des nom.
	 */
	@Override
	public String listerNotes() {
		String list="";
		for(Note i : list_note)
			list=list+ i.getNom()+" Context: "+i.getContext()+" Projet: "+i.getProjet()+" Date: "+i.getDate()+"\n";
		
		return list;
	}
	
	
	/**
	 * Supprime une note du Groupe
	 * @param Note : note  la note a supprimer
	 * 
	 * @return  true si la note a été trouvé et supprimé, false sinon
	 */
	@Override
	public boolean supprimerNote(Note note) {/////// a ajouter sur la version des autres
		
		if(list_note.contains(note)) {
			list_note.remove(note);
			return true;
		}
		else
			return false;		
	}
	
	
	/**
	 * Ajoute une note dans la liste
	 * @param Note : note  la note à ajouter
	 */
	@Override
	public void ajouterNote(Note note) {
		
		int toto;
		list_note.add(note);
		
	}
	
	
}
