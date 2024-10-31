package sectani.joueurservice.Service;

import org.springframework.stereotype.Service;
import sectani.joueurservice.Entities.Joueur;
import sectani.joueurservice.Repository.JoueurRepository;

import java.util.List;

@Service
public class JoueurService {
    private final JoueurRepository joueurRepository;

    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public void CreateOrUpdate(Joueur joueur){
        joueurRepository.save(joueur);
    }
    public void saveAll(List<Joueur> joueurs){
        joueurRepository.saveAll(joueurs);
    }
    public void delete(Joueur joueur){
        joueurRepository.delete(joueur);
    }
    public Joueur getById(int id){
        return joueurRepository.findById(id);
    }
    public List<Joueur> getAll(){
        return joueurRepository.findAll();
    }
    public List<Joueur> getJoueursByNnbButs(){
        return joueurRepository.getAllByOrderByNbrButsDesc();
    }
    public Joueur getMeilleurButteur(){
        List<Joueur> joueurs = joueurRepository.getAllByOrderByNbrButsDesc();
        return joueurs.get(0);
    }
}
