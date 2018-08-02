package praksa.service;



import java.util.List;

import praksa.model.Klub;

public interface KlubService {

	
	Klub findOne(Long id);
	Klub save(Klub klub);
	void remove(Long id);
	List<Klub> findAll();
}
