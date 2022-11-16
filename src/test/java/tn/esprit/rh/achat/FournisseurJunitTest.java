/*package tn.esprit.rh.achat;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.IFournisseurService;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@TestMethodOrder(OrderAnnotation.class)


 class FournisseurJunitTest {

	@Autowired
	IFournisseurService f;

	@Autowired
	ISecteurActiviteService s;


	@Test
	@Order(1)
	void all() {
		List<Fournisseur> fournisseurs = f.retrieveAllFournisseurs();
		Assertions.assertEquals(0, fournisseurs.size());
	}

	@Test
	@Order(2)
	void addFournisseur_ok() {
		List<Fournisseur> fournisseurs = f.retrieveAllFournisseurs();
		int currentSize = fournisseurs.size();
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setLibelle("libelle");
		DetailFournisseur detailFournisseur = new DetailFournisseur();
		fournisseur.setDetailFournisseur(detailFournisseur);
		fournisseur.setCode("1234AAA");
		Set<SecteurActivite> secteurActivites = new HashSet<>();
		fournisseur.setSecteurActivites(secteurActivites);
		Set<Facture> factures = new HashSet<>();
		fournisseur.setFactures(factures);
		Fournisseur savedFournisseur = f.addFournisseur(fournisseur);
		assertEquals(currentSize + 1, f.retrieveAllFournisseurs().size());

	}

	@Test
	@Order(3)
	void deleteFournisseur_ok() {
		f.deleteFournisseur(2L);
		Assertions.assertNull(f.retrieveFournisseur(1l));
	}

	@Test
	@Order(4)
	void updateFournisseur_ok() {
		Fournisseur fournisseur = f.retrieveFournisseur(3l);
		String oldCode = fournisseur.getCode();
		String randomCode = UUID.randomUUID().toString();
		fournisseur.setCode(randomCode);
		f.updateFournisseur(fournisseur);
		Fournisseur f2 = f.retrieveFournisseur(3L);
		assertEquals(randomCode, f2.getCode());
		assertNotEquals(oldCode, f2.getCode());
	}

	@Test
	@Order(5)
	 void retriveFournisseur_ok() {
		Fournisseur retrived = f.retrieveFournisseur(3l);
		Assertions.assertEquals(3l, retrived.getIdFournisseur());

	}

	@Test()
	@Order(6)
	@Transactional
	void assignSecteurActiviteToFournisseur() {

		f.assignSecteurActiviteToFournisseur(1l, 3L);
		Fournisseur fourn =f.retrieveFournisseur(3l);
		assertEquals(1, fourn.getSecteurActivites().size());
		assertEquals(1L, Optional.ofNullable(fourn.getSecteurActivites().iterator().next().getIdSecteurActivite()).get().longValue());

	}
}*/
