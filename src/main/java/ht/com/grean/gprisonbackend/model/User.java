package ht.com.grean.gprisonbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Entity
@Table (name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	protected Integer id;
	@Column (name = "nm_user")
	protected String name;
	@Column (name = "avatar", columnDefinition = "longblob")
	protected String avatar;
	@Column (name = "birthday")
	protected LocalDateTime birthday;
	@Column (name = "nr_identity", unique = true)
	protected String identity;
	@Column (name = "mother_name")
	protected String motherName;
	@Column (name = "father_name")
	protected String fatherName;
	protected String email;
	@JsonIgnoreProperties({"user"})
//	@JsonManagedReference(value="address-user")
	@OneToMany (mappedBy = "user", targetEntity = Address.class, cascade =CascadeType.ALL)
	private List<Address> addresses;

//	public void setAvatar(String avatar) {
//		try {
////			byte[] name = Base64.getEncoder().encode("hello World".getBytes());
//			byte[] decodedString = Base64.getDecoder().decode(avatar.getBytes("UTF-8"));
//			System.out.println(new String(decodedString));
//			this.avatar = decodedString;
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		this.avatar = avatar.getBytes();
//	}
}
