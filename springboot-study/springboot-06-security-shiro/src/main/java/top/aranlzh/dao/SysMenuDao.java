package top.aranlzh.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aranlzh.pojo.SysMenuEntity;

import java.util.List;

@Mapper
@Repository
public interface SysMenuDao {
    List<SysMenuEntity> selectList(Object o);
}
