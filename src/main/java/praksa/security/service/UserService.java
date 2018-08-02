package praksa.security.service;

import praksa.security.model.User;

public interface UserService {
	public void addUser(User user);
	public User findUserByUsername(String username);
}
