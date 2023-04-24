package tn.enicarthage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.model.AttestPresence;
import tn.enicarthage.services.AttestPresenceService;

@RestController
@CrossOrigin
public class AttestPresenceControllerImpl implements AttestPresenceController {

	@Autowired AttestPresenceService attService;
	
	
	@Override
	public ResponseEntity<?> generateAttestation(AttestPresence attestPresence) {
		return attService.generateAttestation(attestPresence);
	}

}
