package projet;


import java.util.Date;


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
	             this.context=builder.buildcontext;
	             this.date=builder.builddate;

	        }

	           
	     public static class Builder
	        {

	                 private String buildnom;
	    	 		 private String buildprojet;
	                 private String buildcontext;
	                 private Date builddate;
	                 
	             public Builder (String nom)
	                {
	            	 	this.buildnom=nom;
	            	 	this.builddate= new Date();
	                    this.buildprojet="DefaultProject";
	                    this.buildcontext="DefaultContext";
	                   
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
	              public Builder addProjet(String projet) {
	                      	  this.buildprojet=projet;
	                      	  return this;
	                      			  }
	              public Builder addContext(String context) {
	                      	  this.buildcontext=context;
	                      	  return this;
	                        }
	                	
	        }


	    @Override
	    public String toString() {
	        return "Note{" + "project=" + projet + ", context=" + context + ", date=" + date + '}';
	    }
	    
	
}
