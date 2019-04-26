package projet;

import static org.asciidoctor.Asciidoctor.Factory.create;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import org.asciidoctor.Asciidoctor;

public class Main {

	 public static void main(String[] args)    {
		 
		  Invoker control = new Invoker();
		 Fonctionnalite fonction = new Fonctionnalite();
		    Command editer = new Editer(fonction);
		    Command supprimer = new Supprimer(fonction);
		    Command view = new View(fonction);
		    Command rechercher = new Rechercher(fonction);
		    Command lister = new Lister(fonction);
		    Command inconnu = new Lister(fonction);


		    //switch on
		    
		    if(args[0]=="editer"||args[0]=="e" ) {
		    	control.setCommand(editer);
		    	control.pressButton(args[1]);
		    }
		    if(args[0]=="list"||args[0]=="ls" ) {
		    	control.setCommand(lister);
		    	control.pressButton("");
		    
		    }
		    if(args[0]=="view"||args[0]=="v" ) {
		    	control.setCommand(view);
		    	control.pressButton(args[1]);
		    
		    }
		    
		    if(args[0]=="search"||args[0]=="s" ) {
		    	control.setCommand(rechercher);
		    	control.pressButton(args[1]);
		    
		    }
		    if(args[0]=="delete"||args[0]=="d" ) {
		    	control.setCommand(supprimer);
		    	control.pressButton(args[1]);
		    
		    }
		    else {
		    	control.setCommand(inconnu);
		    	control.pressButton("");
		    }
		  
		
				
				
		  }
}
