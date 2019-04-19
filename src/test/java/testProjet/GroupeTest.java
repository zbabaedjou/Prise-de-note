package testProjet;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import projet.Groupe;
import projet.Note;

public class GroupeTest {
	Groupe groupe;
	Note note1,note2,note3,note4;
	DateFormat dateFormat;
	Date date;
	@Before
	public void setUp() throws Exception {
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

		
		groupe=new Groupe("Groupe1",1);
		note1= new Note
				.Builder("note1")
				.date(date)
				.build();
		note2= new Note
				.Builder("note2")
				.date(date)
				.build();
		note3= new Note
				.Builder("note3")
				.date(date)
				.build();
		note4= new Note
				.Builder("note4")
				.date(date)
				.build();
		
		groupe.ajouterNote(note1);
		groupe.ajouterNote(note2);
		groupe.ajouterNote(note3);
		
		
	}

	@Test
	public void testListerNotes() {
		
		String list="     "+groupe.getNom()+"\n"+
		"          "+ note1.getNom()+" Context: "+note1.getContext()+" Projet: "+note1.getProjet()+" Date: "+note1.getDate()+"\n"+
		"          "+ note2.getNom()+" Context: "+note2.getContext()+" Projet: "+note2.getProjet()+" Date: "+note2.getDate()+"\n"+
		"          "+ note3.getNom()+" Context: "+note3.getContext()+" Projet: "+note3.getProjet()+" Date: "+note3.getDate()+"\n";
		
		assertEquals(groupe.listerNotes(),list);
		//System.out.println(list);
	}

	@Test
	public void testSupprimerNote() {
		groupe.supprimerNote(note2);

		String list="     "+groupe.getNom()+"\n"+
		"          "+ note1.getNom()+" Context: "+note1.getContext()+" Projet: "+note1.getProjet()+" Date: "+note1.getDate()+"\n"+
		"          "+ note3.getNom()+" Context: "+note3.getContext()+" Projet: "+note3.getProjet()+" Date: "+note3.getDate()+"\n";
		
		assertEquals(groupe.listerNotes(),list);
		
	}

	@Test
	public void testAjouterNote() {
		groupe.ajouterNote(note4);

		String list="     "+groupe.getNom()+"\n"+
		"          "+ note1.getNom()+" Context: "+note1.getContext()+" Projet: "+note1.getProjet()+" Date: "+note1.getDate()+"\n"+
		"          "+ note2.getNom()+" Context: "+note2.getContext()+" Projet: "+note2.getProjet()+" Date: "+note2.getDate()+"\n"+
		"          "+ note3.getNom()+" Context: "+note3.getContext()+" Projet: "+note3.getProjet()+" Date: "+note3.getDate()+"\n"+
		"          "+ note4.getNom()+" Context: "+note4.getContext()+" Projet: "+note4.getProjet()+" Date: "+note4.getDate()+"\n";
		
		assertEquals(groupe.listerNotes(),list);
	}

	

}
