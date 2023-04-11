package tn.enicarthage.model;

import java.io.Serializable;
import java.util.Date;

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

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="demande")

public class Demande implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //pour l'auto incrémentation de la cle primaire
	@Column(name="idDemande") 
	private int idDemande;
	
	@Column(name="typeD") 
	@Enumerated(EnumType.STRING) //pour stocker cette valeur ds la BD sous forme de string
	private TypeDemande typeD;
	
	@Column(name="raison") 
	private String raison;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateDemande") 
	private Date dateDemande;
	
	@Column(name="raisonRefus") 
	private String raisonRefus;
	
	@Temporal(TemporalType.DATE) //pour stocker la date ds BD sans timezone
	@Column(name="dateReponse") 
	private Date dateReponse;
	
	
	@Column(name="etat")
	@Enumerated(EnumType.STRING)
	private TypeEtat etat;
	
	// jointure avec etudiant
	@ManyToOne
	@JoinColumn(name = "idEtudiant")
	private Etudiant etudiant;
}
