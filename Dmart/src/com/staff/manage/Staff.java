package com.staff.manage;

public class Staff {
    private String name;
    private int age;
    private String city;
    private int id;

    private long phone;
    private long salary;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCity() {
        return city;
    }
    public int getId() {
        return id;
    }
    public long getPhone() {
        return phone;
    }
    public long getSalary() {
        return salary;
    }


    public Staff(String name, int age, String city,int id, long phone, long salary) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.id= id;
        this.phone = phone;
        this.salary = salary;
    }
    public Staff(){}

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                '}';
    }
}
