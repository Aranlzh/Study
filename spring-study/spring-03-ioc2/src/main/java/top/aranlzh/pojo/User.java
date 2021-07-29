package top.aranlzh.pojo;

public class User {
    private String name;
    private Integer age;

//    public User() {
//        System.out.println("User的无参构造");
//    }

    public User(String name, Integer age) {
        System.out.println("User的有参构造");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void show() {
        System.out.println("name="+name+",age="+age);
    }
}
