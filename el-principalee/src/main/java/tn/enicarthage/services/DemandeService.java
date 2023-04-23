package tn.enicarthage.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import tn.enicarthage.model.Demande;




public interface DemandeService {
	
	public ResponseEntity<?> addNewDemande(@RequestBody Demande demande);
	public List<Demande> getAllDemande();
	public List<Demande> getAllDemandeEncours();
	public List<Demande> getAllDemandeRefusee();
	public List<Demande> getAllDemandeFournie();
	public Demande setDemandeFournie(int idDemande);
	public Demande setDemandeRefusee(int idDemande, String raisonRefus);
}
