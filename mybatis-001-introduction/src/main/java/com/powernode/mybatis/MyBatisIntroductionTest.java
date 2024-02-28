package com.powernode.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) {
//        1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        2.创建SqlSessionFactory对象
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        3.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4.执行sql
        int count = sqlSession.insert("insertCar"); //这个“insertCar”必须是sql的id
        System.out.println("插入几条数据：" + count);
//        5.提交（myatis 默认采用的事务管理器JDBC，默认是不提交的，需要手动提交）
        sqlSession.commit();
//        6.关闭资源（只关闭资源是不会提交的）
        sqlSession.close();
    }


}
