package projet;

public class Inconnu implements Command{
	
	Fonctionnalite fonction;
	  public Inconnu(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    this.fonction.inconnu(mot);
	  }

	

}
