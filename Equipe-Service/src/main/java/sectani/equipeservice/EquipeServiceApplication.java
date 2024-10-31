package sectani.equipeservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sectani.equipeservice.Entities.Equipe;
import sectani.equipeservice.Service.EquipeService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EquipeServiceApplication implements CommandLineRunner {

    private final EquipeService equipeService;

    public EquipeServiceApplication(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EquipeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Equipe> equipes = new ArrayList<>();
        for (int i=0 ; i<10 ; i++){
            Equipe equipe = new Equipe("EQ"+(i+1),"Equipe"+(i+1));
            equipes.add(equipe);
        }
        equipeService.saveAll(equipes);
    }
}
