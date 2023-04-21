package tn.enicarthage.services;

import java.util.List;

import tn.enicarthage.model.Reclamation;

public interface ReclamationService {
	public Reclamation addReclamation(Reclamation rec);
	public Reclamation getReclamationById(int idRec);
	public List<Reclamation> getAllReclamation();
	public Reclamation setReclamationFournie(int idRec);
	public Reclamation setReclamationRefusee(int idRec);
	public String deleteReclamationById(int idRec);
}
