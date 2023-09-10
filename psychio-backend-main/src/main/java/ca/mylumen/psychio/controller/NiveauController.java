package ca.mylumen.psychio.controller;

import ca.mylumen.psychio.entity.Niveau;
import ca.mylumen.psychio.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/niveau")
public class NiveauController {

    @Autowired
    private NiveauRepository niveauRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Niveau> getNiveauById(@PathVariable("id") Long id) {
        Niveau niveau = niveauRepository.findById(id).orElse(null);
        if (niveau != null) {
            return ResponseEntity.ok(niveau);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Niveau> createNiveau(@RequestBody Niveau niveau) {
        Niveau createdNiveau = niveauRepository.save(niveau);
        return ResponseEntity.ok(createdNiveau);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Niveau> updateNiveau(@PathVariable("id") Long id, @RequestBody Niveau niveau) {
        Niveau existingNiveau = niveauRepository.findById(id).orElse(null);
        if (existingNiveau != null) {
            existingNiveau.setNom(niveau.getNom());
            niveauRepository.save(existingNiveau);
            return ResponseEntity.ok(existingNiveau);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}