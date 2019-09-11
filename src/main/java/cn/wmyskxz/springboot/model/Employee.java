package cn.wmyskxz.springboot.model;

public class Employee {
    private String name;
    private String position;
    private String power;
    private String password;

    public Employee() {

    }

    public Employee(String power, String position, String password, String name) {
        this.name = name;
        this.position = position;
        this.power = power;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getPassword(){return password;}
    public void setPassword(String password){ this.password = password == null ? null :password.trim();}

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", power='" + power + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}