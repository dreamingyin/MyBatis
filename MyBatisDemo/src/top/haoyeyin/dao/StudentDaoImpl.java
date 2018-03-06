package top.haoyeyin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import top.haoyeyin.mapper.StudentMapper;
import top.haoyeyin.pojo.Student;

public class StudentDaoImpl implements StudentDao {

	//需要向dao实现类注入SqlSession
	//这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;
	public StudentDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}
	
	@Override
	public Student findById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Student stu=sqlSession.selectOne("test.findStudentByName",id);
		sqlSession.close();
		return stu;
	}

	@Override
	public void insertStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession=sqlSessionFactory.openSession();
		// List文件中的Student与映射文件中的类型对应。
		//执行插入的操作
		sqlSession.insert("test.insertStudent", student);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteStudent(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteStudent",id);
		sqlSession.close();
	}

	@Override
	public List<Student> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> list=sqlSession.selectList("test.findStudentByName",name);
		sqlSession.close();
		return list;
	}

	@Override
	public Student findStudentById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
