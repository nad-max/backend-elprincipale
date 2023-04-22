package tn.enicarthage.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="etudiant")
public class Etudiant implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cin") //nom de la colonne
	private String cin;
	
	@Column(name="nom") 
	private String nom;
	
	@Column(name="prenom") 
	private String prenom;
	
	@Column(name="numTel") 
	private int numTel;
	
	@Column(name="email") 
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateNaiss") 
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dateNaiss;
	
	@Column(name="numInsc") 
	private int numInsc;
	
	@Column(name="niveau") 
	private int niveau;
	
	@Column(name="specialite") 
	private String specialite;
	
	@Column(name="password") 
	private String password;
	
	@Column(name="groupe") 
	private String groupe;
	
	@Column(name="parcours") 
	private String parcours;
	
	// jointure avec demande
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,mappedBy ="etudiant", fetch = FetchType.LAZY)
	private List<Demande> demandes;
		
	// jointure avec reclamation
	@OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true ,mappedBy ="etudiant", fetch = FetchType.LAZY )
	private List<Reclamation> reclamations;

}
