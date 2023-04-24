package tn.enicarthage.services;



import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import tn.enicarthage.model.AttestPresence;
import tn.enicarthage.repositories.AttestPresenceRepo;

@Service
public class AttestPresenceServiceImpl implements AttestPresenceService{
	
	
	@Autowired
	AttestPresenceRepo repo;
	
	
	@Override
	public ResponseEntity<?> generateAttestation(AttestPresence attestPresence)    {
		
		String fileName=getFileName();
		Date date = new Date(); // Création de l'objet Date actuel
		Calendar calendar = Calendar.getInstance(); // Création d'un objet Calendar
		calendar.setTime(date); // Définition de la date dans le calendrier
		int year = calendar.get(Calendar.YEAR); // Récupération de l'année
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String dd = day+"/"+"0"+month+"/"+year;
		
		int year1=year-1;
		
		attestPresence.setDateAttest(dd);
		repo.save(attestPresence);

		
		String data = "Nom	 :  "+attestPresence.getNom().toUpperCase()+"\n"
		+"Prénom	 : "+attestPresence.getPrenom().toUpperCase()+"\n"+
		"Née Le	:  "+attestPresence.getDateNaiss()+"\n"+
		"Titulaire de la Carte d'Identité Nationale N° : "+attestPresence.getCin()+"\n"+
		"est inscrit(e) en : "+attestPresence.getNiveau()+((attestPresence.getNiveau()>1)? "ème ANNEE DU DEUXIEME CYCLE":"ère ANNEE DU DEUXIEME CYCLE")+"\n"+
		"du diplôme	:  "+attestPresence.getParcours()+"\n"+
		"Spécialité	 : "+attestPresence.getSpecialite()+"\n"+
		"sous le Numéro  :  "+attestPresence.getNumInsc()+"\n"+
		"suit régulièrement ses études pour l'année universitaire en cours."+"\n \n     ";
		
		
		try {
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, new FileOutputStream("D:\\Attestation\\"+fileName+".pdf"));
			document.open();
			
			Paragraph p1 = new Paragraph("REPUBLIC TUNISIENNE"+"\n"+"MINISTERE DE L'ENSEIGNEMENT SUPERIEUR"+"\n"+"ET DE LA RECHERCHE SCIENTIFIQUE"+"\n \n");
			document.add(p1);
			
			Paragraph p2 = new Paragraph("UNIVERSITE DE CARTHAGE"+"\n"+"Ecole Nationale D'Ingénieurs de Carthage"+"\n \n \n",FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, BaseColor.BLACK));
			document.add(p2);
			
			Paragraph p3 = new Paragraph("ATTESTATION DE PRESENCE"+"\n",  FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, BaseColor.BLACK));
			p3.setAlignment(Element.ALIGN_CENTER);
			document.add(p3);
			  
			Paragraph p4 = new Paragraph(year1+"/"+year+"\n \n", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, BaseColor.BLACK));
			p4.setAlignment(Element.ALIGN_CENTER);
			document.add(p4);
			
			Paragraph p5 = new Paragraph("La sécrétaire générale de Ecole Nationale D'Ingénieurs de Carthage,"+"\n \n"+"soussigné, atteste que l'étudiant(e) : "+"\n");
		    document.add(p5);
		    
		    Paragraph p6 = new Paragraph(data);
		    document.add(p6);
			Paragraph p7 = new Paragraph("La présente attestation est délivrée à l'intéressé(e), pour servir et valoir ce que de droit."+"\n \n \n \n");
			 document.add(p7);
			 
			Paragraph p8 = new Paragraph("Fait à Ariana, Le "+attestPresence.getDateAttest()+"\n \n \n");
		    p8.setAlignment(Element.ALIGN_RIGHT);
		    document.add(p8);
		    
		    Paragraph p9 = new Paragraph("La Secrétaire Générale "+"\n",FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, BaseColor.BLACK) );
		    p9.setAlignment(Element.ALIGN_RIGHT);
		    document.add(p9);
		    
		    document.close();
		   
		    
		    
		    } catch (IOException  | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<>("{\"message\":\"file name\""+fileName+"\"}",HttpStatus.OK);
	}
	
	
	
	

	private String getFileName() {
		
		//AttestPresence at=null;
		SimpleDateFormat date = new SimpleDateFormat("ddMMyyyyHHmmss ");
		Date d = new Date();
		return "Attestation de présence-"+date.format(d);
	}
	
	
	

}
