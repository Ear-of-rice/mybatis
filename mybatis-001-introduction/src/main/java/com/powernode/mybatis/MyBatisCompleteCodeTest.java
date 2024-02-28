package com.powernode.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 比较完整的第一个mybatis程序写法
 *
 * @author Dkui
 * @version 1.0
 * @since 1.0
 */
public class MyBatisCompleteCodeTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
//            1.创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//            2.创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
//            3.创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
//            4.执行sql
            int count = sqlSession.insert("insertCar");
            System.out.println("插入了几条记录" + count);
//            5.提交
            sqlSession.commit();

        } catch (Exception e) {
//            回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
//            6.关闭
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
