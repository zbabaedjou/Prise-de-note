package projet;
import java.util.Arrays;
import static org.asciidoctor.Asciidoctor.Factory.create;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Fonctionnalite { ////////////////cHANGER DEFAULT PROJECT ET CoNTEXT DANS NOTE
	
	private String conf_file="C:\\Users\\Ziadath BABAEDJOU\\Desktop\\note.txt";
	private String path;
	private String application;
	private String ascii_view;
	private String line;
	private List_Attribut instanceUniq;
	
	 /**
	  * Constructeur de la classe
	  * Il r�cup�re le nom des applications externes a utiliser et le chemin du dossier d'enr�gistrement des notes
	  * Aussi il r�cup�re l'etat du singleton dans le fichier de sauvegard 
	  */
	public  Fonctionnalite() {
		String line="";
		try {
            FileReader fileReader = 
                new FileReader(conf_file);
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

           			while((line = bufferedReader.readLine()) != null) {
           				if(line.length() != 0 && line.contains("PATH")){
           					String[] arrOfStr = line.split("=", 2); 
           						this.path=arrOfStr[1];           						
           						
                }
           				if(line.length() != 0 && line.contains("APP")){
           					String[] arrOfStr = line.split("=", 2); 						
       						this.application=arrOfStr[1];
       						}
           				
           				if(line.length() != 0 && line.contains("ASCII_VIEW")){
           					String[] arrOfStr = line.split("=", 2); 						
       						this.ascii_view=arrOfStr[1];
       						}
           			
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                		conf_file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + conf_file + "'");          
         
        }
		File tempFile = new File(this.path+"Saves.ser");
		if(tempFile.exists()==false) {
			this.instanceUniq=List_Attribut.getInstance();
		}
		else {
			this.deserialize();
		}
	}
	
	
	/**
	 * Editer(): Ouvre un fichier existant ou le cr�� qaudn il n'exista pas avant de l'ouvrir
	 * Lors de la cr�atin il rempli le fichier par d�faut avec les attribut projet et contextes par d�faut
	 * @param nom
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	public void editer(String nom ) throws IOException, InterruptedException {
		line = "";
		String project = "DefaultProject";
		String context="DefaultContext";
		Note note = null;
		File tempFile = new File(this.path+nom+".adoc");
	
		if(tempFile.exists()==false) {
			note=new Note
					.Builder(nom)
					.build();
			this.instanceUniq.ajouterNote(note);
			
			
			
			 try {
	             FileWriter fichier = new FileWriter(path+nom+".adoc");

	             BufferedWriter bufferedWriter = new BufferedWriter(fichier);

	             bufferedWriter.write("= "+note.getNom());
	             bufferedWriter.newLine();
	             bufferedWriter.write(""+note.getDate());
	             bufferedWriter.newLine();
	             bufferedWriter.write(":context: "+note.getContext());
	             bufferedWriter.newLine();
	             bufferedWriter.write(":project: "+note.getProjet());
	             bufferedWriter.newLine();
	             bufferedWriter.close();
	         }
	         catch(IOException ex) {
	        	 System.out.println(
	                 "Erreur lors de l'�criture dans le fichier'"
	                 + nom + ".adoc");
	         }
			 
			 		
		}
		else{
			note=this.instanceUniq.getNote(nom);
		}
		
		project = note.getProjet();
		context= note.getContext();
		Process p = Runtime.getRuntime().exec(this.application+" "+this.path+nom+".adoc");
	    p.waitFor();		
		
	    try {
            FileReader fileReader = 
                new FileReader(this.path+nom+".adoc");
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

           			while((line = bufferedReader.readLine()) != null) {
           				if(line.length() != 0 && line.contains("project")){ 
           					String[] arrOfStr = line.split(":", 3); 
       						if(!project.equals(arrOfStr[2]))
       							project = arrOfStr[2];      
       						
       					}       
           			 if (line.length() != 0 && line.contains("context")){ 
        					String[] arrOfStr = line.split(":", 3); 
    						if(!context.equals(arrOfStr[2]))
    							context = arrOfStr[2];  
    						
    					}
           			 
           			}
           			
              

           bufferedReader.close(); 
           
           if(project!=note.getProjet()||context!=note.getContext()) {
	           note=this.instanceUniq.getNote(nom);
	           this.instanceUniq.supprimerNote(note);
	           note=new Note
						.Builder(nom)
						.addProjet(project)
						.addContext(context)
						.build();
	           this.instanceUniq.ajouterNote(note);
           }
           
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                this.path+nom+".adoc" + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + this.path+nom+".adoc" + "'");                  


        }
	    this.majFichier();
	    
	}

	/**
	 * lister()
	 * Cete fonction liste les notes existantes
	 */
	public void lister() {
		
		System.out.println(this.instanceUniq.listerNotes());
		
	}
	
	public void apercu(String nom) {
		
		
		
	}
	
	
	/** Delete()
	 * Supprime une note
	 * Cette fonction supprime la note du singleton puis suprime le fichier qui lui est associ�
	 * @param nom
	 */
	public void delete(String nom) {
		
		boolean exist=false;
		Note note=this.instanceUniq.getNote(nom);
		exist=this.instanceUniq.supprimerNote(note);
		if(exist==false)
			System.out.println("Impossible de supprimer le fichier car il n'existe pas");
		else {
				File MyFile = new File(this.path+nom+".adoc"); 
				MyFile.delete(); 
			
			
			this.majFichier();
		
		}
		
		
	}
	
	public void Rechercher(String mot) {
		
	}
	
	
	/**majFichier : Met � jour le fichier index.adoc
	 * sera appel� apr�s chaque modification: editer; delete;
	 * 
	 */
	public void majFichier() {
		 try {
             FileWriter fichier = new FileWriter(this.path+"index.adoc");

             BufferedWriter bufferedWriter = new BufferedWriter(fichier);

             bufferedWriter.write(this.instanceUniq.listerDansFichier());
             bufferedWriter.newLine();
             bufferedWriter.newLine();
             bufferedWriter.close();
         }
         catch(IOException ex) {
        	 System.out.println(
                 "Erreur lors de l'�criture dans le fichier index.adoc");
         }
		 
		 this.serialize();
		 
		
	}
	
	/**
	 * inconnu()
	 * Fonction appel� lorsque l'utilisatuer lance une commande non suppoet� par le programme
	 */
	public void inconnu(String nom) {
		System.out.println("Command '"+nom+"' non connu");
	}
	
	
	/**
	 * Serialize()
	 * Enr�gistre le contenu du singleton dans un fichier afin de garder l'�tat du syst�me de fichier
	 */
	public synchronized void serialize() {
		try {
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
					this.path+"Saves.ser"));
	        out.writeObject(this.instanceUniq);
	        out.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Deserialise retourne le contenu du singleton sauvegard� lors de la s�rialisation
	 */
	public synchronized void deserialize() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					 this.path+"Saves.ser"));
		        this.instanceUniq= (List_Attribut)in.readObject();
		        in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
