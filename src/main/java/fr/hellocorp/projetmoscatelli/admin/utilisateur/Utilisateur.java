package fr.hellocorp.projetmoscatelli.admin.utilisateur;

import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utilisateurs",
        indexes = {
                @Index(columnList = "nom"),
                @Index(columnList = "prenom"),
                @Index(columnList = "email", unique = true),
                @Index(columnList = "role"),
                @Index(columnList = "nom, prenom")})
public class Utilisateur {

    public enum Role {
        Administrateur, Magasinier, Visiteur
    }

    //////////////////////////////////////// DECLARATIONS DES VARIABLES ////////////////////////////////////////
    @Id // Clé de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 70)
    private String nom;

    @Column(nullable = false, length = 70)
    private String prenom;

    @Column(nullable = false, length = 70)
    private String email;

    @Column(nullable = false)
    private String mdp;

    @Column( length = 20)
    private String telephone;

    @Column(nullable = false, length = 20)
    private Role role;

    @Column( length = 70 )
    private String utilisateur_creation;

    @Column(name="date_creation", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime date_creation;

    @Column( length = 70)
    private String utilisateur_maj;

    @Column(name="date_maj" , columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDateTime date_maj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Set<EntreeSortie> utilisateur = new HashSet<>();

    //////////////////////////////////////// DECLARATIONS DES CONSTRUCTEURS ////////////////////////////////////////

    public Utilisateur(Long id, String nom, String prenom, String email, String mdp, String telephone, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.telephone = telephone;
        this.role = role;
    }

    public Utilisateur(String nom, String prenom, String email, String mdp, String telephone, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.telephone = telephone;
        this.role = role;
    }

    public Utilisateur() {
    }
    //////////////////////////////////////// DECLARATIONS DES GETTERS AND SETTERS ////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUtilisateur_creation() {
        return utilisateur_creation;
    }

    public void setUtilisateur_creation(String utilisateur_creation) {
        this.utilisateur_creation = utilisateur_creation;
    }

    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

    public String getUtilisateur_maj() {
        return utilisateur_maj;
    }

    public void setUtilisateur_maj(String utilisateur_maj) {
        this.utilisateur_maj = utilisateur_maj;
    }

    public LocalDateTime getDate_maj() {
        return date_maj;
    }

    public void setDate_maj(LocalDateTime date_maj) {
        this.date_maj = date_maj;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", telephone='" + telephone + '\'' +
                ", role=" + role +
                ", utilisateur_creation='" + utilisateur_creation + '\'' +
                ", date_creation=" + date_creation +
                ", utilisateur_maj='" + utilisateur_maj + '\'' +
                ", date_maj=" + date_maj +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
