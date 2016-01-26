package ia5_1.books;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class BookManager {

    private List<Book> books;

    public BookManager(List<Book> books) {
        this.books = books;
    }

    @WebMethod
    public @WebResult(name = "book")
    List<Book> searchByTitle(@WebParam(name = "title") String title) {
        List<Book> booksByTitle = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }

    @WebMethod
    public @WebResult(name = "book")
    List<Book> searchByPublisher(@WebParam(name = "publisher") String publisher) {
        List<Book> bookByPublisher = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().contains(publisher)) {
                bookByPublisher.add(book);
            }
        }
        return bookByPublisher;
    }

    @WebMethod
    public @WebResult(name = "book")
    Book searchByISBN(@WebParam(name = "isbn") String isbn) {
        Book bookByISBN = null;
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                bookByISBN = book;
            }
        }
        return bookByISBN;
    }

    @WebMethod
    public @WebResult(name = "book")
    Book addBook(@WebParam(name = "book") Book book) {
        if (book.getTitle() != null && !book.getTitle().isEmpty() && book.getAuthors() != null && book.getAuthors().size() > 0 && !book.getAuthors().isEmpty()) {
            books.add(book);
            return book;
        } else {
            throw new NullPointerException("Title or Author/Authors is empty");
        }
    }

    @WebMethod
    public @WebResult(name = "book")
    List<Book> removeBook(@WebParam(name = "id") String id) {
        List<Book> lista = new ArrayList<>();
        boolean usuniete = true;
        for (Book book : books) {
            if (book.getId().contains(id)) {
                System.out.println(usuniete);
            } else {
                lista.add(book);
            }
        }
        if (lista.size() == books.size()) {
            throw new NullPointerException("Nie ma ksiazki o podanym id");
        } else {
            return lista;
        }
    }
}