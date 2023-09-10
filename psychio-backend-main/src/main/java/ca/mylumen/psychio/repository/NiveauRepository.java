package ca.mylumen.psychio.repository;

import ca.mylumen.psychio.entity.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    // Ajoutez des méthodes spécifiques au besoin
}