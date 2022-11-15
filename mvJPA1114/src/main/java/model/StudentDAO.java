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
	
	public static void add(Student s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvJPA1114");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static void delete(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvJPA1114");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student s = em.find(Student.class, id);
		em.remove(s);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static void update(Student s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvJPA1114");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student newS = em.find(Student.class, s.getSid());
		if(newS != null) {
			newS.setSname(s.getSname());
			newS.setAge(s.getAge());
			em.merge(newS);
			em.getTransaction().commit();
		}
		else {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}
