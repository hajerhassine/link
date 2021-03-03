/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Categorie;
import Entities.Produit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IServicesProduit {
    public void AddProduit (Produit p);
        public List<Produit> AfficherProduit()  throws SQLException;
    public void ModifierProduit(Produit p);
    public void SupprimerProduit(Produit p);
    
}
