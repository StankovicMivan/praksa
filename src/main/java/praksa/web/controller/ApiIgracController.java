package praksa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import praksa.model.Igrac;
import praksa.service.IgracService;
import praksa.support.IgracDTOToIgrac;
import praksa.support.IgracToIgracDTO;
import praksa.web.dto.IgracDTO;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api/igraci")
public class ApiIgracController {

	@Autowired
	private IgracService igracService;
	
	@Autowired
	private IgracToIgracDTO toDTO;
	@Autowired
	private IgracDTOToIgrac toIgrac;
	
	//find all
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IgracDTO>> getAll(
												@RequestParam(required = false) Long klubid,
												@RequestParam(required = false) String ime,
												@RequestParam(required = false) String prezime,
												@RequestParam(required = false) String pozicija,
												@RequestParam(defaultValue = "4") int pPoStrani,
												@RequestParam(defaultValue = "0") int pageNum) {

		Page<Igrac> igraci;
		
		if (klubid != null || ime != null || prezime != null || pozicija != null) {
			igraci = igracService.pretraga(klubid, ime,prezime,pozicija,pPoStrani, pageNum);
		} else {
			igraci = igracService.findAll(pageNum, pPoStrani);
		}
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(igraci.getTotalPages()));
		return new ResponseEntity<>(toDTO.convert(igraci.getContent()), headers, HttpStatus.OK);
	}
	//find one
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<IgracDTO> get(@PathVariable Long id) {
		Igrac igrac = igracService.findOne(id);

		if (igrac == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(igrac), HttpStatus.OK);
	}
	//dodaj novog
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<IgracDTO> add(@RequestBody IgracDTO noviIgrac){
		
		Igrac igrac = toIgrac.convert(noviIgrac); 
		
		igracService.save(igrac);
		
		return new ResponseEntity<>(toDTO.convert(igrac), HttpStatus.CREATED);
	}
	//izmeni
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public ResponseEntity<IgracDTO> edit(
			@PathVariable Long id,
			@RequestBody IgracDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Igrac igrac = toIgrac.convert(izmenjen); 
		igracService.save(igrac);
		
		return new ResponseEntity<>(toDTO.convert(igrac),
				HttpStatus.OK);
	}
	// brisanje
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<IgracDTO> delete(@PathVariable Long id){
		igracService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<Void> validationHandler(DataIntegrityViolationException e){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
