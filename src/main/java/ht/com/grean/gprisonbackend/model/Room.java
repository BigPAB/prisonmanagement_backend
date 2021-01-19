package ht.com.grean.gprisonbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_room")
	private Integer id;
	@Column(name = "nr_room")
	private String number;
	@Column(name = "complement")
	private String complement;
	@Column(name = "secteur_room")
	private String block;
	@Column(name = "capacite_room")
	private int capacity;
	@JsonIgnoreProperties({"room"})
//	@JsonManagedReference
	@OneToMany (mappedBy = "room", targetEntity = Prisonnier.class, cascade =CascadeType.ALL)
	private List<Prisonnier> prisonniers;

}
