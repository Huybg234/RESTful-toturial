package service;

import entity.Student;
import repository.StudentDao;

import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();

    public List<Student> getListStudent() {
        return studentDao.getListStudent();
    }

}
