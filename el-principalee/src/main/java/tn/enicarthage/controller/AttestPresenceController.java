package tn.enicarthage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.enicarthage.model.AttestPresence;


@RequestMapping("/attestpresence")
public interface AttestPresenceController {
	@PostMapping("/generateAttestation")
	public ResponseEntity<?> generateAttestation(@RequestBody AttestPresence attestPresence);
}
