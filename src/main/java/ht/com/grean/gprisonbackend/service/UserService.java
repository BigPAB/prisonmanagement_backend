package ht.com.grean.gprisonbackend.service;

import ht.com.grean.gprisonbackend.model.Gestionneur;
import ht.com.grean.gprisonbackend.repository.GestionneurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private GestionneurRepository gestionneurRepository;

    public UserService(GestionneurRepository gestionneurRepository) {
        this.gestionneurRepository = gestionneurRepository;
    }
    
    public Gestionneur loadUserByUsername(String username) {
        Gestionneur user = gestionneurRepository.findByUsername(username);
        return user;
    }

    public List<Gestionneur> listUsers () {
        return gestionneurRepository.findAll();
    }

    public Integer saveUser (Gestionneur user) {
        return (gestionneurRepository.save(user)).getId();
    }

    public Optional<Gestionneur> getUserById (Integer id){
        return gestionneurRepository.findById(id);
    }


}
