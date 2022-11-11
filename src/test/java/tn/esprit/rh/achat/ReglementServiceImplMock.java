package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ReglementServiceImplMock {

    @Mock
    ReglementRepository reglementRepository;
    @InjectMocks
    ReglementServiceImpl StI;

    Reglement reglement = new Reglement(900, 700);
    List<Reglement> listReglement = new ArrayList<Reglement>() {
        {
            add(new Reglement(400, 200));
            add(new Reglement(800, 600));
        }
    };


    @Test
    void retrieveReglement() {
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
        Reglement reglement1 = StI.retrieveReglements(0L);
        Assertions.assertNotNull(reglement1);
    }

    @Test
    void retrieveAllReglements() {
        Mockito.when(reglementRepository.findAll()).thenReturn(listReglement);
        List<Reglement> list = StI.retrieveAllReglement();
        Assertions.assertNotNull(list);
    }
}