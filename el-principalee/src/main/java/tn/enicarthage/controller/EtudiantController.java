package tn.enicarthage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tn.enicarthage.auth.AuthenticationRequest;
import tn.enicarthage.model.Etud;
import tn.enicarthage.model.Etudiant;
@RequestMapping("/student")
public interface EtudiantController {
	
	@PostMapping("/login")
	public ResponseEntity<?> loginEtud(@RequestBody AuthenticationRequest etudiantData);
	
	/*@PostMapping("/add")
	public ResponseEntity<String> addNewEtudiant(@RequestBody Map<String,String> requestMap);*/
	
	@PostMapping("/add")
	public Etudiant addNewEtudiant(@RequestBody Etudiant etudiant);
	@GetMapping("/get-all")
	public List<Etudiant> getAllEtudiant();
	
	@PutMapping("/update")
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiant);
	
	@PostMapping("/upload")
	public String uploadFromCsv(@RequestParam("file") MultipartFile file) throws Exception;
}
