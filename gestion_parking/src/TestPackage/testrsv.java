
package TestPackage;


import Entites.reservation;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import service.ServiceReservation;


/**
 *
 * @author yousra
 */
public class testrsv {
        public static void main(String[] args) throws ParseException{
            Date d= (Date) new SimpleDateFormat("dd/MM/yyyy").parse("01/09/1997");
                        ServiceReservation ServiceReservation = new ServiceReservation();
                        reservation  rs = new reservation(2, 8, 7, d,d);
                        ServiceReservation.Addreservation(rs);
    }
}
            
        
    

