/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.entities;

/**
 *
 * @author tpc
 */

public class utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private  String email ;
    private  String mdp ;
    private  String adresse ;
    private  int age ;
    private  String genre ;
    

    public utilisateur() {
    }
    public utilisateur( String nom, String prenom , String email , String mdp ,  String adresse ,  int age ,  String genre  ) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp ;
        this.adresse = adresse;
        this.age = age;
        this.genre = genre ;
        
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }



    public utilisateur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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



    @Override
    public String toString() {
        return "utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", adresse=" + adresse + ", age=" + age + ", genre=" + genre + '}';
    }

 
    
}


