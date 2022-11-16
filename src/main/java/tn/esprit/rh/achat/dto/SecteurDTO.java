package tn.esprit.rh.achat.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SecteurDTO {
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	public SecteurDTO(Long idSecteurActivite, String codeSecteurActivite, String libelleSecteurActivite) {
		super();
		this.idSecteurActivite = idSecteurActivite;
		this.codeSecteurActivite = codeSecteurActivite;
		this.libelleSecteurActivite = libelleSecteurActivite;
	}
	public SecteurDTO() {
		super();
	
	}
	
}
