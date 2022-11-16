package tn.esprit.rh.achat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.rh.achat.dto.ConverterSecteur;
import tn.esprit.rh.achat.dto.SecteurDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.List;

@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	

	@Override
	public List<SecteurDTO> retrieveAllSecteurActivite2() {
		List<SecteurActivite> findAll = (List<SecteurActivite>) secteurActiviteRepository.findAll();
		return ConverterSecteur.entityToDto(findAll);
	}

	

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	
	
	
	@Override
	public SecteurDTO retrieveSecteurActivite2( Long id) {
		SecteurActivite orElse = secteurActiviteRepository.findById(id).orElse(null);
		return ConverterSecteur.entityToDto(orElse);
		
	}
	
	@Override
public SecteurDTO addANDupdate2( SecteurDTO dto) {
		
		SecteurActivite secteurActivite = ConverterSecteur.dtoToEntity(dto);
		secteurActivite =  secteurActiviteRepository.save(secteurActivite );
		return ConverterSecteur.entityToDto(secteurActivite );
	}

}