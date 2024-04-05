package de.applo.Applo.service;

import de.applo.Applo.model.Book;
import de.applo.Applo.model.Order;
import de.applo.Applo.model.User;
import jakarta.annotation.PostConstruct;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderService {
    private final BookService bookService;
    private final UserService userService;

    private List<Order> orders = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public OrderService(BookService bookService, UserService userService){
        this.bookService = bookService;
        this.userService = userService;
    }

    public List<Order> findAll(){
        return orders;
    }

    public List<Order> findAllByUsername(String username){
        return orders.stream().filter(order -> order.user().username().equals(username)).toList();
    }

    public Optional<Order> findOne(Integer id){
        return orders.stream().filter(order -> order.orderId() == id).findFirst();
    }

    public Order create(Book book, User userId){
        Order order = new Order(id.incrementAndGet(), book, userId, OffsetDateTime.now());
        orders.add(order);
        return order;
    }

    @PostConstruct
    private void init(){
        create(bookService.findOne(1).get(), userService.findOne(1).get());
        create(bookService.findOne(2).get(), userService.findOne(2).get());
        create(bookService.findOne(2).get(), userService.findOne(2).get());

    }

}
