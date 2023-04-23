package tn.enicarthage.services;

import org.springframework.http.ResponseEntity;

import tn.enicarthage.model.AttestPresence;

public interface AttestPresenceService {

	public ResponseEntity<?> generateAttestation(AttestPresence attestPresence);

}
