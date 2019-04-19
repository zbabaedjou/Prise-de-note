package projet;
//package
public class Rechercher implements Command {
	
	 Fonctionnalite fonction;
	  public Rechercher(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    this.fonction.Rechercher(mot); ;
	  }



}
