package ca.mylumen.psychio.controller;

import ca.mylumen.psychio.entity.Niveau;
import ca.mylumen.psychio.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/niveau")
public class NiveauController {

    @Autowired
    private NiveauRepository niveauRepository;
    @PostMapping("create")
    public ResponseEntity<Niveau> createNiveau(@RequestBody Niveau niveau) {
        Niveau createdNiveau = niveauRepository.save(niveau);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNiveau);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Niveau> updateNiveau(@PathVariable("id") int id, @RequestBody Niveau niveauModifie) {
        Optional<Niveau> niveauOptional = niveauRepository.findById(id);
        if (niveauOptional.isPresent()) {
            Niveau niveauExist = niveauOptional.get();
            niveauExist.setNom(niveauModifie.getNom());
            Niveau niveauMisAJour = niveauRepository.save(niveauExist);
            return ResponseEntity.ok(niveauMisAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNiveau(@PathVariable("id") Long id) {
        niveauRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}