package projet;
/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public class Rechercher implements Command {
	
	 Fonctionnalite fonction;
	  public Rechercher(Fonctionnalite fonction){
	    this.fonction = fonction;
	  }
	  public void execute(String mot){
	    this.fonction.Rechercher(mot); ;
	  }
	  
	  
}
