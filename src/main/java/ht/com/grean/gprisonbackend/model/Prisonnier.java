package ht.com.grean.gprisonbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
@Table(name = "prisonnier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prisonnier extends User {
	@Column (name = "metier_prisonnier")
	private String profession;
	@JsonIgnoreProperties({"prisonniers"})
//	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "id_room")
	private Room room;
	@JsonIgnoreProperties({"prisonnier"})
//	@JsonManagedReference(value="crime-prisonnier")
	@OneToMany (mappedBy = "prisonnier", targetEntity = Crime.class, cascade =CascadeType.ALL)
	private List<Crime> crimes;
	@JsonIgnoreProperties({"prisonnier"})
//	@JsonManagedReference(value="prisonnier-incarceration")
	@OneToMany (mappedBy = "prisonnier", targetEntity = Incarceration.class, cascade =CascadeType.ALL)
	private List<Incarceration> incarcerations;
	@OneToOne (mappedBy = "prisonnier", targetEntity = JuridicCase.class, cascade =CascadeType.ALL)
	private JuridicCase juridicCase;
	@OneToOne (mappedBy = "prisonnier", targetEntity = Activity.class, cascade =CascadeType.ALL)
	private Activity activity;

	public void addChildCrime(Crime child) {
		child.setPrisonnier(this);
	}

	public void addChildAddress(Address child) {
		child.setUser(this);
	}

}