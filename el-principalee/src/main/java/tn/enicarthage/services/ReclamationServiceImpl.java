package tn.enicarthage.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enicarthage.model.Reclamation;
import tn.enicarthage.model.TypeEtat;
import tn.enicarthage.repositories.ReclamationRepo;
@Slf4j
@Service
public class ReclamationServiceImpl implements ReclamationService{
	@Autowired
	ReclamationRepo repo;
	@Override
	public Reclamation addReclamation(Reclamation rec) {
		log.info("addReclamation: "+rec.toString());
		rec.setEtatRec(TypeEtat.ENCOURS);
		rec.setDateReclamation(new Date());
		repo.save(rec);
		return rec;
	}

	@Override
	public Reclamation getReclamationById(int idRec) {
		Reclamation r = repo.findById(idRec);
		return r;
	}

	@Override
	public List<Reclamation> getAllReclamation() {
		return repo.findAll();
	}

	@Override
	public Reclamation setReclamationFournie(int idRec) {
		Reclamation r = repo.findById(idRec);
		if(r != null) {
		r.setEtatRec(TypeEtat.FOURNIE);
		repo.save(r);
		return r;
		}
		return null;
	}

	@Override
	public Reclamation setReclamationRefusee(int idRec) {
		Reclamation r = repo.findById(idRec);
		if(r != null) {
		r.setEtatRec(TypeEtat.REFUSEE);
		repo.save(r);
		return r;
		}
		return null;
	}

	@Override
	public String deleteReclamationById(int idRec) {
		repo.deleteById(idRec);
		return "Reclamation n°"+idRec+" supprimée";
	}

}
