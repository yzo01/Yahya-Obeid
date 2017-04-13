import java.util.List;

import DAL.Student;

public class Client {
	public static void main(String args[]) {
		
		List<Student> students = BLL.StudentService.getCMPS258Students();

		for (Student student : students) {
			System.out.println(student);
		}
		
		Student s = DAL.Student.getByEmail("mwo01@mail.aub.edu");
		System.out.println(s);
	}
}