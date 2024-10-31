package sectani.equipeservice.Web;

import org.springframework.web.bind.annotation.*;
import sectani.equipeservice.Entities.Equipe;
import sectani.equipeservice.Service.EquipeService;

import java.util.List;

@RestController
@RequestMapping("/v1/equipes")
public class EquipeControllerV1 {
    private final EquipeService equipeService;
    public EquipeControllerV1(EquipeService equipeService) {
        this.equipeService = equipeService;
    }
    @GetMapping
    public List<Equipe> getAll(){
        return equipeService.getAll();
    }
    @GetMapping("getByCode/{code}")
    public Equipe getByCode(@PathVariable String code){
        return equipeService.getByCode(code);
    }
    @PostMapping("/equipe")
    public void create(@RequestBody Equipe equipe){
        equipeService.CreateOrUpdate(equipe);
    }
    @PutMapping("/equipe/{num}")
    public void update(@PathVariable int num, @RequestBody Equipe equipe){
        equipe.setNumero(num);
        equipeService.CreateOrUpdate(equipe);
    }
    @DeleteMapping("delete/{num}")
    public void delete(@PathVariable int num){
        Equipe equipe = equipeService.getByNumero(num);
        equipeService.delete(equipe);
    }
}
