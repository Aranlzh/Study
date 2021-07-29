package top.aranlzh.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class People implements Animal{

    private String name;

    // @Autowired:byType，加@Qualifier(value = "xx")指定
    // @Resource:先byName，后byType，加(name="xx")指定

//    @Autowired
//    @Qualifier(value = "cat1")
    @Resource
    private Cat cat;
    @Autowired
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                ", dog=" + dog +
                '}';
    }

    public void shout() {
        System.out.println("猫狗双全，人生赢家非我莫属");
    }
}
