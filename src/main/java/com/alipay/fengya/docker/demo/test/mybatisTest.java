package com.alipay.fengya.docker.demo.test;

import com.alipay.fengya.docker.demo.mybatis.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class mybatisTest {
    static Logger logger = Logger.getLogger(mybatisTest.class);
    public static void main(String[] args) throws IOException {
//        deletePerson();
//        queryPerson();
//        updatePerson();
        queryPerson();
//        addPerson();
    }
    public static void queryPerson() throws IOException {
        //加载数据库文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //connection SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        String statement = "BlogMapper.queryPersonById";
        List<Person> person = session.selectList(statement);
//        System.out.println(person);
        logger.warn(person);
        session.close();

    }
    public static void deletePerson() throws IOException {
        //加载数据库文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //connection SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        String statement = "BlogMapper.deletePersonById";
        int person = session.delete(statement,3);
        System.out.println(person);
        session.close();
    }
    public static void addPerson() throws IOException {
        //加载数据库文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //connection SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        String statement = "BlogMapper.addPerson";
        Person p = new Person("fengya3",25,3);
        p.setSex(true);
        int person = session.delete(statement,p);
        session.commit();
        System.out.println(person);
        session.close();
    }
    public static void updatePerson() throws IOException {
        //加载数据库文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //connection SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        String statement = "BlogMapper.updatePersonById";
        Person p = new Person("fengya3",25,3);
        session.update(statement,p);
        session.commit();
        session.close();
    }
}
