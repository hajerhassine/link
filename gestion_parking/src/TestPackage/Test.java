package TestPackage;


import Entites.Parking;
import service.ServiceParking;

/* for test */
public class Test {
    public static void main(String[] args){
            ServiceParking serviceParking = new ServiceParking();
            Parking p = new Parking(10, 5, 10, "gofmflaa");
            serviceParking.AddParking(p);
    }
}
