package ca.mylumen.psychio.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "niveau")
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "niveau")
    private List<Etudiant> etudiants;

    public Niveau(Long id, String nom, List<Etudiant> etudiants) {
        this.id = id;
        this.nom = nom;
        this.etudiants = etudiants;
    }

    public Niveau() {
        // Constructeur par défaut sans arguments
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}