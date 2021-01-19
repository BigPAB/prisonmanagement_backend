package ht.com.grean.gprisonbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "gestionneur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gestionneur extends User {

	@Column(unique = true)
	private String username;
	private String password;
	
}
