import business.concretes.UserManager;
import core.concretes.GoogleRegisterManagerAdapter;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		
				
		UserManager userManager=new UserManager(new InMemoryUserDao(),new GoogleRegisterManagerAdapter());		
		
			
		
		User Serpil=new User(001,"Serpil", "Yuksel", "styuksel@gmail.com", "12245" );
		User Ahmet=new User(002,"Ahmet","Yuksel","ahmet@gmail.com","1222222");
		userManager.register(Serpil);
		userManager.register(Ahmet);
		userManager.login("ahmet@gmail.com","1222222");
	}
	

}
