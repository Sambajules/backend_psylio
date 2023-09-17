package ca.mylumen.psychio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "niveau")
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;

    @OneToMany(mappedBy = "niveau")
    @JsonIgnore
    private List<Etudiant> etudiants;

    public Niveau() {
        // Constructeur par défaut sans arguments
    }

    public Niveau(int id) {
        this.id = id;
    }

    public Niveau(int id, String nom, List<Etudiant> etudiants) {
        this.id = id;
        this.nom = nom;
        this.etudiants = etudiants;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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