package de.xu.events.controller;

import de.xu.events.model.Venue;
import de.xu.events.service.VenueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
@Tag(name ="Venues", description = "Venues management API")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @GetMapping
    public ResponseEntity<List<Venue>> getAllVenues(){
        List<Venue> venueList = venueService.findAllVenues();
        return ResponseEntity.ok(venueList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id){
        return venueService.findVenueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue){
        Venue newVenue = venueService.saveVenue(venue);
        return ResponseEntity.ok(newVenue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venueDetails){
        return venueService.findVenueById(id)
                .map(venue -> {
                    BeanUtils.copyProperties(venueDetails, venue, "id");
                    Venue updatedVenue = venueService.saveVenue(venue);
                    return ResponseEntity.ok(updatedVenue);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVenue(@PathVariable Long id){
        return venueService.findVenueById(id)
                .map(venue -> {
                    venueService.deleteVenue(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
