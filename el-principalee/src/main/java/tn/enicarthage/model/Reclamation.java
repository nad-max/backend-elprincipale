package tn.enicarthage.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="reclamation")

public class Reclamation implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="idReclamation") 
	private int idReclamation;
	
	@Column(name="description") 
	private String description;
	
	@Temporal(TemporalType.DATE) // date d'emission de la reclamation 
	@JsonFormat(pattern ="dd/MM/yyyy",timezone = "Africa/Tunis")
	@Column(name="dateReclamation") 
	private Date dateReclamation;
	
	@Column(name="etatRec")
	@Enumerated(EnumType.STRING)
	private TypeEtat etatRec;
	
	// jointure avec etudiant
	@JsonIgnoreProperties({"reclamations","demandes"}) //elimine la boucle infinie lors de l'appel (get request)
	@ManyToOne
	@JoinColumn(name = "etud_cin",nullable = false)
	private Etudiant etudiant;

}
