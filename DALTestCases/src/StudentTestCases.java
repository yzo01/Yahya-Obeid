import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DAL.Student;

public class StudentTestCases {

	static List<Student> allStudents;
	static List<Student> cmpsStudents;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		allStudents = DAL.Student.getAllStudents();
		cmpsStudents = new ArrayList<Student>();
	}

	@Test
	public void testStudentCount(){
		assertEquals("total number of students is 72",allStudents.size(),72);
	}
	@Test
	public void everyStudentHasAnEmail(){
		
		for (Student student : allStudents) {
			if(student.getEmail()==null || student.getEmail()==""){
				fail("a Studenta cannot be without email");
			}
		}
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStudentId() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllStudents() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByEmail() {
		fail("Not yet implemented");
	}

}
