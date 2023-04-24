package tn.enicarthage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Demande;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.services.DemandeService;


@RestController
public class DemandeControllerImpl implements DemandeController {

	
	@Autowired
	private DemandeService demandeService;
	
	@Override
	public ResponseEntity<?> addNewDemande(Demande demande) {
		
		ResponseEntity<?> d = demandeService.addNewDemande(demande);
		return d;
	}

	@Override
	public List<Demande> getAllDemande() {
		List<Demande> list = demandeService.getAllDemande();
		return list;
	}

	

	@Override
	public List<Demande> getAllDemandeEncours() {
		List<Demande> list = demandeService.getAllDemandeEncours();
		return list;
	}

	@Override
	public List<Demande> getAllDemandeRefusee() {
		List<Demande> list = demandeService.getAllDemandeRefusee();
		return list;
	}

	@Override
	public List<Demande> getAllDemandeFournie() {
		List<Demande> list = demandeService.getAllDemandeFournie();
		return list;
	}


	@Override
	public Demande setEtatDemandeFournie(int idDemande) {
		Demande demande = null;
		demande = demandeService.setDemandeFournie(idDemande);
		return demande;	
	}

	@Override
	public Demande setEtatDemandeRefusee(int idDemande, String raisonRefus) {
		Demande demande = null;
		demande = demandeService.setDemandeRefusee(idDemande,raisonRefus);
		return demande;	
	}

	@Override
	public List<Demande> getDemandeByCin(String cin) {
		Etudiant etud = new Etudiant();
		etud.setCin(cin);
		return demandeService.getDemandeByEtudiant(etud);
	}
	
	}

	
	
	
	


