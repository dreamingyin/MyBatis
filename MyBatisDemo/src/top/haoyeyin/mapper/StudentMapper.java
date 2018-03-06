package top.haoyeyin.mapper;

import java.util.List;

import top.haoyeyin.pojo.Student;
import top.haoyeyin.pojo.StudentCustom;
import top.haoyeyin.pojo.StudentQueryVo;

/*
 * Dao接口，学生接口
 */
public interface StudentMapper {

	public List<StudentCustom> findStudentList(StudentQueryVo studentQueryVo) throws Exception;
	//根据ID查询学生信息
	public Student findStudentById(int id) throws Exception;
	
	public List<Student> findStudentByName(String name) throws Exception;
	//添加用户信息 
	public void insertStudent(Student student) throws Exception;
	
	
	//删除学生信息
	public void deleteStudent(int id) throws Exception;

	public List<Student> findByName(String name) throws Exception;
	
}
