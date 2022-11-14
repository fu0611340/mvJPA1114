

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class StudentByAgeServlet
 */
@WebServlet("/StudentByAgeServlet")
public class StudentByAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentByAgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int age = Integer.parseInt(request.getParameter("age"));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mvJPA1114");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//保留變數的「JPQL」語法
		TypedQuery<Student> tq = em.createQuery("SELECT s FROM Student s where s.age >= :x", Student.class);
		tq.setParameter("x", age);
		List<Student> l = tq.getResultList();
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
