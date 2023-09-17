package ca.mylumen.psychio.repository;
import ca.mylumen.psychio.entity.Etudiant;
import ca.mylumen.psychio.entity.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByNiveauId(int niveauId);

    List<Etudiant> findByNiveau(Niveau niveau);
}
