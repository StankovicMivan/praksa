package praksa.security.service.user;


import java.util.Collection;
import java.util.Optional;

import praksa.security.domain.User;
import praksa.security.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
