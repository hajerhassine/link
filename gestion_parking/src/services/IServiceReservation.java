
package services;

import Entites.reservation;
import java.sql.SQLException;
import java.util.List;

public interface IServiceReservation {
     public void Addreservation (reservation  rs);
    public List<reservation> AfficherParking()  throws SQLException;
    public void Modifierreservation(reservation  rs);
    public void Supprimerreservation(reservation  rs);
}
    

