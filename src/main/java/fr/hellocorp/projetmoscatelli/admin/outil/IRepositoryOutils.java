package fr.hellocorp.projetmoscatelli.admin.outil;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositoryOutils extends CrudRepository <Outil, Long> {
    Long countById(Long id);


    @Query(
            value="select *, if(type_statut=0,'Fonction',if(type_statut=1,'Rebut',if(type_statut=2,'Manquant',if(type_statut=3,'Maintenance',if(type_statut=4,'Etalonnage','Statut inconnu'))))) AS statut from outil where (etalonnee=?2) AND ((if(type_statut=0,'Fonction',if(type_statut=1,'Rebut',if(type_statut=2,'Manquant',if(type_statut=3,'Maintenance',if(type_statut=4,'Etalonnage','Statut inconnu'))))) like %?1%) OR (designation LIKE %?1% ) OR (fournisseur LIKE %?1%) OR (periodicite LIKE %?1%) OR (marque LIKE %?1%) OR (puissance LIKE %?1%) OR (modele LIKE %?1%) OR (numero_de_serie LIKE %?1%) OR (repere LIKE %?1%) OR (etat LIKE %?1%) OR (capacite LIKE %?1%));",
            nativeQuery = true)
    List<Outil> search(String keyword, boolean etalonnee);

    List<Outil> findByEtalonnee(boolean etalonnee);

}

