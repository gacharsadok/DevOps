package tn.esprit.rh.achat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.SecteurActivite;

import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
 class MokitoSecteur {
	
	@Mock
	SecteurActiviteRepository secteurActiviteRepository;
	@InjectMocks
	  SecteurActiviteServiceImpl sect;
	   SecteurActivite sa = new SecteurActivite("code1", "libelle1");
	    List <SecteurActivite> listSec = new ArrayList<SecteurActivite>() {
	        {
	            add(new SecteurActivite ("code2","libelle2"));
	            add(new SecteurActivite ("code3","libelle3"));
	           
	        }
	    };
	
	
	   @Test
		void retrieveAllSecteurActivite() {
	    	Mockito.when(secteurActiviteRepository.findAll()).thenReturn(listSec);
	        List<SecteurActivite> list = sect.retrieveAllSecteurActivite();
	        Assertions.assertNotNull(list);
		}
		    

	    @Test
	    void retrieveSecteurActivite() {
	        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(sa));
	        SecteurActivite sa1 = sect.retrieveSecteurActivite(0L);
	        Assertions.assertNotNull(sa1);
	    }
}
