package rest;

import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloRest {
	
	@GET
	public String sayHello() {
		return "Hello From Jersey. Now it is : " + LocalDateTime.now().toString();
	}

}
