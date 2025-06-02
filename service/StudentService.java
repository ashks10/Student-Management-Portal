package service;

import dao.StudentDAO;
import model.Student;

import java.util.*;

public class StudentService {
    private List<Student> students;
    private StudentDAO studentDAO;

    public StudentService(){
        studentDAO = new StudentDAO();
        students = studentDAO.loadStudents();
    }

    public void addStudent(Student student){
        students.add(student);
        studentDAO.saveStudents(students);
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student searchStudentById(String id){
        for(Student student: students){
            if(student.getId().equalsIgnoreCase(id)){
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudentById(String id){
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getId().equalsIgnoreCase(id)){
                iterator.remove();
                studentDAO.saveStudents(students);
                return true;
            }
        }
        return false;
    }

}
