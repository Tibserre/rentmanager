import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.rentmanager.configuration.AppConfiguration;
import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;



public class Main {
	public static void main(String[] args) throws DaoException{
       
		
	
		/*Scanner sc = new Scanner(System.in);
		System.out.println("ID ");
		int id = sc.nextInt(); */
	
		
		/*File file = new File("C:\\Users\\tibse\\RentManagerDatabase.mv.db");
		
		if (file.exists()) {
            boolean bval = file.setReadable(true,false);
            System.out.println("set the every user Read permission: "+ bval);
        } else {
            System.out.println("File cannot exists: ");
        }
		
		 if (file.exists()) {
	            boolean bval = file.setWritable(true,false);
	            System.out.println("set the every user write permission: "+ bval);
	        } else {
	            System.out.println("File cannot exists: ");
	        } 
		 if (file.exists()) {
	            boolean bval = file.setExecutable(true,false);
	            System.out.println("set the every user Exec permission: "+ bval);
	        } else {
	            System.out.println("File cannot exists: ");
	        } 
	if(file.canRead()&&file.canWrite()&&file.canExecute()) {
		 System.out.println("Write & read & exec ok");
	}*/
			ApplicationContext context = new
					AnnotationConfigApplicationContext(AppConfiguration.class);
					ClientService clientService = context.getBean(ClientService.class);
					VehicleService vehicleService = context.getBean(VehicleService.class);
					ReservationService reservationService = context.getBean(ReservationService.class);
					
					
				try {
					System.out.println("resas");
					System.out.println(reservationService.findAll());
					System.out.println("iencli");
					System.out.println(clientService.findAll());
					System.out.println("titines");
					System.out.println(vehicleService.findAll());
					Scanner sc = new Scanner(System.in);
					System.out.println("ID Client");
					int IdClient = sc.nextInt();
					
					System.out.println(reservationService.findResaByClientId(IdClient));
					/*Scanner sc = new Scanner(System.in);
					System.out.println("ID Client");
					int IdClient = sc.nextInt();
					System.out.println("ID Vehicle");
					int IdVehicle = sc.nextInt();
					System.out.println("Date Début JJ/MM/YYYY");
					String debut = sc.next();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					LocalDate dDebut = LocalDate.parse(debut, formatter);
					
					System.out.println("Date Fin JJ/MM/YYYY");
					String fin = sc.next();
					LocalDate dFin = LocalDate.parse(fin, formatter);
					
					Reservation reservation = new Reservation (dDebut, dFin, IdClient, IdVehicle );
					
					System.out.println(reservationService.create(reservation));
					System.out.println(reservationService.findAll());
					System.out.println(reservationService.delete(reservation));
					System.out.println(reservationService.findAll()); */
					
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			
			
			//System.out.println(vehicleService);
			//long id = 2;
			/*String constructeur = "Peugot";
			int nb_places = 4;
			Vehicle vehicle = new Vehicle (constructeur, nb_places );
			System.out.println(VehicleService.getInstance().create(vehicle)); */
		
		
    	/*Scanner sc = new Scanner(System.in);

		System.out.println("Prenom ");
		String name = sc.nextLine();
		System.out.println("Nom ");
		String lastName = sc.nextLine();
		System.out.println("Date de naissance JJ/MM/AAAA");
		String birthdate = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate dBirthdate = LocalDate.parse(birthdate, formatter);
		System.out.println("mail ");
		String mail = sc.nextLine();
		
		
		Client nouveauClient = new Client(name,lastName, dBirthdate, mail);
		
		try {
			System.out.println(ClientService.getInstance().create(nouveauClient));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    
   
	}
	
 
}
