package tn.enicarthage.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.model.Etudiant;

public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {
	public Etudiant findByEmail(String email);

	public  Optional<Etudiant> findOneByEmailAndPassword(String email, String password);
}