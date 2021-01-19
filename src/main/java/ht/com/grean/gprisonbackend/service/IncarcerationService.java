package ht.com.grean.gprisonbackend.service;

import ht.com.grean.gprisonbackend.model.Incarceration;
import ht.com.grean.gprisonbackend.repository.IncarcerationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncarcerationService {

	private IncarcerationRepository incarcerationRepository;

	public IncarcerationService(IncarcerationRepository incarcerationRepository) {
		this.incarcerationRepository = incarcerationRepository;
	}

	public List<Incarceration> listIncarceration (){
		return incarcerationRepository.findAll();
	}

	public Optional<Incarceration> getIncarcerationById (Integer id){
		return incarcerationRepository.findById(id);
	}

	public Integer saveIncarceration(Incarceration incarceration){
//		incarceration.getAgents().forEach(incarceration::addChildAgent);
		incarceration.getPrisonnier().getCrimes().forEach(incarceration.getPrisonnier()::addChildCrime);
		incarceration.getPrisonnier().getAddresses().forEach(incarceration.getPrisonnier()::addChildAddress);
		return (incarcerationRepository.save(incarceration)).getId();
	}
}
