/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author Hajer
 */
public class Tournoi {
        private int id_tournoi;
    private String nom;
    private String type;
  public Tournoi(){
          
    }

    public Tournoi(int id_tournoi,  String nom, String type) {
        this.id_tournoi = id_tournoi;
        this.nom = nom;
        this.type = type;
        
    }

    public int getId_tournoi() {
        return id_tournoi;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tournoi{" + "id_tournoi=" + id_tournoi + ", nom=" + nom + ", type=" + type + '}';
    }
    
}
