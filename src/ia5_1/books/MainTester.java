package ia5_1.books;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.Endpoint;

public class MainTester { 
    public static void main(String[] args) {      
        try{
            JAXBContext context = JAXBContext.newInstance(BookList.class);
            Unmarshaller um = context.createUnmarshaller();
            
            FileReader file = new FileReader("books2.xml");
            BookList books = (BookList) um.unmarshal(file);
            file.close();
            BookManager bm = new BookManager(books.getBooks());
            List<Book> bs = bm.searchByTitle("Java");
            
            for(Book item : bs){
                System.out.println(item.toString());
            }   
            
        String url = "http://localhost:666/books";
        Endpoint.publish(url, bm);
        } catch ( Exception e){
            e.printStackTrace();
        }   
    }
}
