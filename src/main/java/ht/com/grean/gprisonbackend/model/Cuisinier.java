package ht.com.grean.gprisonbackend.model;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cuisinier")
@Builder
public class Cuisinier extends User {
}
