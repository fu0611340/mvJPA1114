import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Student;
import model.StudentDAO;

@Path("/")
public class StudentServices {
	
	@GET
	public void show() {
		System.out.println("test");
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAll(){
		List<Student> result = null;
		result = new StudentDAO().getAll();
		return result;
	}
}
