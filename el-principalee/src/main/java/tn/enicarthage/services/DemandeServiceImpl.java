package tn.enicarthage.services;

import java.util.Date;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import tn.enicarthage.model.Demande;


import tn.enicarthage.model.TypeEtat;
import tn.enicarthage.repositories.DemandeRepo;

@Slf4j
@Service
public class DemandeServiceImpl implements DemandeService {	
	/*@Autowired
	private EtudiantRepo etudiantRepo; */
	
	@Autowired
	private DemandeRepo demandeRepo;
	
	@Override
	public ResponseEntity<?> addNewDemande(@RequestBody Demande demande) {
		
		
		
		/*Etudiant e = new Etudiant();
		e.setCin(demande.getEtudiant().getCin());*/
		
	
		log.info("Service: Demande addNewDemandeServ(): "+ demande.toString());
		
		
		//Etudiant etudiant = etudiantRepo.findByCin(demande.getEtudiant().getCin());
		//System.out.println(demande.getEtudiant().getCin());
		demande.setEtat(TypeEtat.ENCOURS);
		//SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
		demande.setDateDemande(new Date());
	
      //demande.setEtudiant(demande.getEtudiant().getCin());
		
		demandeRepo.save(demande);
		return new ResponseEntity<>("{\"message\":\"demande ajoutée avec succés\"}",HttpStatus.ACCEPTED);
	}
	
	@Override
	public List<Demande> getAllDemande() {
		log.info("Service: Demande getAllDemande()");
		System.out.println("findAll demande ");
		return demandeRepo.findAll();
	}


	@Override
	public List<Demande> getAllDemandeEncours() {
	
		return demandeRepo.findByEtat(TypeEtat.ENCOURS);
	}

	@Override
	public List<Demande> getAllDemandeRefusee() {
		return demandeRepo.findByEtat(TypeEtat.REFUSEE);
	}

	@Override
	public List<Demande> getAllDemandeFournie() {
		return demandeRepo.findByEtat(TypeEtat.FOURNIE);
	}

	@Override
	public Demande setDemandeFournie(int idDemande) {
		Demande d = demandeRepo.findByIdDemande(idDemande);
		if(d !=null) {
			d.setEtat(TypeEtat.FOURNIE);
			d.setDateReponse(new Date());
			demandeRepo.save(d);
			return d;
		}
		
		return  null;
	}

	
	@Override
	public Demande setDemandeRefusee(int idDemande, String raisonRefus) {
		Demande d = demandeRepo.findByIdDemande(idDemande);
		
		if(d != null) {
			d.setRaisonRefus(raisonRefus);
			d.setEtat(TypeEtat.REFUSEE);
			d.setDateReponse(new Date());
			demandeRepo.save(d);
			log.info("Service: Demande updateDemandeRefus(): Demande màj");
			return d;
		}
		return null;
		
	}
	

}
