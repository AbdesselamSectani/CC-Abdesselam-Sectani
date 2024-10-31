package sectani.equipeservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sectani.equipeservice.Entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    Equipe findByNumero(int numero);
    Equipe findByCode(String code);
}
