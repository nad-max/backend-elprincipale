package tn.enicarthage.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.enicarthage.model.Reclamation;

public interface ReclamationRepo extends CrudRepository<Reclamation, Integer> {
	public Reclamation findById(int idRec); 
	public List<Reclamation> findAll();
}
