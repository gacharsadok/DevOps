package tn.esprit.rh.achat.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tn.esprit.rh.achat.entities.SecteurActivite;

@Component
public class ConverterSecteur {
	
//
public static SecteurDTO entityToDto(SecteurActivite secteurActivite) {
		
	SecteurDTO dto = new SecteurDTO();

		dto.setCodeSecteurActivite(secteurActivite.getCodeSecteurActivite());
 	dto.setIdSecteurActivite(secteurActivite.getIdSecteurActivite());
	dto.setLibelleSecteurActivite(secteurActivite.getLibelleSecteurActivite());

		return dto;
		
	
	}
	public static  List<SecteurDTO> entityToDto(List<SecteurActivite> secteurActivite) {
		
		return	secteurActivite.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
		
	}
	
	
	public static SecteurActivite dtoToEntity(SecteurDTO dto)
	{
	SecteurActivite st = new SecteurActivite();
	st.setCodeSecteurActivite(dto.getCodeSecteurActivite());
 st.setIdSecteurActivite(dto.getIdSecteurActivite());
 st.setLibelleSecteurActivite(dto.getLibelleSecteurActivite());
		return st;
		
	}
	
	public List<SecteurActivite> dtoToEntity(List<SecteurDTO> dto)
	{

		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
