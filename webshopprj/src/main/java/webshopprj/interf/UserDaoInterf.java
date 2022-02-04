package webshopprj.interf;

import java.util.List;

import webshopprj.entity.User;

public interface UserDaoInterf {

	void add(User prod);
	void update(User prod);
	User get(String id);
	List<User> getAll();
	void deleteAll();
	int getCount();
}
