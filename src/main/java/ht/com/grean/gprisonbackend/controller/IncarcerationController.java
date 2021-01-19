package ht.com.grean.gprisonbackend.controller;

import ht.com.grean.gprisonbackend.model.Incarceration;
import ht.com.grean.gprisonbackend.model.Prisonnier;
import ht.com.grean.gprisonbackend.service.IncarcerationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/incarceration")
public class IncarcerationController {

	private IncarcerationService incarcerationService;

	public IncarcerationController(IncarcerationService incarcerationService) {
		this.incarcerationService = incarcerationService;
	}

	@PostMapping("/")
	public ResponseEntity<Integer> saveIncarceration(HttpServletRequest request, @RequestBody Incarceration incarceration){
		try {
			return new ResponseEntity(incarcerationService.saveIncarceration(incarceration), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path="/")
	public ResponseEntity<Incarceration> listIncarceration(HttpServletRequest request){
		try {
			List<Incarceration> incarcerations = incarcerationService.listIncarceration();
			return new ResponseEntity(incarcerations, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Incarceration> getIncarcerationById(HttpServletRequest request, @PathVariable Integer id){
		try {
			return new ResponseEntity(incarcerationService.getIncarcerationById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
