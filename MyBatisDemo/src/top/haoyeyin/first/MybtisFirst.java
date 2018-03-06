package top.haoyeyin.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import top.haoyeyin.pojo.Student;

//入门程序
public class MybtisFirst {
	// 根据ID得到一条记录的结果
	@Test
	public void findByUserId() throws IOException {
		BasicConfigurator.configure();
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂sessionFactory,传入SqlMapConfig.xml配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数:映射文件中statement的id,等于命名空间+statementId
		// 第二个参数：指定在映射问件中所匹配的parameter的Type的类型参数
		// SqlSession
		List<Student> list = sqlSession.selectList("test.findStudentByName");
		System.out.println(list);
		// 释放会话资源
		sqlSession.close();

	}

	// 添加用户信息
	@Test
	public void insertUser() throws IOException {
		BasicConfigurator.configure();
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂sessionFactory,传入SqlMapConfig.xml配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数:映射文件中statement的id,等于命名空间+statementId
		// 第二个参数：指定在映射问件中所匹配的parameter的Type的类型参数
		// SqlSession
		Student str = new Student("steven_wu", "31892543", "武则天", "female");
		// List文件中的Student与映射文件中的类型对应。
		sqlSession.insert("test.insertStudent", str);
		// 获取用户新增信息的主键
		System.out.println("返回用户主键ID" + str.getId());
		// 提交事务
		sqlSession.commit();
		// 释放会话资源
		sqlSession.close();

	}

	// 添加用户信息
	@Test
	public void deleteUser() throws IOException {
		BasicConfigurator.configure();
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂sessionFactory,传入SqlMapConfig.xml配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数:映射文件中statement的id,等于命名空间+statementId
		// 第二个参数：指定在映射问件中所匹配的parameter的Type的类型参数
		// 传入ID删除用户信息
		sqlSession.delete("test.deleteStudent", 6);
		// 提交事务
		sqlSession.commit();
		// 释放会话资源
		sqlSession.close();

	}

	// 更新用户信息
	@Test
	public void updateteUser() throws IOException {
		BasicConfigurator.configure();
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂sessionFactory,传入SqlMapConfig.xml配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数:映射文件中statement的id,等于命名空间+statementId
		// 第二个参数：指定在映射问件中所匹配的parameter的Type的类型参数
		Student str = new Student();
		str.setId(4);
		str.setLoginname("steven_kali");
		str.setLoginpass("31892543");
		str.setName("黎明");
		str.setSex("male");
		// 传入ID删除用户信息
		sqlSession.update("test.updateStudent", str);
		// 提交事务
		sqlSession.commit();
		// 释放会话资源
		sqlSession.close();

	}
}
