package tn.enicarthage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.enicarthage.auth.AuthenticationRequest;
import tn.enicarthage.auth.AuthenticationResponse;
import tn.enicarthage.model.Etud;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.services.EtudiantService;
@RestController
public class EtudiantControllerImpl implements EtudiantController {
	@Autowired
	private EtudiantService etuService;
	
	public ResponseEntity<AuthenticationResponse> loginEtud(@RequestBody AuthenticationRequest etudiantData){
		
	
				 return ResponseEntity.ok(etuService.loginEtudiant(etudiantData));
				
			

		}
	
	



	@Override
	public Etudiant addNewEtudiant(@RequestBody Etudiant etudiant) {
		Etudiant etud = etuService.addNewEtudServ(etudiant);
		return etud;
	}


	@Override
	public List<Etudiant> getAllEtudiant() {
		// TODO Auto-generated method stub
		List<Etudiant> list = etuService.getAllEtudiant();
		return list;
	}
	@Override
	public Etudiant getEtudiant(String cin) {
		return etuService.getEtudiantByCin(cin);
		
	}


	@Override
	public Etudiant updateEtudiant(Etudiant etud) {
		Etudiant etudMAJ = etuService.updateEtudiant(etud);
		return etudMAJ;
	}


	@Override
	public String uploadFromCsv(MultipartFile file) throws Exception {
		boolean uploadSuccess = etuService.uploadEtudiants(file);
		return "Successful upload";
	}


	@Override
	public String deleteReclamation(String cinEtudiant) {
		String response = etuService.deleteEtudiantById(cinEtudiant);
		return response;
	}
}
