package ht.com.grean.gprisonbackend.repository;

import ht.com.grean.gprisonbackend.model.Incarceration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncarcerationRepository extends JpaRepository<Incarceration, Integer> {
}
