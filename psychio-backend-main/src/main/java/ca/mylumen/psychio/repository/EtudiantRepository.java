package ca.mylumen.psychio.repository;
import ca.mylumen.psychio.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
