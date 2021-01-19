package ht.com.grean.gprisonbackend.controller;

import ht.com.grean.gprisonbackend.model.Gestionneur;
import ht.com.grean.gprisonbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class GestionneurController {

	private UserService userService;

	public GestionneurController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(path="/")
	public void saveUser(HttpServletRequest request, @RequestBody Gestionneur user){
		userService.saveUser(user);
	}

	@GetMapping(path="/")
	public ResponseEntity<Gestionneur> listUsers(HttpServletRequest request){
		try {
			return new ResponseEntity(userService.listUsers(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Gestionneur> getUserById(HttpServletRequest request, @PathVariable Integer id){
		try {
			return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path="/by-username")
	public ResponseEntity<Gestionneur> getUserByUsername(HttpServletRequest request, @RequestParam String username){
		try {
			return new ResponseEntity(userService.loadUserByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
