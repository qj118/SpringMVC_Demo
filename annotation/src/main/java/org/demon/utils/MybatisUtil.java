package org.demon.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static InputStream in;
    private static SqlSessionFactory factory;
    private static SqlSession session;

    public static SqlSession getSession() throws IOException {
        if(session != null){
            return session;
        }
        in = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        return session;
    }

    public static void destroy() throws IOException {
        session.close();
        in.close();
    }
}
