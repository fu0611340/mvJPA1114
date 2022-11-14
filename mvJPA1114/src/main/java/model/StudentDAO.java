package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDAO {
	@SuppressWarnings("unchecked")
	public static List<Student> getAll(){
		List<Student> result = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvJPA1114");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNamedQuery("Student.findAll");
		result = q.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return result;
	}
}
