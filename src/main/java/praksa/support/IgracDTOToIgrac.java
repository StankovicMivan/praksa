package praksa.support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import praksa.model.Igrac;
import praksa.service.IgracService;
import praksa.service.KlubService;
import praksa.web.dto.IgracDTO;

@Component
public class IgracDTOToIgrac implements Converter<IgracDTO, Igrac> {

	@Autowired
	private IgracService igracService;
	@Autowired
	private KlubService klubService;
	
	public Igrac convert(IgracDTO dto) {
		Igrac igrac;
		if(dto.getId() == null) {
			igrac = new Igrac();
			igrac.setKlub(klubService.findOne(dto.getKlubId()));
		}else {
			igrac = igracService.findOne(dto.getId());
			igrac.setKlub(klubService.findOne(dto.getKlubId()));
		}
		igrac.setIme(dto.getIme());
		igrac.setPozicija(dto.getPozicija());
		igrac.setPrezime(dto.getPrezime());
		return igrac;
	}

}
