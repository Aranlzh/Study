package top.aranlzh.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aranlzh.pojo.Role;

import java.util.List;


@Mapper
@Repository
public interface RoleDao {

    List<Role> getAllRoles();

}
