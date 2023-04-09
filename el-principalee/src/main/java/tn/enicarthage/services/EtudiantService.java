package tn.enicarthage.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import tn.enicarthage.model.Etud;

public interface EtudiantService {
	public ResponseEntity<?> loginEtudiant(@RequestBody Etud etudiantData);
	ResponseEntity<String> addNewEtudiant(Map<String,String> requestMap);
}
