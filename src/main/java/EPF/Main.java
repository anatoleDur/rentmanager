package EPF;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.rentmanager.config.AppConfiguration;
import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

public class Main {
	public static void main(String[] arg) {
//		try {

		///////////////// TEST CLIENT/////////////////////

//			LocalDate localDate = LocalDate.of(2016, 8, 19);
//			Client clientTest = new Client("test", "test", "test", localDate);
//			
//			ClientService.getInstance().create(clientTest);
//			
//			ClientService.getInstance().delete(5);
//			
//			System.out.println(ClientService.getInstance().findById(5));
////			
//			System.out.println(ClientService.getInstance().findAll());

		////////////////// TEST VEHICLE//////////////////////

//			Vehicle vehicleTest = new Vehicle("test", 4);
//			VehicleService.getInstance().count();
//
//			VehicleService.getInstance().create(vehicleTest);
//
//			VehicleService.getInstance().delete(5);
//
//			System.out.println(VehicleService.getInstance().findById(4));
//
//			System.out.println(VehicleService.getInstance().findAll());

		////////////////// TEST RESERVATION//////////////////////

//			LocalDate debut = LocalDate.of(2016, 8, 19);
//			LocalDate fin = LocalDate.of(2016, 8, 20);
//			Reservation reservationTest = new Reservation(2,2,debut,fin);

//			ReservationService.getInstance().count();
//
//			ReservationService.getInstance().create(reservationTest);
//
//			ReservationService.getInstance().delete(1);
//
//			System.out.println(ReservationService.getInstance().findResaByIdClient(2));
//			System.out.println(ReservationService.getInstance().findResaByIdVehicle(2));

//			System.out.println(ReservationService.getInstance().findAll());
//
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		ClientService clientService = context.getBean(ClientService.class);
		VehicleService vehicleService = context.getBean(VehicleService.class);
	}

}
