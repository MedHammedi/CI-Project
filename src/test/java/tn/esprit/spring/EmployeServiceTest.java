package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.junit.Test;
import org.junit.internal.runners.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

import static org.junit.Assert.assertEquals;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysql.cj.log.Log;

import ch.qos.logback.classic.Logger;
@RunWith(SpringRunner.class)

@SpringBootTest
public class EmployeServiceTest{

		@Autowired 
		IContratService cs; 
		@Autowired 
		IEmployeService es; 
		@Test
	public	void contextLoads() {
		}
		
		@Test
		public void AjoutEmploye() {
			//List<Contrat> listContrats = cs.getAllContrats(); 
	//System.out.println(es.authenticate("admin@gmail.com", "admin"));
//	System.out.println(es.authenticate("admin@gmail.com", "a"));
	//log(es.authenticate("admin@gmail.com", "a"));
//Log4JLogger logger = null;
//logger.fatal(es.authenticate("admin@gmail.com", "a"));
	//log.info(es.authenticate("admin@gmail.com", "a"));
			
			//Employe test1=es.authenticate("admin@gmail.com", "admin");
	
			Employe	employer=new Employe("hedi","hedi","hedi@gmail.com","123456789",true,Role.TECHNICIEN);
			boolean test=false;
try {
	int mytest=es.addOrUpdateEmploye(employer);
	
test=(mytest!=0);

} catch (Exception e) {
	// TODO: handle exception
}
			
			assertEquals("ajout avec success de lemployee",true, test);


		}
	

		@Test
		public void EmployeAjoutContrat() {
			
		
			boolean test=false;
try {
	
	Contrat ct=new Contrat(new Date(),"CIVP",12.2f);
	int mytest=es.ajouterContrat(ct);
	
	
test=(mytest!=0);

} catch (Exception e) {
	// TODO: handle exception
}
	
			assertEquals("ajout du contrat effectué avec succés",true, test);


		}
			

		

		@Test
		public void Authentication() {
			
	
			boolean test=false;
try {
	
	
	Employe mytest=es.authenticate("admin@gmail.com", "admin");
	
	
 test=(mytest!=null);

} catch (Exception e) {
	// TODO: handle exception
}
			
//	Employe	test3=new Employe("","","",true,Role.ADMINISTRATEUR);
	//Employe	test2=new Employe();
			assertEquals("Authentifié avec sccés",true, test);


		}
			



		@Test
		public void AuthenticationError() {
			
			boolean test=true;
try {
	
	Employe mytest=es.authenticate("admin@gmail.com", "admin123");
	
	
 test=(mytest!=null);

} catch (Exception e) {
	// TODO: handle exception
}
			
//	Employe	test3=new Employe("","","",true,Role.ADMINISTRATEUR);
	//Employe	test2=new Employe();
			assertEquals("Authentifié avec sccés",true, test);


		}

		
		@Test
		public void getAllEmployes() {
					
			//Employe test1=es.authenticate("admin@gmail.com", "admin");
	
			boolean test=true;
try {
	
	List<Employe> employes=es.getAllEmployes();
	
	
 test=(!employes.isEmpty());

} catch (Exception e) {
	// TODO: handle exception
}
			
//	Employe	test3=new Employe("","","",true,Role.ADMINISTRATEUR);
	//Employe	test2=new Employe();
			assertEquals("Authentifié avec sccés",true, test);


		}

				
		

	}