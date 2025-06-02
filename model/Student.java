package model;

import java.io.Serializable;

public class Student implements Serializable{
    private String id;
    private String name;
    private int age;
    private String course;

    public Student (String id , String name , int age , String course){
        this.id=id;
        this.name=name;
        this.age=age;
        this.course=course;
    }

    public String getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){ return age; }
    public String getCourse(){
        return course;
    }

    public void setId(String id) { this.id = id; }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCourse(String course){
        this.course = course;
    }

    @Override
    public String toString(){
        return String.format("ID: %s | Name: %s | Age: %d | Course: %s", id,name,age,course);
    }
}
