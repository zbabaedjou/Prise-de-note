package projet;


import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class Note {
	    private String nom;
	    private String projet;
	    private String context;
	    private Date  date;

	    
	    
	    public String getNom() {
			return nom;
		}
	    public String getProjet() 
	        {
	            return projet;
	        }

	    public String getContext() 
	        {
	            return context;
	        }


	    public Date getDate()

	        {
	            return date;
	        }
	    
	    public Note (Builder builder)
	        {

	    		this.nom =builder.buildnom; 
	             this.projet=builder.buildprojet;
	             this.context=builder.builcontext;
	             this.date=builder.builddate;

	        }
	           
	     public static class Builder
	        {

	                 private String buildnom;
	    	 		 private String buildprojet;
	                 private String builcontext;
	                 private Date builddate;
	                 
	             public Builder (String nom,String projet,String context)
	                {
	            	 	this.buildnom=nom;
	                    this.buildprojet=projet;
	                    this.builcontext=context;
	                   
	                }
	               public Builder date (Date ddn)
	                        {
	                                this.builddate=ddn;
	                                return this;
	                        }    
	                
	                      public Note build() 
	                      {
	                      return new Note(this);
	                      }
	        }


	    @Override
	    public String toString() {
	        return "Note{" + "project=" + projet + ", context=" + context + ", date=" + date + '}';
	    }
	
	
	
}