/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLException;
import java.util.List;
import upmatch.entities.materiel;

/**
 *
 * @author Bedis
 */
import javafx.collections.ObservableList;
public interface iservicemateriel {
    public void Addmateriel(materiel t);
    public List<materiel> affichermateriel () throws SQLException;
    public void modifiermateriel(materiel t);
    public void supprimermateriel(materiel t);
    public ObservableList<materiel> getmatList();
    
}