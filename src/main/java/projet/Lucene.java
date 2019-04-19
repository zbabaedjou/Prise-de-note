//git pull https://github.com/zbabaedjou/PriseDeNote master
//Fonction de  recherche a l'aide de lucene biblio

package projet;
import java.util.List;
import java.util.ArrayList;

public class Lucene 
{
	public List_Attribut list;
//Creation d'index
private  List<Note> comp=new ArrayList<Note>();

public void add (Note n)
{
  comp.add(n);
} 

public List<Note>getlist()
{
    return comp;
}
}


