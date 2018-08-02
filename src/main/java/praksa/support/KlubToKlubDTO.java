package praksa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import praksa.model.Klub;
import praksa.web.dto.KlubDTO;

@Component
public class KlubToKlubDTO implements Converter<Klub, KlubDTO> {

	public KlubDTO convert(Klub klub) {

		KlubDTO dto = new KlubDTO();
		dto.setId(klub.getId());
		dto.setNaziv(klub.getNaziv());
		return dto;

	}

	public List<KlubDTO> convert(List<Klub> klubovi) {
		
		List<KlubDTO> retVal = new ArrayList<KlubDTO>();
		for (Klub it : klubovi) {
			retVal.add(convert(it));
		}
		return retVal;
	}

}
