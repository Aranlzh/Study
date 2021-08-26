package top.aranlzh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("pets1")
public class PetsListConfig {
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
