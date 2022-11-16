
package tn.esprit.rh.achat.dto;
import tn.esprit.rh.achat.entities.CategorieFournisseur;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class FournisseurDTO {
    private Long idFournisseur;
    private String code;
    private String libelle;
    @Enumerated(EnumType.STRING)
    private CategorieFournisseur categorieFournisseur;
}
