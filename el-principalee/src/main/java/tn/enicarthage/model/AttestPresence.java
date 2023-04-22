package tn.enicarthage.model;

import java.io.Serializable;
import java.util.Date;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="attestpresence")
public class AttestPresence  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //pour l'auto incrémentation de la cle primaire
	@Column(name="idattest") 
	private int idAttest;
	
	@Column(name="nom") 
	private String nom;
	
	@Column(name="prenom") 
	private String prenom;
	
	/*@Temporal(TemporalType.DATE)
	@Column(name="dateNaiss") 
	@JsonFormat(pattern ="dd/MM/yyyy")*/
	private String dateNaiss;
	
	@Column(name="cin") //nom de la colonne
	private String cin;
	

	@Column(name="niveau") 
	private int niveau;
	
	@Column(name="parcours") 
	private String parcours;
	
	@Column(name="specialite") 
	private String specialite;
	
	@Column(name="numInsc") 
	private int numInsc;
	
	/*@Temporal(TemporalType.DATE)
	@Column(name="dateAttest") 
	@JsonFormat(pattern ="dd/MM/yyyy")*/
	private String dateAttest;
	
	

}
