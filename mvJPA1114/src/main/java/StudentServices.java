import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Student;
import model.StudentDAO;

@Path("/")
public class StudentServices {
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAll(){
		List<Student> result = null;
		result = new StudentDAO().getAll();
		return result;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String add(Student s) {
		try {
			StudentDAO.add(s);
		} catch(Exception e){
			System.out.println("Add Student Error: "+e.getMessage());
			return "Failed";
		}
		return "OK";
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@FormParam("sid") int id) {
		StudentDAO.delete(id);
		return "ok";
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(@FormParam("sid") int sid, @FormParam("sname") String sname, @FormParam("age") int age) {
		Student s = new Student(sid, sname, age);
		StudentDAO.update(s);
		return "ok";
	}
	
	@POST
	@Path("/test")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String addTest(@FormParam("sid") String sidS, @FormParam("sname") String sname, @FormParam("age") String ageS) {
		int sid = Integer.parseInt(sidS);
		int age = Integer.parseInt(ageS);
		Student s = new Student(sid, sname, age);
		StudentDAO.add(s);
		return "ok";
	}
}
