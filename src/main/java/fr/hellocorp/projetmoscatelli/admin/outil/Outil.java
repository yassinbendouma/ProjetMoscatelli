package fr.hellocorp.projetmoscatelli.admin.outil;

import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "outil",
        indexes = {
                @Index(columnList = "designation"),
                @Index(columnList = "marque"),
                @Index(columnList = "modele"),
                @Index(columnList = "numero_de_serie", unique = true),
                @Index(columnList = "typeStatut"),
                @Index(columnList = "designation, marque, modele")})
public class Outil {

    public enum TypeStatut{
       Fonction, Rebut, Manquant, Maintenance, Etalonnage
    }
    //////////////////////////////////////// DECLARATIONS DES VARIABLES ////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 100)
    private String designation;

    @Column(length = 100)
    private String fournisseur ;

    @Column(nullable = false,length = 100)
    private String marque;

    @Column(length = 100)
    private String modele;

    @Column(unique = true,length = 100)
    private String numero_de_serie;

    @Column(length = 30)
    private String capacite;

    @Column(length = 30)
    private String puissance;

    @Column(length = 30)
    private String repere;

    @Column
    private String etat;

    @Column( nullable = false, length = 30)
    private TypeStatut typeStatut;

    @Column(length = 30)
    private String periodicite;

    @Column(name = "disponibilite", columnDefinition = "BOOLEAN DEFAULT true")
    private boolean disponibilite;

    @Column(name = "etalonnee", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean etalonnee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "outil")
    private Set<EntreeSortie> outil = new HashSet<>();

    @Column( length = 70 )
    private String utilisateur_creation;

    @Column(name="date_creation", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP" )
    private LocalDateTime date_creation;

    @Column( length = 70)
    private String utilisateur_maj;

    @Column(name="date_maj", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDateTime date_maj;
    //////////////////////////////////////// DECLARATIONS DES CONSTRUCTEURS ////////////////////////////////////////

    public Outil(long id, String designation, String fournisseur, String marque, String modele, String numero_de_serie, String capacite, String puissance, String repere, String etat, TypeStatut typeStatut, String periodicite, boolean disponibilite, boolean etalonnee, Set<EntreeSortie> outil) {
        this.id = id;
        this.designation = designation;
        this.fournisseur = fournisseur;
        this.marque = marque;
        this.modele = modele;
        this.numero_de_serie = numero_de_serie;
        this.capacite = capacite;
        this.puissance = puissance;
        this.repere = repere;
        this.etat = etat;
        this.typeStatut = typeStatut;
        this.periodicite = periodicite;
        this.disponibilite = disponibilite;
        this.etalonnee = etalonnee;
        this.outil = outil;
    }

    public Outil(String designation, String fournisseur, String marque, String modele, String numero_de_serie, String capacite, String puissance, String repere, String etat, TypeStatut typeStatut, String periodicite, boolean disponibilite, boolean etalonnee, Set<EntreeSortie> outil) {
        this.designation = designation;
        this.fournisseur = fournisseur;
        this.marque = marque;
        this.modele = modele;
        this.numero_de_serie = numero_de_serie;
        this.capacite = capacite;
        this.puissance = puissance;
        this.repere = repere;
        this.etat = etat;
        this.typeStatut = typeStatut;
        this.periodicite = periodicite;
        this.disponibilite = disponibilite;
        this.etalonnee = etalonnee;
        this.outil = outil;
    }
    public Outil() {
    }
    //////////////////////////////////////// DECLARATIONS DES GETTERS AND SETTERS ////////////////////////////////////////


    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getNumero_de_serie() {
        return numero_de_serie;
    }

    public void setNumero_de_serie(String numero_de_serie) {
        this.numero_de_serie = numero_de_serie;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getRepere() {
        return repere;
    }

    public void setRepere(String repere) {
        this.repere = repere;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public TypeStatut getTypeStatut() {
        return typeStatut;
    }

    public void setTypeStatut(TypeStatut typeStatut) {
        this.typeStatut = typeStatut;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
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


    public Set<EntreeSortie> getOutil() {
        return outil;
    }

    public void setOutil(Set<EntreeSortie> outil) {
        this.outil = outil;
    }

    public boolean isEtalonnee() {
        return etalonnee;
    }

    public void setEtalonnee(boolean etalonnee) {
        this.etalonnee = etalonnee;
    }

    //////////////////////////////////////// DECLARATIONS methode to string ////////////////////////////////////////

    @Override
    public String toString() {
        return "Outil{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", fournisseur='" + fournisseur + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", numero_de_serie='" + numero_de_serie + '\'' +
                ", capacite='" + capacite + '\'' +
                ", puissance='" + puissance + '\'' +
                ", repere='" + repere + '\'' +
                ", etat='" + etat + '\'' +
                ", typeStatut=" + typeStatut +
                ", periodicite='" + periodicite + '\'' +
                ", disponibilite=" + disponibilite +
                ", etalonnee=" + etalonnee +
                ", outil=" + outil +
                ", utilisateur_creation='" + utilisateur_creation + '\'' +
                ", date_creation=" + date_creation +
                ", utilisateur_maj='" + utilisateur_maj + '\'' +
                ", date_maj=" + date_maj +
                '}';
    }
}
