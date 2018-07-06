package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/jobs")
public class JobsService {
	@GET
	public String getJobs() {
		try {
			javax.sql.rowset.CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();

			JsonArrayBuilder jobs = Json.createArrayBuilder();
			while (rs.next()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", rs.getString("job_id"));
				job.add("title", rs.getString("job_title"));
				jobs.add(job.build());
			}

			rs.close();
			return jobs.build().toString();
		} catch (Exception ex) {
			throw new InternalServerErrorException();
		}
	}

	@GET
	@Path("/{id}")
	public String getJob(@PathParam("id") String id) {
		try {
			javax.sql.rowset.CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs where job_id  = ?");
			rs.setString(1, id);
			rs.execute();
			if (rs.next()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", rs.getString("job_id"));
				job.add("title", rs.getString("job_title"));
				return job.build().toString();
			} else
				throw new NotFoundException();
		} catch (SQLException ex) {
			throw new InternalServerErrorException();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addJob(@FormParam("id") String id, @FormParam("title") String title) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement ps = con.prepareStatement("insert into jobs(job_id,job_title) values(?,?)");
			ps.setString(1, id);
			ps.setString(2, title);
			ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			throw new InternalServerErrorException();
		}
	}

	@DELETE
	@Path("/{id}")
	public void deleteJob(@PathParam("id") String id) {
		try {
			System.out.println("Deleting job :" + id);
		} catch (Exception ex) {
			throw new InternalServerErrorException();
		}
	}

	@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateJob(@PathParam("id") String id, @FormParam("title") String title) {
		try {
			System.out.println(id);
			System.out.println(title);
		} catch (Exception ex) {
			throw new InternalServerErrorException();
		}
	}
}
