package top.aranlzh.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Student {

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private Integer age;

    @Value("${student.pets}")
    private String[] pets;

    @Value("${student.pets1:}")
    private String[] pets1;

    public Student() {
    }

    public Student(String name, Integer age, String[] pets, String[] pets1) {
        this.name = name;
        this.age = age;
        this.pets = pets;
        this.pets1 = pets1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getPets() {
        return pets;
    }

    public void setPets(String[] pets) {
        this.pets = pets;
    }

    public String[] getPets1() {
        return pets1;
    }

    public void setPets1(String[] pets1) {
        this.pets1 = pets1;
    }
}
