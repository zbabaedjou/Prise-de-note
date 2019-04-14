package projet;

public class View implements Command{
	
	Fonctionnalite fonction;
	  public View(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    this.fonction.apercu(mot);
	  }

	

}
