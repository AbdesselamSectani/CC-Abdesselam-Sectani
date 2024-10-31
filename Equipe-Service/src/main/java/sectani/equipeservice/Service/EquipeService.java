package sectani.equipeservice.Service;

import org.springframework.stereotype.Service;
import sectani.equipeservice.Entities.Equipe;
import sectani.equipeservice.Repository.EquipeRepository;

import java.util.List;

@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }
    public void CreateOrUpdate(Equipe equipe){
        equipeRepository.save(equipe);
    }
    public void saveAll(List<Equipe> equipes){
        equipeRepository.saveAll(equipes);
    }
    public void delete(Equipe equipe){
        equipeRepository.delete(equipe);
    }
    public Equipe getByNumero(int numero){
        return equipeRepository.findByNumero(numero);
    }
    public Equipe getByCode(String code){
        return equipeRepository.findByCode(code);
    }
    public List<Equipe> getAll(){
        return equipeRepository.findAll();
    }
}
