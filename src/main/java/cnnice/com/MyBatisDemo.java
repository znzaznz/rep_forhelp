package cnnice.com;

public class MyBatisDemo {
    private String name;
    private int age;
    private int id;

    public MyBatisDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyBatisDemo() {
    }

    @Override
    public String toString() {
        return "MyBatisDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
