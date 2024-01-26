package de.xu.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.xu.events.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
