package top.aranlzh.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aranlzh.pojo.SysUserEntity;

import java.util.List;

@Mapper
@Repository
public interface SysUserDao {
    List<String> queryAllPerms(Long userId);
    SysUserEntity selectByUsername(String username);
}
