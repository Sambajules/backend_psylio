package ca.mylumen.psychio.repository;

import ca.mylumen.psychio.entity.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    Optional<Niveau> findById(int id);

    List<Niveau> findByNom(String nom);


}