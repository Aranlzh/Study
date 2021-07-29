package top.aranlzh.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价于 <bean id="user" class="top.aranlzh.pojo.User">
// @Component 组件

@Component
@Scope("singleton")
public class User {

    // 相当于 <property name="name" value="阿然"/>
    @Value("阿然")
    public String name;

    @Value("Spring")
    public void setName(String name) {
        this.name = name;
    }
}
