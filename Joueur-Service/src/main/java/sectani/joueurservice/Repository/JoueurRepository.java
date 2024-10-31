package sectani.joueurservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sectani.joueurservice.Entities.Joueur;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur,Integer> {
    Joueur findById(int id);

    //@Query("select Joueur from Joueur order by nbrButs desc ")

    List<Joueur> getAllByOrderByNbrButsDesc();
}
