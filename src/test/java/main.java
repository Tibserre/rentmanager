import com.EPF.rentmanager.AppTest;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Reservation;

public class main {
	public static void main(String[] args)  {

		AppTest appTest = new AppTest ();
		
	try {
		appTest.testReservation();
		System.out.println("Tout est ok");
		
	} catch (DaoException e) {
		System.out.println("Oups");
		e.printStackTrace();
	}
}
	}
