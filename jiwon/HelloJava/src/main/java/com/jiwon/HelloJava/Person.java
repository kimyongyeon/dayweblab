package com.jiwon.HelloJava;

public class Person {
    private String name;
    private int age;
    private String address;
    private String job;

    @Override
    public String toString() {
        return "Person{" +
                "String=" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public Person(String name, int age, String address, String job){
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getJob(){
        return job;
    }

    public void setJob(String job){
        this.job = job;
    }

}
