package ht.com.grean.gprisonbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "country")
	private String country;
	@Column(name = "department")
	private String department;
	@Column(name = "city")
	private String city;
	@Column(name = "street")
	private String street;
	@Column(name = "number")
	private String number;
	@JsonIgnoreProperties({"addresses"})
//	@JsonBackReference(value="address-user")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "id_user")
	private User user;
}
