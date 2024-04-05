package de.applo.Applo.service;

import de.applo.Applo.model.Book;
import de.applo.Applo.model.Genre;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private AtomicInteger id = new AtomicInteger(0);

    public List<Book> findAll(){
        return books;
    }

    public Optional<Book> findOne(Integer id){
        return books.stream().filter(book -> book.id() == id).findFirst();

    }

    public Book create(String name, Genre genre){
        Book book = new Book(id.incrementAndGet(), name, genre);
        books.add(book);
        return book;
    }

    public Book update(Integer id, String name, Genre genre){
        Book updatedBook = new Book(id, name, genre);
        Optional<Book> optional = books.stream().filter(b -> b.id() == id).findFirst();
        if(optional.isPresent()){
            Book book = optional.get();
            int index = books.indexOf(book);
            books.set(index, updatedBook);
        } else {
            throw new IllegalArgumentException("Invalid Book");
        }
        return updatedBook;
    }

    public Book delete(Integer id){
        Book book = books.stream().filter(b -> b.id() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        books.remove(book);
        return book;
    }

    @PostConstruct
    private void init(){
        books.add(new Book(id.incrementAndGet(), "Night", Genre.FICTION));
        books.add(new Book(id.incrementAndGet(), "Day", Genre.SCIENCE));
        books.add(new Book(id.incrementAndGet(), "Afternoon", Genre.HISTORY));

    }

}
