package ht.com.grean.gprisonbackend.repository;

import ht.com.grean.gprisonbackend.model.Gestionneur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionneurRepository extends JpaRepository<Gestionneur, Integer> {
    Gestionneur findByUsername(String username);
}
