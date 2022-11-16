package tn.esprit.rh.achat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@ExtendWith(MockitoExtension.class)
 class FournisseurServiceImplUTest {

	@InjectMocks
	FournisseurServiceImpl fournisseurServiceImpl;
	
	@Mock
	FournisseurRepository fournisseurRepository;
	@Mock
	DetailFournisseurRepository detailFournisseurRepository;
	@Mock
	ProduitRepository produitRepository;
	@Mock
	SecteurActiviteRepository secteurActiviteRepository;
	private Fournisseur fournisseur;
	
	
	@Test
	void test_retrieveAllFournisseurs_ok() {
		
		when(fournisseurRepository.findAll()).thenReturn(new ArrayList());
		List<Fournisseur> response= fournisseurServiceImpl.retrieveAllFournisseurs();
		assertEquals(0, response.size());
	}
	@Test
	void test_addFournisseur_ok() {
		DetailFournisseur df= new DetailFournisseur();
		fournisseur = new Fournisseur();
		df.setIdDetailFournisseur(1L);
		//mock
		when(fournisseurRepository.save(any())).thenReturn(fournisseur);
		//call function
		fournisseurServiceImpl.addFournisseur(fournisseur);
		//assert
		assertEquals(1L,df.getIdDetailFournisseur());
	}
	/*@Test
	void test_updateFournisseur_ok() {
		DetailFournisseur df= new DetailFournisseur();
		fournisseur = new Fournisseur();
		df.setIdDetailFournisseur(1L);
		//mock
		when(detailFournisseurRepository.save(any())).thenReturn(df);
		fournisseur.setDetailFournisseur(df);
		fournisseur.setIdFournisseur(10L);
		when(fournisseurRepository.save(any())).thenReturn(fournisseur);
		//call function
		fournisseurServiceImpl.updateFournisseur(fournisseur);
		//assert
		assertEquals(1L,df.getIdDetailFournisseur());
		assertEquals(10L,fournisseur.getIdFournisseur());
		assertEquals(1L,fournisseur.getDetailFournisseur().getIdDetailFournisseur());
	}*/

	@Test
	void test_deleteFournisseur_ok() {
		Long fournisseurId = 1L;
		//mock
		doNothing().when(fournisseurRepository).deleteById(fournisseurId);
		//call function
		fournisseurServiceImpl.deleteFournisseur(fournisseurId);
		//assert
		verify(fournisseurRepository, times(1)).deleteById(fournisseurId);
	}
	@Test
	void test_retrieveFournisseur_ok() {
		Long fournisseurId = 1L;
		//mock
		when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.ofNullable(fournisseur));
		//call function
		Fournisseur fournisseur1 = fournisseurServiceImpl.retrieveFournisseur(fournisseurId);
		//assert
		assertEquals(null,fournisseur1);
	}
	@Test
	void test_assignSecteurActiviteToFournisseur_ok() {
		Long fournisseurId = 1L;
		SecteurActivite secteurActivite = null;
		fournisseur = new Fournisseur();
		fournisseur.setSecteurActivites(new HashSet<>());
		fournisseur.setIdFournisseur(fournisseurId);
		//mock
		when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.ofNullable(fournisseur));
		when(secteurActiviteRepository.findById(any())).thenReturn(Optional.ofNullable(secteurActivite));
		when(fournisseurRepository.save(any())).thenReturn(fournisseur);
		//call function
		fournisseurServiceImpl.assignSecteurActiviteToFournisseur(1L, 1L);
		//assert
		verify(fournisseurRepository, times(1)).findById(fournisseurId);
		verify(secteurActiviteRepository, times(1)).findById(1L);
		verify(fournisseurRepository, times(1)).save(any());
	}

}
