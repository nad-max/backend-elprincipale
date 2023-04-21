package tn.enicarthage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.Reclamation;
import tn.enicarthage.services.ReclamationService;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
	@Autowired
	private ReclamationService recService;
	
	@GetMapping("/get-all")
	public List<Reclamation> getAllReclamation(){
		return recService.getAllReclamation();
	}
	@GetMapping("/get/{id}")
	public Reclamation getReclamation(@PathVariable("id") int idRec){
		return recService.getReclamationById(idRec);
	}
	@PostMapping("/add")
	public Reclamation addReclamation(@RequestBody Reclamation rec) {
		recService.addReclamation(rec);
		return rec;
	}
	@PutMapping("/etat/{id}/set/{type}")
	public Reclamation setEtatRec(@PathVariable("id") int idRec,@PathVariable("type") String typeEtat) {
		Reclamation rec = null;
		if (typeEtat.equals("fournie")) {
			rec = recService.setReclamationFournie(idRec);
		}
		else if (typeEtat.equals("refusee")) {
			rec = recService.setReclamationRefusee(idRec);
		}
		return rec;	
	}
	@DeleteMapping("delete/{id}")
	public String deleteReclamation(@PathVariable("id") int idRec) {
		String response = recService.deleteReclamationById(idRec);
		return response;
	}
	
}
