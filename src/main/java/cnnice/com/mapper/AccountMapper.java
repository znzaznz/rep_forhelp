package cnnice.com.mapper;

import cnnice.com.MyBatisDemo;

import java.util.List;

public interface AccountMapper {
    MyBatisDemo selectMybatisDemo(int id);

    List<MyBatisDemo> selectMyBatisDemoAll(int id);
}
