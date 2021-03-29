package userinterface;

import java.util.Vector;

import javafx.beans.property.SimpleStringProperty;
import model.model.Book;

//==============================================================================
public class BookTableModel
{
    private final SimpleStringProperty bookId;
    private final SimpleStringProperty bookTitle;
    private final SimpleStringProperty author;
    private final SimpleStringProperty pubYear;
    private final SimpleStringProperty status;

    //----------------------------------------------------------------------------
    public BookTableModel(Vector<String> bookData)
    {
        bookId =  new SimpleStringProperty(bookData.elementAt(0));
        bookTitle =  new SimpleStringProperty(bookData.elementAt(1));
        author =  new SimpleStringProperty(bookData.elementAt(2));
        pubYear =  new SimpleStringProperty(bookData.elementAt(3));
        status =  new SimpleStringProperty(bookData.elementAt(4));
    }

    //----------------------------------------------------------------------------
    public String getBookID() {
        return bookId.get();
    }

    //----------------------------------------------------------------------------
    public void setBookId(String number) {
        bookId.set(number);
    }

    //----------------------------------------------------------------------------
    public String getBookTitle() { return bookTitle.get();}

    //----------------------------------------------------------------------------
    public void setBookTitle(String aType) {
        bookTitle.set(aType);
    }

    //----------------------------------------------------------------------------
    public String getAuthor() {
        return author.get();
    }

    //----------------------------------------------------------------------------
    public void setAuthor(String aut) {
        author.set(aut);
    }

    //----------------------------------------------------------------------------
    public String getStatus() {
        return status.get();
    }
    //----------------------------------------------------------------------------

    public void setStatus(String sta) {
        status.set(sta);
    }
    //----------------------------------------------------------------------------

    public String getPubYear() {
        return pubYear.get();
    }
    //----------------------------------------------------------------------------

    public void setPubYear(String yr) {
        pubYear.set(yr);
    }
    //----------------------------------------------------------------------------
}

