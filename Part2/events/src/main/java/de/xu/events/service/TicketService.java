package de.xu.events.service;

import de.xu.events.model.Ticket;
import de.xu.events.repository.TicketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
    public Optional<Ticket> findTicketById(Long id){
        return ticketRepository.findById(id);
    }

    public Ticket saveTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> updateTicket(Long id, Ticket ticketDetails){
        return ticketRepository.findById(id)
                .map(existingTicket -> {
                    BeanUtils.copyProperties(ticketDetails, existingTicket, "id");
                    return ticketRepository.save(existingTicket);
                });
    }
    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }
}
