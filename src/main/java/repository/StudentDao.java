package repository;

import entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDao {

    public List<Student> getListStudent() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(i, "Nguyen Van " + i, new Date(), "CN" + i));
        }
        return students;
    }

}
