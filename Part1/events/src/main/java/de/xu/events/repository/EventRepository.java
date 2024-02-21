package de.xu.Events.repository;

import de.xu.Events.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Ensure this interface extends JpaRepository
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}