
import java.util.Properties;
import model.model.Book;
import model.model.Patron;

import model.*;

public class TestMain
{

       public static void main(String[] args)
       {
          try
          {
			Book bk = new Book("1");
			System.out.println(bk.toString());
		  
			Properties p = new Properties();
			p.setProperty("bookTitle", "I hate Sandeep Mitra");
			p.setProperty("author", "Kyle Adams");
			p.setProperty("pubYear", "2020");
			p.setProperty("status", "Active");
			
			Book bk2 = new Book(p);
			bk2.update();
		  
		    Patron pat = new Patron("1");
			System.out.println(pat.toString());
		  
	    
	 
          }
          catch (Exception ex) 
          {
			System.out.println("Error in accessing Kyle stupid database: " + ex.toString());
		  }


       }
}