package fr.hellocorp.projetmoscatelli.admin.utilisateur;

import fr.hellocorp.projetmoscatelli.admin.outil.Outil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("utilisateurService")
public class UtilisateurService {
    @Autowired
    private IRepositoryUtilisateur repo;


    public List<Utilisateur> findAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);}
        return (List<Utilisateur>) repo.findAll();
    }


    public List<Utilisateur> findAll(){
        return (List<Utilisateur>) repo.findAll();
    }


    public void enregistrer(Utilisateur utilisateur) {
        // TO DO verifier les données ...
        repo.save(utilisateur);
    }

    public void supprimer(Long id) throws UtilisateurNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count ==0) {
            throw new UtilisateurNotFoundException("l'utilisateur " + id + " n'existe pas.");
        }
        repo.deleteById(id);
    }
}
