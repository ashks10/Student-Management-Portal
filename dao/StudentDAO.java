package dao; //DATA ACCESS OBJECT PACKAGE

import model.Student;
import java.util.*;
import java.io.*;

public class StudentDAO {
    private static final String FILE_NAME = "Student.txt";

    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            students = (List<Student>) ois.readObject();
        }catch (FileNotFoundException e){
            //Ignore: file may not run on first run
        }catch (IOException | ClassNotFoundException e){
            System.err.println("Error Reading Student file : " +e.getMessage());
        }
        return students;
    }

    //Writing the student list to the file
    public void saveStudents(List<Student> students){
         try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
             oos.writeObject(students);
         }catch (IOException e){
             System.err.println("Error Writing Students file : " + e.getMessage());
         }
    }
}
