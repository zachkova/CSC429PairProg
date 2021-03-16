
import java.util.Properties;
import model.model.*;
import java.util.*;

import model.*;

public class TestMain
{

       public static void main(String[] args) {
          /*try
          {

			  Scanner sc = new Scanner(System.in);  // Create a Scanner object

			  //create properties object
			  Properties add = new Properties();
			  Properties add1 = new Properties();

			 //USER IO creating a new Book
			  System.out.print("Enter bookTitle: ");
			  add.setProperty("bookTitle", sc.nextLine());
			  System.out.print("Enter author: ");
			  add.setProperty("author", sc.nextLine());
			  System.out.print("Enter pubYear: ");
			  add.setProperty("pubYear", sc.nextLine());
			  System.out.print("Enter status: ");
			  add.setProperty("status", sc.nextLine());

			  //create book object for properties set
			  //Book bk = new Book(add);
			  //bk.update();

			  //User IO adding Patron

			  System.out.print("Enter name: ");
			  add1.setProperty("name", sc.nextLine());
			  System.out.print("Enter address: ");
			  add1.setProperty("address", sc.nextLine());
			  System.out.print("Enter city: ");
			  add1.setProperty("city", sc.nextLine());
			  System.out.print("Enter stateCode: ");
			  add1.setProperty("stateCode", sc.nextLine());
			  System.out.print("Enter zip: ");
			  add1.setProperty("zip", sc.nextLine());
			  System.out.print("Enter email: ");
			  add1.setProperty("email", sc.nextLine());
			  System.out.print("Enter dateOfBirth: ");
			  add1.setProperty("dateOfBirth", sc.nextLine());
			  System.out.print("Enter status: ");
			  add1.setProperty("Status", sc.nextLine());

			  Patron p = new Patron(add1);
			  p.update();



			  System.out.print("Type in title like: ");
			  BookCollection bkc = new BookCollection();
			  bkc.findBooksWithTitleLike(sc.nextLine());
			  System.out.print(bkc.toString());


			  System.out.print("Type year before book: ");
			  bkc.findBooksOlderThan(sc.nextLine());
			  System.out.print(bkc.toString());

			  System.out.print("Patrons younger than year: ");
			  PatronCollection yT	= new PatronCollection();
			  yT.findPatronsOlderThan(sc.nextLine());
			  System.out.println("younger than: " + yT.toString());

			  System.out.println("Find patrons at zip code: ");
			  yT.findPatronsAtZipCode(sc.nextLine());
			  System.out.println("at zip: " + yT.toString());






          	/*
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
           */

	   }
}