package top.haoyeyin.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import top.haoyeyin.dao.StudentDao;
import top.haoyeyin.dao.StudentDaoImpl;
import top.haoyeyin.mapper.StudentMapper;
import top.haoyeyin.pojo.Student;

public class UserDaoTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setup() throws Exception{
		BasicConfigurator.configure();
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂sessionFactory,传入SqlMapConfig.xml配置信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		
	}
	@Test
	public void UserTest(){
		StudentDaoImpl stu=new StudentDaoImpl(sqlSessionFactory);
		try {
			Student s=stu.findById(4);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertStudentTest(){
		StudentDao stu=new StudentDaoImpl(sqlSessionFactory);
		Student str = new Student("steven_wu", "31892543", "武则天", "female");
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void findName(){
		StudentDaoImpl stu=new StudentDaoImpl(sqlSessionFactory);
		try {
			stu.findByName("李");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
