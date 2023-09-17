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


    @GetMapping("/niveau/{niveauId}")
    public List<Etudiant> getEtudiantsByNiveau(@PathVariable int niveauId) {
        Niveau niveau = new Niveau();
        niveau.setId(niveauId);

        return etudiantRepository.findByNiveau(niveau);
    }

    @PostMapping("/create")
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantRepository.save(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEtudiant);
            }

            

    }
