package projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fonctionnalite { ////////////////cHANGER DEFAULT PROJECT ET CoNTEXT DANS NOTE
	
	private String conf_file="C:\\Users\\Ziadath BABAEDJOU\\Desktop\\note.txt";
	private String path;
	private String application;
	private String line;
	
	
	public  Fonctionnalite() {
		String line="";
		try {
            FileReader fileReader = 
                new FileReader(conf_file);
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

           			while((line = bufferedReader.readLine()) != null) {
           				if(line.length() != 0 && line.contains("PATH")){
           					//data=line;
           					String[] arrOfStr = line.split("=", 2); 
           						//System.out.println(arrOfStr[1]);
           						this.path=arrOfStr[1];           						
           						
                }
           				if(line.length() != 0 && line.contains("APP")){
           					String[] arrOfStr = line.split("=", 2); 
       						//System.out.println(arrOfStr[1]);
       						
       						this.application=arrOfStr[1];
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
	}
	
	
	/**
	 * Editer(): Ouvre un fichier existant ou le créé qaudn il n'exista pas avant de l'ouvrir
	 * Lors de la créatin il rempli le fichier par défaut avec les attribut projet et contextes par défaut
	 * @param nom
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	public void editer(String nom ) throws IOException, InterruptedException {
		int exist=0;
		line = "";
		String project = "DefaultProject";
		String context="DefaultContext";
		Note note = null;
		for(Note n : List_Attribut.getInstance().getList_all())
			if(n.getNom().equals(nom)) {
				exist=1;
				break;
			}
		System.out.println(exist);
		if(exist==0) {
			note=new Note
					.Builder(nom)
					.build();
			
			List_Attribut.getInstance().ajouterNote(note);
			
			
			
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
	                 "Erreur lors de l'écriture dans le fichier'"
	                 + nom + ".adoc");
	             // ex.printStackTrace();
	         }
			 
			 		
		}
		else {
			note=List_Attribut.getInstance().getNote(nom);
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
           				System.out.println(line);
           				if(line.length() != 0 && line.contains("project")){ 
           					String[] arrOfStr = line.split(":", 3); 
       						System.out.println(arrOfStr[2]);
       						if(!project.equals(arrOfStr[2]))
       							project = arrOfStr[2];      
       						
       					}       
           			 if (line.length() != 0 && line.contains("context")){ 
        					String[] arrOfStr = line.split(":", 3); 
    						System.out.println(arrOfStr[2]);
    						if(!context.equals(arrOfStr[2]))
    							context = arrOfStr[2];  
    						
    					}	
           			}
           			
              

           bufferedReader.close(); 
           
           // Vérifi si l'utilisateur a cahnger le context et le projet si oui il les change
           if(project!=note.getProjet()||context!=note.getContext()) {
        	   System.out.println("teeeessssssssssssss");
	           note=List_Attribut.getInstance().getNote(nom);
	           List_Attribut.getInstance().supprimerNote(note);
	           note=new Note
						.Builder(nom)
						.addProjet(project)
						.addContext(context)
						.build();
	           List_Attribut.getInstance().ajouterNote(note);
	           System.out.println(List_Attribut.getInstance().listerNotes());
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

	
	public void lister() {
		
		System.out.println("lister");
		
		System.out.println(List_Attribut.getInstance().listerNotes());
		
	}
	
	public void apercu(String nom) {
		
	}
	
	
	/** Delete()
	 * Supprime une note
	 * @param nom
	 */
	public void delete(String nom) {
		
		boolean exist=false;
		Note note=List_Attribut.getInstance().getNote(nom);
		exist=List_Attribut.getInstance().supprimerNote(note);
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
	
	
	/**majFichier : Met à jour le fichier index.adoc
	 * 
	 * 
	 */
	public void majFichier() {
		 try {
             FileWriter fichier = new FileWriter(this.path+"index.adoc");

             BufferedWriter bufferedWriter = new BufferedWriter(fichier);

             bufferedWriter.write(List_Attribut.getInstance().listerDansFichier());
             bufferedWriter.newLine();
             bufferedWriter.newLine();
             bufferedWriter.close();
         }
         catch(IOException ex) {
        	 System.out.println(
                 "Erreur lors de l'écriture dans le fichier index.adoc");
         }
		 
		
	}
	
	public void inconnu() {
		System.out.println("Command non connu");
	}
}
