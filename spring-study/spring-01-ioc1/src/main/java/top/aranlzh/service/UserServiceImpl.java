package top.aranlzh.service;

import top.aranlzh.dao.UserDao;
import top.aranlzh.dao.UserDaoImpl;
import top.aranlzh.dao.UserDaoMysqlImpl;
import top.aranlzh.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService {

//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoMysqlImpl();
//    private UserDao userDao = new UserDaoOracleImpl();

    private UserDao userDao;

    // 利用set进行动态实现值的注入：发生了革命性变化！
    // 之前是程序主动创建对象！现在控制权在程序员手上！（实现类初始化->调用类赋值）
    // 程序不再具有主动性，而是变成了被动的接受对象！
    // 系统耦合性大大降低，可以更专注在业务的实现上，这是IOC的原型。

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
