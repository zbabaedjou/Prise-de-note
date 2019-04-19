package testProjet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projet.Note;

public class NoteTest {
	Note note;		
	@Before
	public void setUp() throws Exception {
		note= new Note
				.Builder("note1")
				.build();
	}

	@Test
	public void testSimpleBuilder() {
		assertEquals(note.getNom(),"note1");
		assertEquals(note.getContext(),"DefaultContext");
		assertEquals(note.getProjet(),"DefaultProject");
	}

	@Test
	public void testBuilderSetContext() {
		
		note= new Note
				.Builder("note1")
				.addContext("Context1")
				.build();
		
		assertEquals(note.getNom(),"note1");
		assertEquals(note.getContext(),"Context1");
		assertEquals(note.getProjet(),"DefaultProject");
	}
	
	@Test
	public void testBuilderSetProject() {
		
		note= new Note
				.Builder("note1")
				.addProjet("Projet 1")
				.build();
		
		assertEquals(note.getNom(),"note1");
		assertEquals(note.getContext(),"DefaultContext");
		assertEquals(note.getProjet(),"Projet 1");
	}

}
