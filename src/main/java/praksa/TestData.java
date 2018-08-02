package praksa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import praksa.model.Igrac;
import praksa.model.Klub;
import praksa.service.IgracService;
import praksa.service.KlubService;



@Component
public class TestData {


	 @Autowired
	 private IgracService igracService;
	
	 @Autowired
	 private KlubService klubService;
	
//	 @Autowired
//	 private UserService userService;
//	 @Autowired
//	 private RoleService roleService;
//	 
	@PostConstruct
	public void init() {

	
		Klub k1 = new Klub();
		k1.setNaziv("Klub 1");	
		klubService.save(k1);
		
		Klub k2 = new Klub();
		k2.setNaziv("Klub 2");	
		klubService.save(k2);
		
		for(int i =0; i<10; i++) {
			Igrac i1 = new Igrac();
			i1.setIme("Ime " +i);
			if(i<5) {
				i1.setKlub(k1);
			}else {
				i1.setKlub(k2);				
			}
			i1.setPozicija("Pozicija " + i);
			i1.setPrezime("Prezime " +i);	
			igracService.save(i1);
		}


	}
}
