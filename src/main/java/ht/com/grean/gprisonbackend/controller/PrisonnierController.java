package ht.com.grean.gprisonbackend.controller;

import ht.com.grean.gprisonbackend.model.Prisonnier;
import ht.com.grean.gprisonbackend.service.PrisonnierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/prisonnier")
public class PrisonnierController {

	private PrisonnierService prisonnierService;

	public PrisonnierController (PrisonnierService prisonnierService) {
		this.prisonnierService = prisonnierService;
	}

	@PostMapping("/")
	public ResponseEntity<Integer> savePrisonnier(HttpServletRequest request, @RequestBody Prisonnier prisonnier){
		try {
			return new ResponseEntity(prisonnierService.savePrisonnier(prisonnier), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path="/")
	public ResponseEntity<Prisonnier> listPrisonnier(HttpServletRequest request){
		try {
			return new ResponseEntity(prisonnierService.listPrisonnier(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Prisonnier> getPrisonnierById(HttpServletRequest request, @PathVariable Integer id){
		try {
			return new ResponseEntity(prisonnierService.getPrisonnierById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
