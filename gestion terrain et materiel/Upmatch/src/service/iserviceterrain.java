/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLException;
import java.util.List;
import upmatch.entities.terrain;

/**
 *
 * @author Bedis
 */
import javafx.collections.ObservableList;
public interface iserviceterrain {
    public void Addterrain(terrain t);
    public List<terrain> afficherterrain () throws SQLException;
    public void modifierterrain(terrain t);
    public void supprimerterrain(terrain t);
    public ObservableList<terrain> getterList();
    
}
