package ht.com.grean.gprisonbackend.controller;

import ht.com.grean.gprisonbackend.model.Agent;
import ht.com.grean.gprisonbackend.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

	private AgentService agentService;

	public AgentController(AgentService agentService) {
		this.agentService = agentService;
	}
	
	@PostMapping(path="/")
	public void saveAgent(HttpServletRequest request, @RequestBody Agent agent){
		agentService.saveAgent(agent);
	}

	@GetMapping(path="/")
	public ResponseEntity<Agent> listAgents(HttpServletRequest request){
		try {
			List<Agent> agents = agentService.listAgents();
			return new ResponseEntity(agents, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Agent> getAgentById(HttpServletRequest request, @PathVariable Integer id){
		try {
			return new ResponseEntity(agentService.getAgentById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
