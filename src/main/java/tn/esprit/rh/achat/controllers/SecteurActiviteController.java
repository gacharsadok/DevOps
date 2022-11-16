package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.rh.achat.dto.SecteurDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import java.util.List;

@RestController
@Api(tags = "Gestion des secteurs activites")
@RequestMapping("/secteurActivite")
@CrossOrigin("*")
public class SecteurActiviteController {

	@Autowired
	ISecteurActiviteService secteurActiviteService;
	
	
	@GetMapping("/retrieve-all-secteurActivite")
	@ResponseBody
	public List<SecteurDTO> getSecteurActivite() {
		List<SecteurDTO> list = secteurActiviteService.retrieveAllSecteurActivite2();
		return list;
	}

	
	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public SecteurDTO retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite2(secteurActiviteId);
	}


	@PostMapping("/add-secteurActivite")
	@ResponseBody
	public SecteurDTO addSecteurActivite(@RequestBody SecteurDTO sa) {
		SecteurDTO secteurActivite = secteurActiviteService.addANDupdate2(sa);
		return secteurActivite;
	}

	
	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
	}

	
	@PutMapping("/modify-secteurActivite")
	@ResponseBody
	public SecteurDTO modifySecteurActivite(@RequestBody SecteurDTO secteurActivite) {
		return secteurActiviteService.addANDupdate2(secteurActivite);
	}

	
}