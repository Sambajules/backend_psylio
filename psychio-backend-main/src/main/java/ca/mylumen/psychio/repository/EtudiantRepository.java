package ca.mylumen.psychio.repository;
import ca.mylumen.psychio.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {


    @Query("SELECT e FROM Etudiant e JOIN e.niveau n WHERE n.id = :niveauId")
    List<Etudiant> findByNiveauId(@Param("niveauId") Long niveauId);
}
