
import java.util.Properties;
import model.model.*;


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

			BookCollection bkc = new BookCollection();
			bkc.findBooksWithAuthorLike("Charles Dickens");

			PatronCollection oT	= new PatronCollection();
			oT.findPatronsOlderThan("2020-01-07");

			PatronCollection yT	= new PatronCollection();
			yT.findPatronsYoungerThan("20200107");

			PatronCollection zL = new PatronCollection();
			zL.findPatronsAtZipCode("12345");

			PatronCollection pc = new PatronCollection();
			pc.findPatronsWithNameLike("Donald");

			System.out.println("Authors like: " + bkc.toString());
			System.out.println("older than: " + oT.toString());
			System.out.println("younger than: " + yT.toString());
			System.out.println("with zip like: " + zL.toString());
			System.out.println("with name like: " + pc.toString());


          }
          catch (Exception ex) 
          {
			System.out.println("Error in accessing Kyle stupid database: " + ex.toString());
		  }


       }
}