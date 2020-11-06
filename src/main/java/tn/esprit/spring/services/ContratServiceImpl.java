package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	IEmployeService iemployeservice;

	@Autowired
	ContratRepository contratRepository;
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	public List<Contrat> getAllContrats() {
		l.info("\n" +"\n" +"\n"+ "Logger result GetAllContrats: " +"\n" +"\n" +"\n"  ); 
		l.info("\n" + "\n" + "In  retrieveAllContart : "); 
		List<Contrat> contrats = (List<Contrat>) contratRepository.findAll(); 
		for (Contrat contrat : contrats) {
			l.debug("contrat +++ : " + contrat);
		}
		l.info( "\n" + "\n" +" Out of retrieveAllContrats."); 
		return contrats;
	}
	
	public int ajouterContrat(Contrat contrat) {
		l.info("\n" +"\n" +"\n"+ "Logger result Add Contrats: " +"\n" +"\n" +"\n"  ); 
		l.info("\n" + "\n" + "In  addContrat : ");
	    contratRepository.save(contrat);
		l.info("\n" + "\n" + " Contrat Added. "); 
		return contrat.getReference(); 
		
	}
	
	
	public void deleteContrat(int contratId) {
		iemployeservice.deleteContratById(contratId);
		
	}
	
	public void affecterContratAEmploye(int contratId,int employeId)
	{
		iemployeservice.affecterContratAEmploye(contratId, employeId);
	}

}
