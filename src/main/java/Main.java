import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;



public class Main {
	public static void main(String[] args){
       
		/*Scanner sc = new Scanner(System.in);
		System.out.println("ID ");
		int id = sc.nextInt(); */
		try {
			System.out.println(ClientService.getInstance().findAll());
			//int id = 4;
			//System.out.println(ClientService.getInstance().findById(id));
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
