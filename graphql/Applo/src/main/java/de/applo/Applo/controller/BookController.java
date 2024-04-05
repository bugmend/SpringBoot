package de.applo.Applo.controller;

import de.applo.Applo.model.Book;
import de.applo.Applo.model.Genre;
import de.applo.Applo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;


@Controller
public class BookController {
    private final BookService bookService;
//
//    public BookController(BookService bookService){
//        this.bookService = bookService;
//    }
//
//    @QueryMapping
////    @SchemaMapping(typeName = "Query", value = "findAll")
//    public List<Book> findAll(){
//        return bookService.findAll();
//    }
//    @QueryMapping
//    public Optional<Book> findOne(@Argument Integer id){
//        return bookService.findOne(id);
//    }
//
//    @MutationMapping
//    public Book create(@Argument String name, @Argument Genre genre){
//        return bookService.create(name, genre);
//    }
//
//    @MutationMapping
//    public Book update(@Argument Integer id, @Argument String name, @Argument Genre genre){
//       return bookService.update(id, name, genre);
//    }
//
//    @MutationMapping
//    public Book delete(@Argument Integer id){
//        return bookService.delete(id);
//    }


    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService){
        this.bookService = bookService;
        log.info("All Books: {}", bookService.findAll());
    }

    @Secured("ROLE_USER")
    @QueryMapping(value = "allBook")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping(value = "createBook")
    public Book create(@Argument String name, @Argument Genre genre){
        return bookService.create(name, genre);
    }

}
