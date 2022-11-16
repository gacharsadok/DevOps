package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.dto.SecteurDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;

import java.util.List;

public interface ISecteurActiviteService {



	

	void deleteSecteurActivite(Long id);


	 public List<SecteurDTO> retrieveAllSecteurActivite2();
	 public SecteurDTO retrieveSecteurActivite2( Long id);
	 SecteurDTO addANDupdate2( SecteurDTO dto);

}