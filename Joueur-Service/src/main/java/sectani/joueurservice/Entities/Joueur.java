package sectani.joueurservice.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Joueur {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String position;
    private double salaire;
    private int nbrButs;
    private int numeroEquipe;

    public Joueur(String nom, String position, double salaire, int nbrButs, int numeroEquipe) {
        this.nom = nom;
        this.position = position;
        this.salaire = salaire;
        this.nbrButs = nbrButs;
        this.numeroEquipe = numeroEquipe;
    }
}
