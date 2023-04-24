package tn.enicarthage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enicarthage.model.Demande;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.model.TypeEtat;


@Repository
public interface DemandeRepo extends JpaRepository<Demande, Integer> {
	
	public Demande findByIdDemande(int idDemande);
	
	//@Query("SELECT d FROM Demande d WHERE d.etat= :etat")
	public List<Demande> findByEtat(TypeEtat etat);
	public List<Demande> findByEtudiant(Etudiant etud);
	
	
	/*@Query("select d from demande d where d.etat='REFUSEE'")
	public List<Demande> findDemandeRefusee();
	
	@Query("select d from demande d where d.etat='FOURNIE'")
	public List<Demande> findDemandeFournie();*/
}
