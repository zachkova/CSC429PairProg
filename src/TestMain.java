
import java.util.Properties;
import model.model.Book;
import model.model.BookCollection;
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

			Properties p1 = new Properties();
			p1.setProperty("name", "Kyle");
			p1.setProperty("address", "123 somewhere");
			p1.setProperty("city", "Las Vegas");
			p1.setProperty("stateCode", "NV");
			p1.setProperty("zip", "12345");
			p1.setProperty("email", "abc@asdas.com");
			p1.setProperty("dateOfBirth", "2000-02-01");

			//Patron pat1 = new Patron(p1);
			//pat1.update();

			  BookCollection kyleBooks = new BookCollection();
			  kyleBooks.findBooksWithTItleLike("hate");
			  System.out.println(kyleBooks.toString());
          }
          catch (Exception ex) 
          {
			System.out.println("Error in accessing Kyle stupid database: " + ex.toString());
		  }


       }
}