package core.concretes;

import Google.GoogleRegisterManager;
import core.abstracts.RegisterService;


public class GoogleRegisterManagerAdapter implements RegisterService{

		
	@Override
	public void registerToSystem(String message) {
		
		GoogleRegisterManager googleManager= new GoogleRegisterManager();
		googleManager.send(message);
		
		
	}

}
