package login.app.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Converter
public class SimpleGrantedAuthorityConverter implements AttributeConverter<SimpleGrantedAuthority, String> {

	@Override
	public String convertToDatabaseColumn(SimpleGrantedAuthority authority) {
		// データベース列に変換(Entity→DB)

		if (authority == null) {
			return "USER";
		}

		String dbData = authority.toString();

		return dbData;

	}

	@Override
	public SimpleGrantedAuthority convertToEntityAttribute(String dbData) {
		// エンティティ属性に変換(Entity←DB)

//		System.out.println("dbData:" + dbData);

		if (dbData == null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
			return authority;
		}

		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(dbData);

		return authority;
	}

}
