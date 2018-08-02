package praksa.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import praksa.security.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
