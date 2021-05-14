package BDD;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import SaberYGanar.Ingles;
import SaberYGanar.Letras;
import SaberYGanar.Mates;

public class BaseDeDatosOrientadaObjetos {
	static Selects selec = new Selects();
	public BaseDeDatosOrientadaObjetos() {
		
	}
	
	public void volcado() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("KnowingandWinningEuropeanLeague.odb");
	 	EntityManager em = emf.createEntityManager();
	 	
	 	try {
		 	  //Obrim una transacció
		  	em.getTransaction().begin();
		    int maxPregunta = selec.selecMaxPregunta();
		    //Busquem si ja existeix la persona
		    //Creem una consulta amb paràmetre
		    for(int i = 1; i <= maxPregunta; i++) {
		    	if( i <= selec.selecCountMates()) {
		    		String enunciadoMates = selec.selecEcuacioMates(i);
		    		Query queryUsuari = em.createQuery("SELECT enunciado " +  "FROM Mates  " + "WHERE enunciado =:enunciado ");		    		
		    		queryUsuari.setParameter("enunciado",enunciadoMates);
		    		List<Mates> mates = queryUsuari.getResultList();
		    		Mates m = new Mates();
		    		if(mates.size()==0) {
				    	//Creem una persona nova
				    	m.setEnunciado(enunciadoMates);
				    	m.setResultado(selec.respuestaMates(enunciadoMates));
				    	em.persist(m);
				  
				    }
		    	}else if( i <= selec.selecMaxIngles()) {
		    		String enunciadoIngles = selec.selecEnunciadoIngles(i);
		    		 TypedQuery<Ingles> queryUsuari = em.createQuery("SELECT enunciado " +  "FROM Ingles " + "WHERE enunciado =:enunciado ", Ingles.class);		    		
		    		queryUsuari.setParameter("enunciado",enunciadoIngles);
		    		List<Ingles> ingles = queryUsuari.getResultList();
		    		Ingles e = new Ingles();
		    		if(ingles.size()==0) {
				    	//Creem una persona nova
				    	e.setEnunciado(enunciadoIngles);
				    	e.setRespuestas(selec.selecRespuestasIngles(i));
				    	em.persist(e);
				  
				    }
		    	}else {
		    		String enunciadoLetras = selec.selecOcultaLetras(i);
		    		TypedQuery<Letras> queryUsuari = em.createQuery("SELECT enunciado " +  "FROM Letras " + "WHERE enunciado =:enunciado ", Letras.class);		    		
		    		queryUsuari.setParameter("enunciado",enunciadoLetras);
		    		List<Letras> letras = queryUsuari.getResultList();
		    		Letras l = new Letras();
		    		if(letras.size()==0) {
				    	//Creem una persona nova
				    	l.setEnunciado(enunciadoLetras);
				    	l.setPalabraEntera(selec.selecPalabraCompleta(enunciadoLetras));
				    	em.persist(l);
				  
				    }
		    	}
		    	
		    }
			em.getTransaction().commit();
			System.out.println("Hecho correctamente");

	    }finally {
	    	if (em.getTransaction().isActive())
	            em.getTransaction().rollback();
	     	//Tanca la connexió amb la base de dades
	        em.close();
	        emf.close();
	    	
	    }
	    
	    
	 }
	
}
