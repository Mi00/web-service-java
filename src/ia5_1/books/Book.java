package ia5_1.books;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "book")
public class Book {
    private String id;
    private String title;
    private List<String> authors;
    private String isbn;
    private Integer year;
    private String publisher;
    private Integer pages;
    
    public Book() {};

    public Book(String id, String title, List<String> authors, String isbn, Integer year, String publisher, Integer pages) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.year = year;
        this.publisher = publisher;
        this.pages = pages;
    }
    
   @XmlAttribute
   public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @XmlElement( name="author" )
    @XmlElementWrapper( name="authors" )    
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> author) {
        this.authors = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, authors: %s, ISBN: %s, publisher: %s, pages: %d", title, authors, isbn, publisher, pages);
    }
}
