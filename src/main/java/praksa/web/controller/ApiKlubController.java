package praksa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import praksa.model.Klub;
import praksa.service.KlubService;
import praksa.support.KlubToKlubDTO;
import praksa.web.dto.KlubDTO;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api/klubovi")
public class ApiKlubController {
	@Autowired
	private KlubService klubService;
	
	@Autowired
	private KlubToKlubDTO toDTO;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KlubDTO>> getAll() {

		List<Klub> klubovi;

		klubovi = klubService.findAll();
		
		return new ResponseEntity<>(toDTO.convert(klubovi),  HttpStatus.OK);
	}
}
