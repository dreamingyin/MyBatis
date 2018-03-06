package top.haoyeyin.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import top.haoyeyin.pojo.Student;
import top.haoyeyin.pojo.StudentCustom;
import top.haoyeyin.pojo.StudentQueryVo;

public class StudentMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setup() throws Exception {
		BasicConfigurator.configure();
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂sessionFactory,传入SqlMapConfig.xml配置信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindStudentById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建StudentMapper对象
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

		// 调用studentMapper的方法
		try {
			Student s = studentMapper.findStudentById(1);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//用户信息的综合查询
	@Test
	public void testFindStudentList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建StudentMapper对象
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

		StudentQueryVo studentQueryVo=new StudentQueryVo();
		StudentCustom studentCustom=new StudentCustom();
		// 调用studentMapper的方法
			//创建包装对象，这只查询条件
			studentCustom.setSex("male");
			List<StudentCustom> list;
			try {
				list = studentMapper.findStudentList(studentQueryVo);
				System.out.println(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
