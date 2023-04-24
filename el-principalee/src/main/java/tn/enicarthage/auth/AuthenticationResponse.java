package tn.enicarthage.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import tn.enicarthage.model.Etudiant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
	private String token;
	private Etudiant etudiant;
}
