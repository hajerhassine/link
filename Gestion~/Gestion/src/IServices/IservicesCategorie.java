/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Categorie;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IservicesCategorie {
    public void AddCategorie (Categorie c);
    public List<Categorie> AfficherCategorie()  throws SQLException;
    public void ModifierCategorie(Categorie c);
    public void SupprimerCategorie(Categorie c);
    
}
