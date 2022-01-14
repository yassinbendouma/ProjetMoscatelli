package fr.hellocorp.projetmoscatelli.admin.entree_sortie;

import fr.hellocorp.projetmoscatelli.admin.outil.Outil;
import fr.hellocorp.projetmoscatelli.admin.utilisateur.Utilisateur;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="entrees_sorties",
        indexes = {
                @Index(columnList = "id_utilisateur"),
                @Index(columnList = "id_outil"),
                @Index(columnList = "date_sortie"),
                @Index(columnList = "date_de_retour_prevue")})
public class EntreeSortie {
    //////////////////////////////////////// DECLARATIONS DES VARIABLES ////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_outil")
    private Outil outil;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_sortie;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_de_retour_prevue;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_retour;

    @Column(length = 255)
    private String probleme;

    @Column(length = 255)
    private String referencePV;

    @Column(name = "utilisateur_creation", length = 70, columnDefinition = "VARCHAR(20) DEFAULT 'root'")
    private String utilisateurcreation;

    @Column(name="date_creation", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime dateCreation;

    @Column(name = "utilisateur_maj", length = 70, columnDefinition = "VARCHAR(20) DEFAULT 'root'")
    private String utilisateurMAJ;

    @Column(name = "date_maj", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime dateMaj;

    //////////////////////////////////////// DECLARATIONS DES CONSTRUCTEURS ////////////////////////////////////////

    public EntreeSortie(Long id, Utilisateur utilisateur, Outil outil, LocalDate date_sortie, LocalDate date_de_retour_prevue, LocalDate date_retour, String probleme, String referencePV) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.outil = outil;
        this.date_sortie = date_sortie;
        this.date_de_retour_prevue = date_de_retour_prevue;
        this.date_retour = date_retour;
        this.probleme = probleme;
        this.referencePV = referencePV;
    }
    public EntreeSortie(Utilisateur utilisateur, Outil outil, LocalDate date_sortie, LocalDate date_de_retour_prevue, LocalDate date_retour, String probleme, String referencePV) {
        this.utilisateur = utilisateur;
        this.outil = outil;
        this.date_sortie = date_sortie;
        this.date_de_retour_prevue = date_de_retour_prevue;
        this.date_retour = date_retour;
        this.probleme = probleme;
        this.referencePV = referencePV;
    }
    public EntreeSortie() {
    }
    //////////////////////////////////////// DECLARATIONS DES GETTERS AND SETTERS ////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur id_utilisateur) {
        this.utilisateur = id_utilisateur;
    }

    public Outil getOutil() {
        return outil;
    }

    public void setOutil(Outil id_outil) {
        this.outil = id_outil;
    }

    public LocalDate getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(LocalDate date_sortie) {
        this.date_sortie = date_sortie;
    }

    public LocalDate getDate_de_retour_prevue() {
        return date_de_retour_prevue;
    }

    public void setDate_de_retour_prevue(LocalDate date_de_retour_prevue) {
        this.date_de_retour_prevue = date_de_retour_prevue;
    }

    public LocalDate getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(LocalDate date_retour) {
        this.date_retour = date_retour;
    }

    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public String getReferencePV() {
        return referencePV;
    }

    public void setReferencePV(String referencePV) {
        this.referencePV = referencePV;
    }

    public String getUtilisateurcreation() {
        return utilisateurcreation;
    }

    public void setUtilisateurcreation(String utilisateurcreation) {
        this.utilisateurcreation = utilisateurcreation;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getUtilisateurMAJ() {
        return utilisateurMAJ;
    }

    public void setUtilisateurMAJ(String utilisateurMAJ) {
        this.utilisateurMAJ = utilisateurMAJ;
    }

    public LocalDateTime getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(LocalDateTime dateMaj) {
        this.dateMaj = dateMaj;
    }

    @Override
    public String toString() {
        return "EntreeSortie{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", outil=" + outil +
                ", date_sortie=" + date_sortie +
                ", date_de_retour_prevue=" + date_de_retour_prevue +
                ", date_retour=" + date_retour +
                ", probleme='" + probleme + '\'' +
                ", referencePV='" + referencePV + '\'' +
                ", utilisateurcreation='" + utilisateurcreation + '\'' +
                ", dateCreation=" + dateCreation +
                ", utilisateurMAJ='" + utilisateurMAJ + '\'' +
                ", dateMaj=" + dateMaj +
                '}';
    }

}




