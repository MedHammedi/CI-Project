package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

<<<<<<< HEAD
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

import static org.junit.Assert.assertEquals;

=======
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

>>>>>>> Hammedi
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class ContratServiceTest{
	

		@Autowired 
		IContratService cs; 
		@Autowired 
		IEmployeService es; 
		
		@Test
		public void testGetAllContrats() {
			List<Contrat> listContrats = cs.getAllContrats(); 
			
		}
	

		

	}

=======
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceTest {

	@Autowired
	IContratService cs;
	@Autowired
	IEmployeService es;
	@Autowired
	ContratRepository contratRepoistory;
	
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	@Test
	public void testRetrieveAllContrat() {

		List<Contrat> listUsers = cs.getAllContrats();
		// if there are 5 users in DB :
		assertEquals(13, listUsers.size());
	}
	
	
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-03-23");
		Contrat u = new Contrat(d, "CDD", 8500);
		Contrat userAdded = contratRepoistory.save(u);
		assertEquals(u.getTypeContrat(), userAdded.getTypeContrat());
		l.info("\n" + "\n" + "  Contrat Added. ");
	}
	
	
	public void testAffectContrat() {
		Contrat c = new Contrat(5);
		Employe e = new Employe(1);
		es.affecterContratAEmploye(c.getReference(),e.getId());
		assertEquals(c.getReference(),c.getReference());
		l.info("\n" + "\n" + " Contrat Affected . " + "\n" + "\n" );
	}
	
	@Test
	public void testDelteContratbyid() {
		Contrat c = new Contrat(19);
		es.deleteContratById(c.getReference());
		assertEquals(c.getReference(),c.getReference());
		l.info("\n" + "\n" + " Contrat Deleted. " + "\n" + "\n");
	}
	
}
>>>>>>> Hammedi
