package praksa.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import praksa.security.model.User;
import praksa.security.repository.UserRepository;
import praksa.security.service.UserService;
@Service
@Transactional
public class JpaUserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public void addUser(User user) {
		
		userRepository.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

}
