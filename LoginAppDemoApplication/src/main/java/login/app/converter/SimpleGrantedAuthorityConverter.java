package login.app.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Converter
public class SimpleGrantedAuthorityConverter implements AttributeConverter<SimpleGrantedAuthority, String> {

	@Override
	public String convertToDatabaseColumn(SimpleGrantedAuthority authority) {
		//データベース列に変換(Entity→DB)

		return null;

	}

	@Override
	public SimpleGrantedAuthority convertToEntityAttribute(String dbData) {
		// エンティティ属性に変換(Entity←DB)
		
		return null;
	}

}
