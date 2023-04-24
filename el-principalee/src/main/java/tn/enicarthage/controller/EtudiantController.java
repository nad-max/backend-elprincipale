package tn.enicarthage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tn.enicarthage.auth.AuthenticationRequest;
import tn.enicarthage.model.Etud;
import tn.enicarthage.model.Etudiant;
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
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
	@GetMapping("/get/{cin}")
	public Etudiant getEtudiant(@PathVariable("cin")String cin);
	
	@PutMapping("/update")
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiant);
	
	@PostMapping("/upload")
	public String uploadFromCsv(@RequestParam("file") MultipartFile file) throws Exception;
	
	@DeleteMapping("delete/{id}")
	public String deleteReclamation(@PathVariable("id") String cinEtudiant);
}
