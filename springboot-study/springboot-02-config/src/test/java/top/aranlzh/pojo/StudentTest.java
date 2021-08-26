package top.aranlzh.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.aranlzh.config.PetsListConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentTest {

    @Autowired
    private Student student;

    @Autowired
    private PetsListConfig petsListConfig;

    @Test
    void contextLoads() {
        System.out.println(student);
        System.out.println(petsListConfig.getList());
    }
}