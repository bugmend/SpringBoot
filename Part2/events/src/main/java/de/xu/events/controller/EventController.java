package de.xu.events.controller;

import de.xu.events.model.Event;
import de.xu.events.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
@Tag(name ="Events", description = "Event management API")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>>  getAllEvents(){
        List<Event> events = eventService.findAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id){
        Optional<Event> eventOptional =eventService.findEventById(id);
        if(eventOptional.isPresent()){
            return ResponseEntity.ok(eventOptional.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails){
       Optional<Event> eventOptional = eventService.findEventById(id);
       if(eventOptional.isPresent()){
           Event updatedEvent = eventService.updateEvent(eventOptional.get(), eventDetails);
           return ResponseEntity.ok(updatedEvent);
       }
       else {
           return ResponseEntity.notFound().build();
       }
    }

}
