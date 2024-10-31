package sectani.joueurservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sectani.joueurservice.Entities.Joueur;
import sectani.joueurservice.Service.JoueurService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JoueurServiceApplication implements CommandLineRunner {

    private final JoueurService joueurService;

    public JoueurServiceApplication(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JoueurServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Joueur> joueurs = new ArrayList<>();
        double salaire = 1000.0;
        for (int i=0 ; i<10 ; i++){
            Joueur joueur = new Joueur("Joueur"+(i+1),"Position"+(i+1),salaire,(i+1),(i+1));
            joueurs.add(joueur);
            salaire+=1000.0;
        }
        joueurService.saveAll(joueurs);
    }
}
