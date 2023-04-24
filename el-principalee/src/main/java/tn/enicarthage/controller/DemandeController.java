package tn.enicarthage.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.enicarthage.model.Demande;
import tn.enicarthage.model.Etudiant;


@CrossOrigin
@RequestMapping("/demande")
public interface DemandeController {
	
	@PostMapping("/add")
	public ResponseEntity<?> addNewDemande(@RequestBody Demande demande);
	
	@GetMapping("/get-all")
	public List<Demande> getAllDemande();
	

	@GetMapping("/get-all-encours")
	public List<Demande> getAllDemandeEncours();
	
	@GetMapping("/get-all-refusee")
	public List<Demande> getAllDemandeRefusee();
	
	@GetMapping("/get-all-fournie")
	public List<Demande> getAllDemandeFournie();
	
	@GetMapping("/get/{cin}")
	public List<Demande> getDemandeByCin(@PathVariable("cin") String cin);
	@PutMapping("/etat/{id}")
	public Demande setEtatDemandeFournie(@PathVariable("id") int idDemande); 
	
	@PutMapping("/etat/{id}/set/{raison}")
	public Demande setEtatDemandeRefusee(@PathVariable("id") int idDemande, @PathVariable("raison") String raisonRefus );
	
	

}
