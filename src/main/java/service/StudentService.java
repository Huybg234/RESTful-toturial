package service;

import entity.Student;
import repository.StudentDao;

import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();

    public List<Student> getListStudent() {
        return studentDao.getAll();
    }

    public Student findID(int id) {
        return studentDao.findById(id);
    }

    public boolean insert(Student student) {
        return studentDao.insert(student);
    }

    public boolean removeStudent(int id) {
        return studentDao.removeStudent(id);
    }

}
