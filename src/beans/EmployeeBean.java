package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeBean {
	private int empid, salary;

	// property empid
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	// property salary
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean process() {

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  // Load driver 
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement ps = con.prepareStatement
					("update employees set salary = ? where employee_id = ?");

			ps.setInt(1, salary);
			ps.setInt(2, empid);

			int count = ps.executeUpdate();
			return count == 1;
		} catch (Exception ex) {
			System.out.println("Error -->" + ex.getMessage());
			return false;
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
			}
		}
	}

}
