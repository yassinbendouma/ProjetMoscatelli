package fr.hellocorp.projetmoscatelli.admin.outil;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/outils")
public class OutilsController {

    @Autowired
    private OutilService service;

    @GetMapping(value = {"/recherche",""})
    public String ShowTools(Model model, @Param("keyword") String keyword,@Param("etalonnee") boolean etalonnee) {
        List<Outil> outils = service.findAll(keyword, etalonnee);
        model.addAttribute("Outils",outils);
        Outil outil = new Outil();
        model.addAttribute("Outil",outil);
        model.addAttribute("url","/outils");
        model.addAttribute("etalonnee", etalonnee);
        model.addAttribute("keyword", keyword);

        return "outils";
    }

    @PostMapping("/enregistrer")
    public String enregistrer(Outil outil,
                              @Param("etalonnee") boolean etalonnee) {
        outil.setEtalonnee(etalonnee);
        service.enregistrer(outil);

        return "redirect:/outils?etalonnee="+etalonnee;
    }

    @PostMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id,
                            @Param("etalonnee") boolean etalonnee,
                            @Param("keyword") String keyword) throws OutilNotFoundException {
        service.supprimer(id);

        return "redirect:/outils?keyword="+(Objects.equals(keyword, "null") ? "":keyword) +"&etalonnee="+etalonnee;
    }

    @PostMapping ("/modifier/{id}")
    public String modifier(@PathVariable Long id,
                           @Param("keyword)") String keyword,
                           @Param("etalonnee)") boolean etalonnee,
                           @RequestParam String designation,
                           @RequestParam String fournisseur,
                           @RequestParam String marque,
                           @RequestParam String modele,
                           @RequestParam String numero_de_serie,
                           @RequestParam String capacite,
                           @RequestParam String puissance,
                           @RequestParam String repere,
                           @RequestParam String etat,
                           @RequestParam Outil.TypeStatut typeStatut,
                           @RequestParam String periodicite) {

        Outil outil = new Outil();
        outil.setId(id);
        outil.setDesignation(designation);
        outil.setFournisseur(fournisseur);
        outil.setMarque(marque);
        outil.setModele(modele);
        outil.setNumero_de_serie(numero_de_serie);
        outil.setCapacite(capacite);
        outil.setPuissance(puissance);
        outil.setRepere(repere);
        outil.setEtat(etat);
        outil.setTypeStatut(Outil.TypeStatut.valueOf(String.valueOf(typeStatut)));
        outil.setPeriodicite(periodicite);
        outil.setEtalonnee(etalonnee);

        service.enregistrer(outil);

        return "redirect:/outils?keyword="+(Objects.equals(keyword, "null") ? "":keyword) +"&etalonnee="+etalonnee;
    }



}