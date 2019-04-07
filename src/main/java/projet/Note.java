package projet;

import java.time.LocalDate;

public class Note {
	private String nom;
	  private String projet;
	    private String context;
	    private LocalDate  date;
	    
	    
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

	    public LocalDate getDate()
	        {
	            return date;
	        }
	    
	    public Note (Builder builder)
	        {
	             this.projet=builder.projet;
	             this.context=builder.context;
	             this.date=builder.date;
	        }
	    
	           
	     public static class Builder
	        {
	                 private String projet;
	                 private String context;
	             private LocalDate date=LocalDate.parse("1991-06-05");;
	             public Builder (String projet,String context)
	                {
	                    this.projet=projet;
	                    this.context=context;
	                   
	                }
	               public Builder date (LocalDate ddn)
	                        {
	                                date=ddn;
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
