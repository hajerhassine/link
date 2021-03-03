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
public class Match {
    
    private int id_match;
    private String type;
    private String date;
    private int nbjoueurs;
 
    public Match(){
          
    }

    public Match(int id_match,  String type, String date, int nbjoueurs) {
        this.id_match = id_match;
        this.type = type;
        this.date = date;
        this.nbjoueurs = nbjoueurs;
    }
   

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public int getId_match() {
        return id_match;
    }

    public void setDate(String date) {
        this.date = date;
    }



    
    public void setNbjoueurs(int nbjoueurs) {
        this.nbjoueurs = nbjoueurs;
    }

   

    public void setType(String type) {
        this.type = type;
    }

    public int getNbjoueurs() {
        return nbjoueurs;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Match{" + "id_match=" + id_match +  ", type=" + type + ", date=" + date + ", nbjoueurs=" + nbjoueurs + '}';
    }



  
   
  

    
    
}

    

