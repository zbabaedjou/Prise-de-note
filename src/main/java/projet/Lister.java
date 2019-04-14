package projet;

public class Lister implements Command{
	Fonctionnalite fonction;
	  public Lister(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    this.fonction.lister();
	  }


}
