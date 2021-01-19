package ht.com.grean.gprisonbackend.service;

import ht.com.grean.gprisonbackend.model.Agent;
import ht.com.grean.gprisonbackend.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public List<Agent> listAgents () {
        return agentRepository.findAll();
    }

    public Integer saveAgent (Agent agent) {
        return (agentRepository.save(agent)).getId();
    }

    public Optional<Agent> getAgentById (Integer id){
        return agentRepository.findById(id);
    }

}
