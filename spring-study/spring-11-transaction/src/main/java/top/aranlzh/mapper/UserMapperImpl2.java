package top.aranlzh.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import top.aranlzh.pojo.User;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {

    public List<User> getAllUser() {
        return getSqlSession().getMapper(UserMapper.class).getAllUser();
    }
}
