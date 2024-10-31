package sectani.joueurservice.Web;

import org.springframework.web.bind.annotation.*;
import sectani.joueurservice.Entities.Joueur;
import sectani.joueurservice.Service.JoueurService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/v1/joueurs")
public class JoueurControllerV1 {
    private final JoueurService joueurService;

    public JoueurControllerV1(JoueurService joueurService) {
        this.joueurService = joueurService;
    }
    @GetMapping
    public List<Joueur> getAll(){
        return joueurService.getAll();
    }
    @GetMapping("getById/{id}")
    public Joueur getByCode(@PathVariable int id){
        return joueurService.getById(id);
    }
    @PostMapping("/joueur")
    public void create(@RequestBody Joueur joueur){
        joueurService.CreateOrUpdate(joueur);
    }
    @PutMapping("/joueur/{id}")
    public void update(@PathVariable int id, @RequestBody Joueur joueur){
        joueur.setId(id);
        joueurService.CreateOrUpdate(joueur);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id){
        Joueur joueur = joueurService.getById(id);
        joueurService.delete(joueur);
    }

    @PutMapping("/augmenterNbrButs/{id}/{buts}")
    public Joueur updateNbrButs(@PathVariable int id, @PathVariable int buts){
        Joueur joueur = joueurService.getById(id);
        joueur.setNbrButs(joueur.getNbrButs()+buts);
        joueurService.CreateOrUpdate(joueur);
        return joueur;
    }

    @GetMapping("/listerParNombreDeButs")
    public List<Joueur> getByNnbButs(){
        return joueurService.getJoueursByNnbButs();
    }

    @GetMapping("/MeilleurButteur")
    public Joueur getMeilleurButteur(){
        return joueurService.getMeilleurButteur();
    }

    @GetMapping("/TotaleDeButs")
    public int getTotaleDeButs(){
        AtomicInteger totale = new AtomicInteger();
        joueurService.getAll().forEach(joueur -> {
            totale.addAndGet(joueur.getNbrButs());
        });
        return totale.get();
    }
}
