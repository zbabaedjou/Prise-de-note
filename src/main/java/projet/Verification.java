package projet;

import java.util.Scanner;

public class Verification {
	private Invoker control;
	private Fonctionnalite fonction;
	private Command editer;
	private Command supprimer;
	private Command view;
	private Command rechercher;
	private Command lister;
	private Command inconnu;
	private Scanner sc;
	
	public Verification() {
		this.control = new Invoker();
		this.fonction = new Fonctionnalite();
		this.editer = new Editer(fonction);
		this.supprimer = new Supprimer(fonction);
		this.view = new View(fonction);
		this.rechercher = new Rechercher(fonction);
		this.lister = new Lister(fonction);
		this.inconnu = new Inconnu(fonction);
		sc = new Scanner(System.in);
	}
	
	public void process(String [] arg) {
		
		String [] args = {"",""} ;
		if(arg.length==0) {
			String str="";
		  do {			  
			  System.out.print(">");
			   str = sc.nextLine();
		  }while(str.equals(""));
		  String[] arrOfStr = str.split(" ", 2);  
		  if(arrOfStr.length==1) 
			  args[0]=str;		  
		  else if(arrOfStr.length>1) {
			  
			  System.out.println(arrOfStr[0]);
			  System.out.println(arrOfStr[1]);

			  args[0]=arrOfStr[0]; 
			  args[1]=arrOfStr[1];
		  }
			  
		}
		else
			args=arg;
		
		 if(args[0].equalsIgnoreCase("edit")||args[0].equalsIgnoreCase("e") ) {
		    	control.setCommand(editer);
		    	if(!args[1].equalsIgnoreCase(""))
		    		control.pressButton(args[1]);
		    	else {
		    		String str="";
		  		  do {			  
		  			  System.out.print(">");
		  			   str = sc.nextLine();
		  		  }while(str.equals(""));
		  		  control.pressButton(str);
		    	}
		    	
		    		
		    }
		 else if(args[0].equalsIgnoreCase("list")||args[0].equalsIgnoreCase("ls") ) {
		    	control.setCommand(lister);
		    	control.pressButton("");
		    
		    }
		 else if(args[0].equalsIgnoreCase("view")||args[0].equalsIgnoreCase("v") ) {
		    	control.setCommand(view);
		    	if(!args[1].equalsIgnoreCase(""))
		    		control.pressButton(args[1]);
		    	else {
		    		String str="";
		  		  do {			  
		  			  System.out.print(">");
		  			   str = sc.nextLine();
		  		  }while(str.equals(""));
		  		  control.pressButton(str);
		    	}
		    	
		    
		    }
		    
		 else if(args[0].equalsIgnoreCase("search")||args[0].equalsIgnoreCase("s") ) {
		    	control.setCommand(rechercher);
		    	if(!args[1].equalsIgnoreCase(""))
		    		control.pressButton(args[1]);
		    	else {
		    		String str="";
		  		  do {			  
		  			  System.out.print(">");
		  			   str = sc.nextLine();
		  		  }while(str.equals(""));
		  		  control.pressButton(str);
		    	}
		    }
		 else if(args[0].equalsIgnoreCase("delete")||args[0].equalsIgnoreCase("d") ) {
		    	control.setCommand(supprimer);
		    	if(!args[1].equalsIgnoreCase(""))
		    		control.pressButton(args[1]);
		    	else {
		    		String str="";
		  		  do {			  
		  			  System.out.print(">");
		  			   str = sc.nextLine();
		  		  }while(str.equals(""));
		  		  control.pressButton(str);
		    	}
		    
		    }
		    else {
		    	control.setCommand(inconnu);
		    	control.pressButton(args[0]);
		    }
		    	
		    
		  }
	
	
	
}
