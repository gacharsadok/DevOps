package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OperateurServiceImplMock {

    @Mock
    OperateurRepository operateurRepository;
    @InjectMocks
    OperateurServiceImpl StI;

    Operateur operateur = new Operateur(1000, "op1", "operateur1");
    List<Operateur> listOperateur = new ArrayList<Operateur>() {
        {
            add(new Operateur(1101, "op2", "operateur2"));
            add(new Operateur(111, "missaoui", "sana"));
            add(new Operateur(1102, "op3", "operateur3"));
        }
    };


    @Test
    void retrieveOperateur() {
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
        Operateur operateur1 = StI.retrieveOperateur(0L);
        Assertions.assertNotNull(operateur1);
    }

    @Test
    void retrieveAllOperateurs() {
        Mockito.when(operateurRepository.findAll()).thenReturn(listOperateur);
        List<Operateur> list = StI.retrieveAllOperateurs();
        Assertions.assertNotNull(list);
    }
}