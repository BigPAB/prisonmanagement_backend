package ht.com.grean.gprisonbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "juridic_case")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JuridicCase {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_case")
	private Integer id;
	@Column(name = "case_number")
	private String numero;
	@Column(name = "tribunal_name")
	private String tribunalName;
	@OneToOne (mappedBy = "juridicCase", targetEntity = Judge.class, cascade =CascadeType.ALL)
	private Judge jugde;
	@Column(name = "identite_prisonnier")
	private String identiteDetenue;
	@Column(name = "verdict_case")
	private String verdict;
	@OneToOne @JoinColumn (name = "id_prisonnier")
	private Prisonnier prisonnier;
}
