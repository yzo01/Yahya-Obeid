package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private int studentId;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStudentId() {
		return studentId;
	}

	private Student(int studentId, String email) {
		super();
		this.studentId = studentId;
		this.email = email;
	}

	public static Student createInstance(int studentId, String email) {
		return new Student(studentId, email);
	}

	@Override
	public String toString() {
		return studentId + ": " + email;
	}

	public static List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://banda.database.windows.net;database=clinic;user=cmps253;password=AaBbCc!1@2";
			Connection con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected.");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT email,studentid FROM cmps253.student");

			while (rs.next()) {
				students.add(Student.createInstance(rs.getInt(2), rs.getString(1)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return students;
	}

	public static Student getByEmail(String email) {

		ResultSet rs = getResultSet("select email,studentid from cmps253.student where email = '" + email + "'");
		try {
			rs.next();
			return Student.createInstance(rs.getInt(2), rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ResultSet getResultSet(String sql) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://banda.database.windows.net;database=clinic;user=cmps253;password=AaBbCc!1@2";
			Connection con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected.");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return null;
	}

}
