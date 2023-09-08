package ca.mylumen.psychio.controller;


import ca.mylumen.psychio.entity.Etudiant;
import ca.mylumen.psychio.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/etudiant")
    public class EtudiantController {


    @Autowired
    private EtudiantRepository etudiantRepository;

    @PostMapping("/create")
    public ResponseEntity<String> ajouterEtudiant(@RequestBody Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body("Étudiant ajouté avec succès");
    }


}
