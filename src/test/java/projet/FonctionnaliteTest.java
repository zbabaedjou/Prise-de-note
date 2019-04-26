package projet;

import org.junit.Before;
import org.junit.Test;

public class FonctionnaliteTest {

	Fonctionnalite fonc;
	@Before
	public void setUp() throws Exception {
		fonc=new Fonctionnalite();
	}

	/*@Test
	public void testEditer() {
			try {
				fonc.editer("tzrtioi");
				fonc.editer("tzrtioi");
				fonc.editer("jjyggrdf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}*/
	@Test
	public void testls() {
			fonc.lister();
	}

}
