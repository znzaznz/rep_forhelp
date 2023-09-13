package cnnice.com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        //初始化配置
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取sqlsessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取session对象
        SqlSession session = sqlSessionFactory.openSession();

        // 执行sql
        MyBatisDemo myBatisDemo = session.selectOne("AccountMapper.selectMybatisDemo", 1);
        System.out.println(myBatisDemo);

        // 获取整个List
        List<MyBatisDemo> myBatisDemos = session.selectList("AccountMapper.selectMyBatisDemoAll");
        for (MyBatisDemo batisDemo : myBatisDemos) {
            System.out.println(batisDemo);
        }

        // 增加sql
        MyBatisDemo myBatisDemo1 = new MyBatisDemo("小米", 1231);

        session.insert("AccountMapper.addMyBatisDemo", myBatisDemo1);


        // 删除sql
        session.delete("AccountMapper.deleteMyBatisDemo", "小米");

        // 修改sql
        MyBatisDemo myBatisDemo2 = new MyBatisDemo();
        myBatisDemo2.setId(1);
        myBatisDemo2.setName("小赵");

        session.update("AccountMapper.updateMyBatisDemo", myBatisDemo2);

        // 再次查询
        MyBatisDemo myBatisDemo3 = session.selectOne("AccountMapper.selectMybatisDemo", 1);
        System.out.println(myBatisDemo3);

        // 提交事务
        session.commit();

        // 关闭session
        session.close();
    }
}
