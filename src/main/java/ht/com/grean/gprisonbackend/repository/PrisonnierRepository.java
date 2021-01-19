package ht.com.grean.gprisonbackend.repository;

import ht.com.grean.gprisonbackend.model.Prisonnier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrisonnierRepository extends JpaRepository<Prisonnier, Integer> {
}
