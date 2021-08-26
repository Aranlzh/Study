package top.aranlzh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aranlzh.dao.RoleDao;
import top.aranlzh.pojo.Role;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleDao roleDao;

    @GetMapping("getRoles")
    public List<Role> getAllRoles(){
        return roleDao.getAllRoles();
    }

}
