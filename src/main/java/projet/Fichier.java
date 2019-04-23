package projet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Fichier 
{
	String chemin = new File("").getAbsolutePath()+"/ressource/";
	public void edit(String fileName) throws IOException {
		File file = new File(chemin);
		Desktop desc = Desktop.getDesktop();
		if(file.isDirectory()) {
			File fileacreer = new File(chemin+fileName);
			if(fileacreer.exists()) {
				desc.open(fileacreer);
			}else {
				fileacreer.createNewFile();
				desc.open(fileacreer);
			}
			
		}
		
	}
	  public void search(String motAchercher) throws FileNotFoundException
    {
        File directory = new File(chemin);
        File[] files = directory.listFiles();
        String chaine = "";

        for (int i = 0; i < files.length; i++) 
        {
            if (files[i].getName().endsWith(".adoc")) 
            {
                 Scanner s = new Scanner(files[i]);
                chaine = "";
                while (s.hasNextLine())
                {
                    chaine += s.nextLine();
                }

                if (chaine.contains(motAchercher)) 
                {
                    System.out.println("Element trouvé dans: " + files[i].getName());

                }

            } 
        }
   }
          
	
}