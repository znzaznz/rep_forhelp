package cnnice.com;

import cnnice.com.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UseMapperWay {
    public static void main(String[] args) throws IOException {
        //初始化配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取sqlsessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取session对象
        SqlSession session = sqlSessionFactory.openSession();

        System.out.println(AccountMapper.class);
        // 获取mapper
        AccountMapper mapper = session.getMapper(AccountMapper.class);

        // 接下来使用mapper来增删改查
        MyBatisDemo myBatisDemo = mapper.selectMybatisDemo(2);
        System.out.println(myBatisDemo);

        // 提交事务
        session.commit();

        // 关闭session
        session.close();
    }
}
