package tn.enicarthage.services;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import lombok.extern.slf4j.Slf4j;
import tn.enicarthage.model.Etud;
import tn.enicarthage.model.Etudiant;
import tn.enicarthage.repositories.EtudiantRepo;

@Slf4j
@Service
public class EtudiantServiceImpl implements EtudiantService{
	@Autowired
	private EtudiantRepo repo;
	
	
	public ResponseEntity<?> loginEtudiant(@RequestBody Etud etudiantData ) {

		// TODO Auto-generated method stub
		
		
		try {
			System.out.println(etudiantData);
			Etudiant etud = repo.findByEmail(etudiantData.getEmail());
			if(etud != null) {
					
					Optional<Etudiant>	etudiant1 = repo.findOneByEmailAndPassword(etudiantData.getEmail(),etudiantData.getPassword());
					
					if (etudiant1.isPresent()) {
						return new ResponseEntity<String>("{\"message\":\"correct login and password\"}",HttpStatus.ACCEPTED);
					}
					else {

						return new ResponseEntity<String>("{\"message\":\"login failed\"}",HttpStatus.INTERNAL_SERVER_ERROR);
					}
			}
			else {
				return new ResponseEntity<String>("{\"message\":\" Email not exits\"}",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("{\"message\":\"something went wrong\"}",HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
	/*
	 * ***********************************TO DELETE**************************************
	 * @Override
	public ResponseEntity<String> addNewEtudiant(Map<String, String> requestMap) {
		try {
			if(validateEtudiantMap(requestMap, false)){
				repo.save(getEtudiantFromMap(requestMap,false));
				return new ResponseEntity<String>("{\"message\":\"Etudiant added successfully\"}",HttpStatus.OK);

			}
			return new ResponseEntity<String>("{\"message\":\"invalid data\"}",HttpStatus.BAD_REQUEST);

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("{\"message\":\"something went wrong\"}",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private boolean validateEtudiantMap(Map<String, String> requestMap, boolean validateId) {
		if(requestMap.containsKey("email")) {
			if(requestMap.containsKey("cin") && validateId) {
				return true;
			}else if(!validateId){
				return true;
			}
		}
		return false;
	}
	private Etudiant getEtudiantFromMap(Map<String, String> requestMap, boolean isAdd) {
		Etudiant etudiant = new Etudiant();
		if(isAdd) {
			etudiant.setCin(Integer.parseInt(requestMap.get("cin")));
		}
		etudiant.setNom(requestMap.get("nom"));
		etudiant.setPrenom(requestMap.get("prenom"));
		etudiant.setNumTel(Integer.parseInt(requestMap.get("numTel")));
		etudiant.setEmail(requestMap.get("email"));
		etudiant.setNumInsc(Integer.parseInt(requestMap.get("numInsc")));
		etudiant.setNiveau(Integer.parseInt(requestMap.get("niveau")));
		etudiant.setSpecialite(requestMap.get("specialite"));
		etudiant.setPassword(requestMap.get("password"));
		etudiant.setGroupe(requestMap.get("groupe"));
		etudiant.setParcours(requestMap.get("parcours"));
		//SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		//etudiant.setDateNaiss(new SimpleDateFormat(requestMap.get("dateNaiss")));
		//etudiant.setDateNaiss(new Date(requestMap.get("dateNaiss")));


		return etudiant;
	}*/


	@Override
	public Etudiant addNewEtudServ(Etudiant etudiant) {
		log.info("Service: Etudiant addNewEtudServ(): "+ etudiant.toString());
		//TODO Affecter un mot de passe aléatoire(ou num cin)
		etudiant.setPassword(etudiant.getCin()); //dans ce cas c'est num CIN
		repo.save(etudiant);
		return etudiant;
	}


	@Override
	public List<Etudiant> getAllEtudiant() {
		// TODO Auto-generated method stub
		log.info("Service: Etudiant getAllEtudiant()");
		return repo.findAll();
	}


	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		//Cette methode mettera à jour les champs suivants:
		//(nom,prenom,numTel,email,dateNaiss)
		Etudiant etudMAJ = repo.findByCin(etudiant.getCin());
		if(etudMAJ == null) {
			log.error("Service: Etudiant updateEtudiant(): Pas d'étudiant avec ce CIN");
			return null;
		}
		etudMAJ.setNom(etudiant.getNom());
		etudMAJ.setPrenom(etudiant.getPrenom());
		etudMAJ.setNumTel(etudiant.getNumTel());
		etudMAJ.setEmail(etudiant.getEmail());
		etudMAJ.setDateNaiss(etudiant.getDateNaiss());
		repo.save(etudMAJ);
		log.info("Service: Etudiant updateEtudiant(): Etudiant màj");
		return etudMAJ;
	}


	@Override
	public boolean uploadEtudiants(MultipartFile file) throws Exception {
		List<Etudiant> listEtud = new ArrayList<Etudiant>();
		InputStream inputStream = file.getInputStream();
		CsvParserSettings settings = new CsvParserSettings();
		settings.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(settings);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
		parseAllRecords.forEach(record -> {
			Etudiant etudiant = new Etudiant();
			etudiant.setCin(record.getString("cin"));
			etudiant.setNom(record.getString("nom"));
			etudiant.setPrenom(record.getString("prenom"));
			etudiant.setNumTel(record.getInt("numTel"));
			etudiant.setEmail(record.getString("email"));
			String sDate = record.getString("dateNaiss");
			Date date = null;
			try {
				date = new SimpleDateFormat("dd-MM-yy").parse(sDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			etudiant.setDateNaiss(date);
			etudiant.setNumInsc(record.getInt("numInsc"));
			etudiant.setNiveau(record.getInt("niveau"));
			etudiant.setSpecialite(record.getString("specialite"));
			etudiant.setGroupe(record.getString("groupe"));
			etudiant.setParcours(record.getString("parcours"));
			etudiant.setPassword(etudiant.getCin());
			listEtud.add(etudiant);
		});
		repo.saveAll(listEtud);
		
		return true;
	}
	
}
