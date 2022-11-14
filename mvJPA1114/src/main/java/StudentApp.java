import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/student")
public class StudentApp extends Application{
	@Override
	public Set<Class<?>> getClasses(){
		return new HashSet(Arrays.asList(StudentServices.class));
	}
}
