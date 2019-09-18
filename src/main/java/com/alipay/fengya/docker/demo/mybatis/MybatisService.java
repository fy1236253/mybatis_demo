package com.alipay.fengya.docker.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MybatisService {

    public static void getConnection(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    public static void main(String[] args) throws IOException {
        //加载数据库文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        //connection SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        String statement = "BlogMapper.queryPersonById";
        Person person = session.selectOne(statement,2);
        System.out.println(person.getName());
        session.close();

    }
}
