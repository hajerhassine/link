/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.sql.Date;

/**
 *
 * @author yousra
 */

public class reservation {
    private  int idrsvparking ,id, id_parking  ;
    private Date  date_d, date_f ;
    public reservation(){

}

 public reservation(int idrsvparking, int id, int id_parking, Date date_d,Date date_f ) {
            this.idrsvparking = idrsvparking;
            this.id = id;
            this.id_parking = id_parking;
            this.date_d = date_d;
             this.date_f = date_f;
    }
 @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.idrsvparking;
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
        final reservation other = (reservation) obj;
        if (this.idrsvparking != other.idrsvparking) {
            return false;
        }
        return true;
    }

    public int getIdrsvparking() {
        return idrsvparking;
    }

    public void setIdrsvparking(int idrsvparking) {
        this.idrsvparking = idrsvparking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_parking() {
        return id_parking;
    }

    public void setId_parking(int id_parking) {
        this.id_parking = id_parking;
    }

    public Date getDate_d() {
        return date_d;
    }

    public void setDate_d(Date date_d) {
        this.date_d = date_d;
    }

    public Date getDate_f() {
        return date_f;
    }

    public void setDate_f(Date date_f) {
        this.date_f = date_f;
    }

    @Override
    public String toString() {
        return "reservation{" + "idrsvparking=" + idrsvparking + ", id=" + id + ", id_parking=" + id_parking + ", date_d=" + date_d + ", date_f=" + date_f + '}';
    }
}
 