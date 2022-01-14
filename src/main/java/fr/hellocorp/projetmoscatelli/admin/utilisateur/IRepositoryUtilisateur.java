package fr.hellocorp.projetmoscatelli.admin.utilisateur;

import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;
import fr.hellocorp.projetmoscatelli.admin.outil.Outil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositoryUtilisateur extends CrudRepository <Utilisateur, Long> {
    Long countById( Long id);

    @Query(
            value="select *, if(role=0,'Administrateur',if(role=1,'Magasinier',if(role=2,'Visiteur', 'Statut inconnu' ))) AS statut from utilisateurs where (if(role=0,'Administrateur',if(role=1,'Magasinier',if(role=2,'Visiteur', 'Statut inconnu' ))) like %?1% ) OR (email LIKE %?1% ) OR (prenom LIKE %?1% ) OR (nom LIKE %?1% ) OR (telephone LIKE %?1% )",
            nativeQuery = true)
    List<Utilisateur> search(String keyword);

    Utilisateur findByEmail(String email);
}

