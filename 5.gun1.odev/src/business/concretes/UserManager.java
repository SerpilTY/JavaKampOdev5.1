package business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.abstracts.RegisterService;
import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	private List<String> eMailList= new ArrayList<String>();
	private List<String> passwordList=new ArrayList<String>(); 
	
	
	private UserDao userDao;
	private RegisterService registerService;
	
	public UserManager(UserDao userDao, RegisterService registerService) {
		
		super();
		this.userDao=userDao;
		this.registerService=registerService;
		
	}
	
	
	
	public static boolean isEmailValid(String eMail) {
		
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		
		final Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(eMail);
		
		return matcher.matches();
	};
	
	public static boolean isEmailValidOnClick(String eMail) {
		
		return true;
	}
	
	
	
	

	@Override
	public void register(User user) {
		
		//password check
		
		if (user.getPassword().length()<6 || user.getPassword()==null) {
			
			System.out.println("The password field cannot be less than 6 characters or empty. "+user.getName());
			return;
		}
		
		
		//no email repeat check
		
		if( eMailList.contains(user.geteMail())  ) {
			
			System.out.println("The e-mail address you entered has been used before.");
			return;			
		}
		
			
		
		//email regex check
		
		if(!isEmailValid(user.geteMail())  ) {
			System.out.println("There are unwanted characters in the email address you entered.");
			return;
			
		}
		
		
		//name&surname > 2 chars check
		
		if(user.getName().length()<3 || user.getSurname().length()<3) {
			
			System.out.println("Name and surname fields must be greater than 2 characters.");
			
			return;}
			else {
				
				System.out.println("A verification link has been sent to your address. Check it out."+user.geteMail() );
			}
		
		
		
		// isEmailValidOnClick Check
		
		if (isEmailValidOnClick(user.geteMail()) ) { 
			
			System.out.println("Your registiration completed successfully.");
			 eMailList.add(user.geteMail());
			 passwordList.add(user.getPassword());
			 this.userDao.add(user);
			 this.registerService.registerToSystem(null);
			
		}
		
		else {
			
			System.out.println("Please check your email and validate your account.");
		}
		
	}

	@Override
	public void login(String eMail, String password) {
		
		if(eMailList.contains(eMail) && passwordList.contains(password))
		{
			System.out.println("Logged in successfully.");
			return;
		}
		
		else {
			System.out.println("Your email or password is wrong. Please check them out.");
			
		}
		
		}
		
	}

	
	
	

