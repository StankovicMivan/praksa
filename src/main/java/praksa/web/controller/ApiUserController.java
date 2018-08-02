//package praksa.web.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import praksa.model.Igrac;
//import praksa.security.model.User;
//import praksa.security.service.UserService;
//import praksa.service.IgracService;
//import praksa.support.IgracDTOToIgrac;
//import praksa.support.IgracToIgracDTO;
//import praksa.web.dto.IgracDTO;
//
//@RestController
//@RequestMapping("api/users")
//public class ApiUserController {
//
//	@Autowired
//	private UserService userService;
//	
//
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<Void> getAll(
//			@RequestParam(required = true) String username,
//			@RequestParam(required = true) String password) {
//
//		User user = userService.findUserByUsernameAndPassword(username, password);
//
//		if(user == null) {
//			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
//		}
//
//			
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
//
//}
