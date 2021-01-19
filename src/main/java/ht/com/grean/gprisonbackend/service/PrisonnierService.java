package ht.com.grean.gprisonbackend.service;

import ht.com.grean.gprisonbackend.model.Prisonnier;
import ht.com.grean.gprisonbackend.repository.PrisonnierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrisonnierService {

	private PrisonnierRepository prisonnierRepository;

	public PrisonnierService (PrisonnierRepository prisonnierRepository) {
		this.prisonnierRepository = prisonnierRepository;
	}

	public List<Prisonnier> listPrisonnier (){
		return prisonnierRepository.findAll();
	}

	public Optional<Prisonnier> getPrisonnierById (Integer id){
		return prisonnierRepository.findById(id);
	}
	public Integer savePrisonnier(Prisonnier prisonnier){
		prisonnier.getCrimes().forEach(prisonnier::addChildCrime);
		prisonnier.getAddresses().forEach(prisonnier::addChildAddress);
		return (prisonnierRepository.save(prisonnier)).getId();
	}

}
