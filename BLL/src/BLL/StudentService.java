package BLL;

import java.util.ArrayList;
import java.util.List;

import DAL.Student;

public class StudentService {
	public static List<Student> getCMPS258Students() {

		List<Student> allStudents = DAL.Student.getAllStudents();
		List<Student> cmpsStudents = new ArrayList<Student>();
		
		for (Student student : allStudents) {
			if(student.getEmail().startsWith("m")){
				cmpsStudents.add(student);
			}
		}
		return cmpsStudents;
	}

//	public static boolean registerForCourse(Student s, Course c){
//		return false;
//	}
}
