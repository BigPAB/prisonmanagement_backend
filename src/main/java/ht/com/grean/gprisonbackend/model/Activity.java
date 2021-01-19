package ht.com.grean.gprisonbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "activity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column (name = "nm_activity")
	private String nome;
	@Column (name = "duration_activity")
	private String duration;
	@Column (name = "desc_activity")
	private String descricao;
	@OneToOne @JoinColumn (name = "id_user")
	private Prisonnier prisonnier;
	
}
