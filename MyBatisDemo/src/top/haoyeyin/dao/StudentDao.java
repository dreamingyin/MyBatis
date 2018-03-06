package top.haoyeyin.dao;

import java.util.List;

import top.haoyeyin.pojo.Student;

public interface StudentDao {

	public Student findById(int id) throws Exception;
	public void insertStudent(Student student) throws Exception;
	public void deleteStudent(int id) throws Exception;
	public List<Student> findByName(String name) throws Exception;
	public Student findStudentById(int id) throws Exception;
	public List<Student> findStudentByName(String name) throws Exception;
}
