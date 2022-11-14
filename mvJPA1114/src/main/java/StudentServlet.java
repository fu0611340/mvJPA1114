

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvJPA1114");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//第一種：直接寫「JPQL」語法
		//Query q = em.createQuery("Select s from Student s");
		//第二種：用自己在Entity定義好的「NamedQuery」
		Query q = em.createNamedQuery("Student.findAll");
		@SuppressWarnings("unchecked")
		List<Student> l = q.getResultList();
		System.out.print("sid");
		System.out.print("\t sname");
		System.out.print("\t age\n");
		for(Student s: l) {
			System.out.print(s.getSid());
			System.out.print("\t"+s.getSname());
			System.out.print("\t"+s.getAge()+"\n");
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		request.setAttribute("students", l);
		request.getRequestDispatcher("viewStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
