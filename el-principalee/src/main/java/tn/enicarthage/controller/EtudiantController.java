package tn.enicarthage.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.enicarthage.model.Etud;
@RequestMapping("/student")
public interface EtudiantController {
	
	@PostMapping("/login")
	public ResponseEntity<?> loginE(@RequestBody Etud etudiantData);
	
	@PostMapping("/add")
	public ResponseEntity<String> addNewEtudiant(@RequestBody Map<String,String> requestMap);
}
