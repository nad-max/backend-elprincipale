package tn.enicarthage.services;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import tn.enicarthage.model.Etud;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.repositories.EtudiantRepo;

@Service
public class EtudiantServiceImpl implements EtudiantService{
	@Autowired
	private EtudiantRepo repo;
	
	
	public ResponseEntity<?> loginEtudiant(@RequestBody Etud etudiantData ) {

		// TODO Auto-generated method stub
		
		
		try {
			System.out.println(etudiantData);
			Etudiant etud = repo.findByEmail(etudiantData.getEmail());
			if(etud != null) {
					
					Optional<Etudiant>	etudiant1 = repo.findOneByEmailAndPassword(etudiantData.getEmail(),etudiantData.getPassword());
					
					if (etudiant1.isPresent()) {
						return new ResponseEntity<String>("{\"message\":\"correct login and password\"}",HttpStatus.ACCEPTED);
					}
					else {

						return new ResponseEntity<String>("{\"message\":\"login failed\"}",HttpStatus.INTERNAL_SERVER_ERROR);
					}
			}
			else {
				return new ResponseEntity<String>("{\"message\":\" Email not exits\"}",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("{\"message\":\"something went wrong\"}",HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
	@Override
	public ResponseEntity<String> addNewEtudiant(Map<String, String> requestMap) {
		try {
			if(validateEtudiantMap(requestMap, false)){
				repo.save(getEtudiantFromMap(requestMap,false));
				return new ResponseEntity<String>("{\"message\":\"Etudiant added successfully\"}",HttpStatus.OK);

			}
			return new ResponseEntity<String>("{\"message\":\"invalid data\"}",HttpStatus.BAD_REQUEST);

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("{\"message\":\"something went wrong\"}",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	private boolean validateEtudiantMap(Map<String, String> requestMap, boolean validateId) {
		if(requestMap.containsKey("email")) {
			if(requestMap.containsKey("cin") && validateId) {
				return true;
			}else if(!validateId){
				return true;
			}
		}
		return false;
	}
	private Etudiant getEtudiantFromMap(Map<String, String> requestMap, boolean isAdd) {
		Etudiant etudiant = new Etudiant();
		if(isAdd) {
			etudiant.setCin(Integer.parseInt(requestMap.get("cin")));
		}
		etudiant.setNom(requestMap.get("nom"));
		etudiant.setPrenom(requestMap.get("prenom"));
		etudiant.setNumTel(Integer.parseInt(requestMap.get("numTel")));
		etudiant.setEmail(requestMap.get("email"));
		etudiant.setNumInsc(Integer.parseInt(requestMap.get("numInsc")));
		etudiant.setNiveau(Integer.parseInt(requestMap.get("niveau")));
		etudiant.setSpecialite(requestMap.get("specialite"));
		etudiant.setPassword(requestMap.get("password"));
		etudiant.setGroupe(requestMap.get("groupe"));
		etudiant.setParcours(requestMap.get("parcours"));
		//SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		//etudiant.setDateNaiss(new SimpleDateFormat(requestMap.get("dateNaiss")));
		//etudiant.setDateNaiss(new Date(requestMap.get("dateNaiss")));


		return etudiant;
	}
	
}
