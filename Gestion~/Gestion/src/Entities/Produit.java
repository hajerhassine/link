/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Produit {
    private int id_produit , id ,prix,quantitie ;
    private String nom_produit, description;

    public Produit() {
    }

    public Produit(int id_produit, int id, String nom_produit, int prix , int quantitie, String description) {
        this.id_produit = id_produit;
        this.id = id;
        this.prix = prix;
        this.quantitie=quantitie;
        this.nom_produit = nom_produit;
        this.description = description;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantitie() {
        return quantitie;
    }

    public void setQuantitie(int quantite) {
        this.quantitie = quantite;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id_produit != other.id_produit) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (this.quantitie != other.quantitie) {
            return false;
        }
        if (!Objects.equals(this.nom_produit, other.nom_produit)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
}
