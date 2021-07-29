package top.aranlzh.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import top.aranlzh.pojo.User;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> getAllUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getAllUser();
    }
}
