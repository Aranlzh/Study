package top.aranlzh.service.user;

import top.aranlzh.pojo.User;

public interface UserService {

    // 用户登录
    User login(String userCode, String password);

}
