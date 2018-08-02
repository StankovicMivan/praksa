package praksa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import praksa.model.Klub;

@Repository
public interface KlubRepository extends JpaRepository<Klub, Long>{

}
