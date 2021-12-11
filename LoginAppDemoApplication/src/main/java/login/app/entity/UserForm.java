package login.app.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import login.app.converter.SimpleGrantedAuthorityConverter;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity(name = "User")
@Table(name = "user_tb")
public class UserForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
//	private String authority;
		
    @Convert(converter = SimpleGrantedAuthorityConverter.class)
	private SimpleGrantedAuthority authority;
}