package ht.com.grean.gprisonbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "crime")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Crime {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nm_crime")
	private String numeroCrime;
	@Column(name = "violated_law")
	private String ViolatedLaw;
	@Column(name = "jail_time")
	private String jailTime;
	@Column(name = "bail")
	private boolean bail= false;
	@Column(name = "bail_price")
	private double bailPrice;
	@JsonIgnoreProperties({"crimes"})
//	@JsonBackReference(value="crime-prisonnier")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "id_prisonnier", nullable = false)
	private Prisonnier prisonnier;
}
