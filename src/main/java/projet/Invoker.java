package projet;

public class Invoker {
	
	 private Command command;
	  public void setCommand(Command command){
	    this.command = command;
	  }
	  public void pressButton(String mot){
	    command.execute(mot);
	  }

}
