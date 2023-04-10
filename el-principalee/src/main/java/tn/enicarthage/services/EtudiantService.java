package tn.enicarthage.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import tn.enicarthage.model.Etud;
import tn.enicarthage.model.Etudiant;

public interface EtudiantService {
	public ResponseEntity<?> loginEtudiant(@RequestBody Etud etudiantData);
	//ResponseEntity<String> addNewEtudiant(Map<String,String> requestMap);
	public Etudiant addNewEtudServ(Etudiant etudiant);
	public List<Etudiant> getAllEtudiant();
	public Etudiant updateEtudiant(Etudiant etudiant);
}
