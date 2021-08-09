package top.aranlzh.dao.user;

import top.aranlzh.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    // 等到要登录的用户
    User getUser(Connection connection, String userCode) throws SQLException;

//     int updatePwd(@Param("userCode") String userCode, @Param("password")String password);
//
//     //查询用户总数
// //    @Select("select count(1) as count form smbms_user")
//     int getUserCount(@Param("userName") String userName , @Param("userRole") int userRole);
//
//     List<User> getUserList(@Param("userName") String userName, @Param("userRole") int userRole, @Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize);
//
//     //获取角色列表
//     List<Role> getRoleList();
//
//     int addUser(User user);
//
//     int deleteUserById(Integer id);
//
//     int modify(User user);

}
