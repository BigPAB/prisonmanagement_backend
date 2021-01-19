package ht.com.grean.gprisonbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agent extends User {
	@Column (name = "badge_number", unique = true)
	private String badgeNumber;
	@JsonIgnoreProperties({"agents"})
	@ManyToMany(mappedBy = "agents", fetch = FetchType.LAZY)
	private List<Incarceration> incarcerations;
	
}
