package de.xu.events.service;

import de.xu.events.model.Venue;
import de.xu.events.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    public List<Venue> findAllVenues(){
        return venueRepository.findAll();
    }

    public Optional<Venue> findVenueById(Long id){
        return venueRepository.findById(id);
    }

    public Venue saveVenue(Venue venue){
        return venueRepository.save(venue);
    }

    public void deleteVenue(Long id){
        venueRepository.deleteById(id);
    }

}
