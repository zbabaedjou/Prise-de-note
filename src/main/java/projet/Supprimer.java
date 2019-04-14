package projet;

public class Supprimer implements Command{

	Fonctionnalite fonction;
	  public Supprimer(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    this.fonction.delete(mot); ;
	  }

}
