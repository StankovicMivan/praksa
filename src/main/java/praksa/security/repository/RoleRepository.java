package praksa.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import praksa.security.domain.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long>{

}
