package tn.enicarthage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Etud;
import tn.enicarthage.services.EtudiantService;
@RestController
public class EtudiantControllerImpl implements EtudiantController {
	@Autowired
	private EtudiantService etuService;
	
	public ResponseEntity<?> loginE(@RequestBody Etud etudiantData){
		
		//public ResponseEntity<String> loginEtudiant(Map<String, String>  request){
		   
			try {
				 return etuService.loginEtudiant(etudiantData);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			//return new ResponseEntity<String>("{\"message\":\"something went wrong\"}",HttpStatus.INTERNAL_SERVER_ERROR);
			return(ResponseEntity<?>) ResponseEntity.internalServerError();

		}
	
	
	@Override
	public ResponseEntity<String> addNewEtudiant(Map<String, String> requestMap) {
		try {
			return etuService.addNewEtudiant(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("{\"message\":\"something went wrong\"}",HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
