package ca.mylumen.psychio.controller;


import ca.mylumen.psychio.entity.Etudiant;
import ca.mylumen.psychio.entity.Niveau;
import ca.mylumen.psychio.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<String> ajouterEtudiant(@RequestBody Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body("Étudiant ajouté avec succès");
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> modifierEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant etudiant) {
        Etudiant etudiantExist = etudiantRepository.findById(id).orElse(null);
        if (etudiantExist != null) {
            etudiantExist.setNom(etudiant.getNom());
            etudiantRepository.save(etudiantExist);
            return ResponseEntity.ok("Nom de l'étudiant modifié avec succès avec put");
        } else {
            return ResponseEntity.notFound().build();
        }
}
@PatchMapping(value = "/update/{id}")
    public ResponseEntity<String> modifierPartieEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant etudiant) {
        Etudiant etudiantExist = etudiantRepository.findById(id).orElse(null);
        if (etudiantExist != null) {
            if (etudiant.getNom() != null) {
                etudiantExist.setNom(etudiant.getNom());
            }
            etudiantRepository.save(etudiantExist);
            return ResponseEntity.ok("Nom de l'étudiant modifié avec succès avec patch");
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> supprimerEtudiant(@PathVariable("id") Long id) {
        Etudiant etudiantExist = etudiantRepository.findById(id).orElse(null);
        if (etudiantExist != null) {
            etudiantRepository.delete(etudiantExist);
            return ResponseEntity.ok("Étudiant supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/niveau/{id}")
    public List<Etudiant> getEtudiantsByNiveau(@PathVariable("id") Long niveauId) {
        return etudiantRepository.findByNiveauId(niveauId);
        }
    }
