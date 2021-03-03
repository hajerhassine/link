/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author yousra
 */
public class Parking {
    private  int id_parking ,id, nbdeplace ;
    private String adresse ;
    public Parking(){

}

    public Parking(int id_parking, int id, int nbdeplace, String adresse) {
     this.id_parking = id_parking;
     this.id = id;
     this.nbdeplace = nbdeplace;
     this.adresse = adresse;
    }

    public void setId_parking(int id_parking) {
        this.id_parking = id_parking;
    }

    public void setNbdeplace(int nbdeplace) {
        this.nbdeplace = nbdeplace;
    }

    public int getId_parking() {
        return id_parking;
    }

    public int getNbdeplace() {
        return nbdeplace;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id_parking;
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
        final Parking other = (Parking) obj;
        if (this.id_parking != other.id_parking) {
            return false;
        }
        return true;
    }



 public int getId_Parking() {
        return this.id_parking;
    }

    public void setId_Parking(int id_parking) {
        this.id_parking = id_parking;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_de_place() {
        return this.nbdeplace;
    }

    public void setNb_de_place(int nbdeplace) {
        this.nbdeplace = nbdeplace;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Parking{" + "id_parking=" + id_parking + ", id=" + id + ", nbdeplace=" + nbdeplace + ", adresse=" + adresse + '}';
    }


     
}
