package de.xu.events.service;

import de.xu.events.model.Event;
import de.xu.events.repository.EventRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAllEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> findEventById(Long id){
        return eventRepository.findById(id);
    }

    public Event saveEvent(Event event){
        return eventRepository.save(event);
    }
    public Event updateEvent(Event existingEvent, Event eventDetails){
        BeanUtils.copyProperties(eventDetails, existingEvent, "id");
        return eventRepository.save(existingEvent);
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }
}
