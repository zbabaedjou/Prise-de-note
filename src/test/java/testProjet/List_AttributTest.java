package testProjet;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import projet.Groupe;
import projet.List_Attribut;
import projet.Note;

public class List_AttributTest {

	Groupe groupe;
	Note note1,note2,note3,note4,note5,note6,note7,note8;
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
		note5= new Note
				.Builder("note5")
				.date(date)
				.addProjet("projet2")
				.build();
		note6= new Note
				.Builder("note6")
				.date(date)
				.addProjet("projet2")
				.build();
		note7= new Note
				.Builder("note7")
				.date(date)
				.addProjet("projet2")
				.build();
		
		
		/*groupe.ajouterNote(note1);
		groupe.ajouterNote(note2);
		groupe.ajouterNote(note3);*/
		List_Attribut.getInstance().ajouterNote(note1);
		List_Attribut.getInstance().ajouterNote(note2);
		List_Attribut.getInstance().ajouterNote(note3);
		List_Attribut.getInstance().ajouterNote(note4);
		List_Attribut.getInstance().ajouterNote(note5);
		List_Attribut.getInstance().ajouterNote(note6);
		List_Attribut.getInstance().ajouterNote(note7);
		
		
	}
	/*@Test
	public void testListerNotes() {
		
		String list=""+
				"          "+ note1.getNom()+" Context: "+note1.getContext()+" Projet: "+note1.getProjet()+" Date: "+note1.getDate()+"\n"+
				"          "+ note2.getNom()+" Context: "+note2.getContext()+" Projet: "+note2.getProjet()+" Date: "+note2.getDate()+"\n"+
				"          "+ note3.getNom()+" Context: "+note3.getContext()+" Projet: "+note3.getProjet()+" Date: "+note3.getDate()+"\n"+
				"          "+ note4.getNom()+" Context: "+note4.getContext()+" Projet: "+note4.getProjet()+" Date: "+note4.getDate()+"\n"+
				"          "+ note5.getNom()+" Context: "+note5.getContext()+" Projet: "+note5.getProjet()+" Date: "+note5.getDate()+"\n"+
				"          "+ note6.getNom()+" Context: "+note6.getContext()+" Projet: "+note6.getProjet()+" Date: "+note6.getDate()+"\n"+
				"          "+ note7.getNom()+" Context: "+note7.getContext()+" Projet: "+note7.getProjet()+" Date: "+note7.getDate()+"\n";

				assertEquals(List_Attribut.getInstance().listerNotes(),list);
		//System.out.println(List_Attribut.getInstance().listerDansFichier());
		//System.out.println(List_Attribut.getInstance().listerNotes());
	}*/

	/*@Test
	public void getNom() {
		assertEquals(List_Attribut.getInstance().getNote("note2"),this.note2);
	}

	/*@Test
	public void testAjouterNote() {
		fail("Not yet implemented");
	}

	@Test
	public void testListerDansFichier() {
		fail("Not yet implemented");
	}
*/
}
