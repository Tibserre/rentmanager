import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;



public class Main {
	public static void main(String[] args){
       
		/*Scanner sc = new Scanner(System.in);
		System.out.println("ID ");
		int id = sc.nextInt(); */
		try {
			System.out.println(VehicleService.getInstance().findAll());
			//long id = 2;
			/*String constructeur = "Peugot";
			int nb_places = 4;
			Vehicle vehicle = new Vehicle (constructeur, nb_places );
			System.out.println(VehicleService.getInstance().create(vehicle)); */
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
