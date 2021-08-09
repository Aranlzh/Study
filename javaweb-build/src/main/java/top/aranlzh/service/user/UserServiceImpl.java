package top.aranlzh.service.user;

import top.aranlzh.dao.BaseDao;
import top.aranlzh.dao.user.UserDao;
import top.aranlzh.dao.user.UserDaoImpl;
import top.aranlzh.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            user = userDao.getUser(connection, userCode);

            if (user == null || !password.equals(user.getUserPassword())){
                return null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return user;
    }
}
