package com.powernode.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 测试mybatis核心配置文件路径问题
 *
 * @author Dkui
 * @version 1.0
 * @since 1.0
 */
public class MyBatisConfigFilePath {
    public static void main(String[] args) throws FileNotFoundException {
//        1.创建SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//    2.    创建SqlSessionFactory对象
//        这里只有一个输入流，可以自己new
        FileInputStream is = new FileInputStream("D:/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        3.    创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4.执行sql
        int count = sqlSession.insert("insertUser");
        System.out.println("插入几条数据" + count);
//        5.提交（mybatis默认采用的事务管理器是JDBC，默认是不提交的，需要手动提交）
        sqlSession.commit();
//        6.关闭资源（只有关闭是不会提交的）
        sqlSession.close();
    }

}

