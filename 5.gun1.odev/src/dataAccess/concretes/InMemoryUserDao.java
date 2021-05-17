package dataAccess.concretes;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("User added to system successfully. " + user.getName() +" "+user.getSurname());
		
	}

	@Override
	public void update(User user) {
		System.out.println("User updated successfully. " + user.getName() +" "+user.getSurname());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("User deleted from system successfully. " + user.getName() +" "+user.getSurname());
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
