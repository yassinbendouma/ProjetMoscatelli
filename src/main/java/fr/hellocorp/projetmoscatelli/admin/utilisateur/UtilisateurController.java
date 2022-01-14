package fr.hellocorp.projetmoscatelli.admin.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService service;

    @GetMapping(value = {"/recherche",""})
    public String index(Model model, @Param("keyword") String keyword) {
        List<Utilisateur> utilisateurs = service.findAll(keyword);
        model.addAttribute("utilisateurs", utilisateurs);
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("url","/utilisateur");
        model.addAttribute("keyword", keyword);

        return "/utilisateur";
    }

    @PostMapping("/enregistrer")
    public String enregistrer(Utilisateur utilisateur) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        utilisateur.setMdp(encoder.encode(utilisateur.getMdp()));
        service.enregistrer(utilisateur);
        return "redirect:/utilisateur";
    }

    @PostMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id,
                            @Param("keyword") String keyword) throws UtilisateurNotFoundException {
        service.supprimer(id);
        return "redirect:/utilisateur?keyword="+(Objects.equals(keyword, "null") ? "":keyword);
    }

    @PostMapping ("/modifier/{id}")
    public String modifier(@PathVariable Long id,
                           @Param("keyword)") String keyword,
                           @RequestParam String nom1,
                           @RequestParam String prenom1,
                           @RequestParam String email1,
                           @RequestParam String mdp1,
                           @RequestParam String telephone1,
                           @RequestParam Utilisateur.Role role1)
            {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(id);
        utilisateur.setNom(nom1);
        utilisateur.setPrenom(prenom1);
        utilisateur.setEmail(email1);
        utilisateur.setMdp(mdp1);
        utilisateur.setTelephone(telephone1);
        utilisateur.setRole(role1);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        utilisateur.setMdp(encoder.encode(utilisateur.getMdp()));
        service.enregistrer(utilisateur);

                return "redirect:/utilisateur?keyword="+keyword;
    }

}
