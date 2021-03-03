/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Tournoi;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Hajer
 */
public interface IServiceTournoi {
     public void AjouterTournoi(Tournoi t);
    public List<Tournoi> AfficherTournoi()  throws SQLException;
    public void ModifierTournoi(Tournoi t);
    public void SupprimerTournoi(Tournoi t);
}
    

