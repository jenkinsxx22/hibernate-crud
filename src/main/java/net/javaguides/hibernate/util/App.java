package net.javaguides.hibernate.util;
import java.util.List;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.model.Student;
public class App {

	public static void main(String args[]) throws Exception {
		
		StudentDao studentdao = new StudentDao();

		//test save student
		Student student = new Student(1,"Nisar","Ahmed","nisar@abc.com");
		studentdao.SaveStudent(student);
		
		//test update student
		student.setFirstName("Nizar");
		studentdao.UpdateStudent(student);
		
		//test get student by id
		Student student2 = studentdao.getStudentById(student.getId());

		//test get all students
		List<Student> students = studentdao.getAllStudent();
		
		students.forEach(student1->System.out.println(student.getId()));
		
		//test delete student
		
		studentdao.DeleteStudent(student.getId());
	}
}
