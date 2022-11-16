package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




@Service
@Slf4j
@Transactional
public class FournisseurServiceImpl implements IFournisseurService {
	private static final Logger l = LogManager.getLogger(Fournisseur.class);

	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;



	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {

		l.info("In Method retrieveAllFournisseurs :");
		List<Fournisseur> fournisseurs = null;
			fournisseurs = fournisseurRepository.findAll();

		l.info("out of Method retrieveAllFournisseurs with succes");
		return fournisseurs;
	}

	public Fournisseur addFournisseur(Fournisseur f /*Master*/) {
		l.info("In Method addFournisseurs :");
		DetailFournisseur df= new DetailFournisseur();//Slave
		df.setDateDebutCollaboration(new Date()); //util
		//On affecte le "Slave" au "Master"
		f.setDetailFournisseur(df);
		fournisseurRepository.save(f);
		l.info("out of Method addFournisseurs with succes");

		return f;
	}

	private DetailFournisseur  saveDetailFournisseur(Fournisseur f){
		l.info("In Method detailFournisseurs :");
		DetailFournisseur df = f.getDetailFournisseur();
		detailFournisseurRepository.save(df);
		l.info("out of Method detaillFournisseurs with succes");
		return df;
	}

	public Fournisseur updateFournisseur(Fournisseur f) {
		l.info("In Method updateFournisseurs :");
		DetailFournisseur df = saveDetailFournisseur(f);
		f.setDetailFournisseur(df);
		fournisseurRepository.save(f);
		l.info("out of Method updateFournisseurs with succes");
		return f;
	}

	@Override
	public void deleteFournisseur(Long fournisseurId) {
		l.info("In Method retrieveAllFournisseurs :");
			fournisseurRepository.deleteById(fournisseurId);
		l.info("out of Method retrieveAllFournisseurs with succes");
	}

	@Override
	public Fournisseur retrieveFournisseur(Long fournisseurId) {
		l.info("In Method retrieveAllFournisseurs :");
		Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElse(null);
		l.info("out of Method retrieveFournisseurs with succes");
		return fournisseur;
	}

	@Override

	public void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur) {
		l.info("In Method assignFournisseurs :");


			Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
			SecteurActivite secteurActivite = secteurActiviteRepository.findById(idSecteurActivite).orElse(null);
			fournisseur.getSecteurActivites().add(secteurActivite);
			fournisseurRepository.save(fournisseur);
		l.info("out of Method assignFournisseurs with succes");
	}






}