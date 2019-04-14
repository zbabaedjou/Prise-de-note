package projet;

import java.io.IOException;

public class Editer implements Command {

	Fonctionnalite fonction;
	  public Editer(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    try {
			this.fonction.editer(mot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
