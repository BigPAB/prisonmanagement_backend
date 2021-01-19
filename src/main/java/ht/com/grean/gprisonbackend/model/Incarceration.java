package ht.com.grean.gprisonbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "incarceration")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Incarceration {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_incarceration")
	private Integer id;
	@JsonIgnoreProperties({"incarcerations"})
	@ManyToMany (fetch = FetchType.LAZY, cascade =CascadeType.MERGE)
	@JoinTable
			(
					name = "incarceration_agent",
					joinColumns = {
							@JoinColumn(name = "id_incarceration")
					},
					inverseJoinColumns = {
							@JoinColumn(name = "id_agent")
					}
			)
	private List<Agent> agents;
	@Column(name = "date_incarceration")
	private LocalDateTime date;
	@Column(name = "state_crime")
	private String stateCrime;
	@Column(name = "city_crime")
	private String cityCrime;
	@Column(name = "street_crime")
	private String streetCrime;
	private String complement;
	private String description;
	@JsonIgnoreProperties({"incarcerations"})
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn (name="id_prisonnier")
	private Prisonnier prisonnier;
}
