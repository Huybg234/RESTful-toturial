package service;

import entity.Student;
import repository.StudentDao;

import java.util.Comparator;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        studentDao.getAll().sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() < o2.getId() ? 1 : -1;
            }
        });
        int id = studentDao.getAll().get(0).getId() + 1;

        String fullName = "Nguyen Huy";
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String className = "cn06";
        student = new Student(id, fullName, birthday, className);
        return studentDao.insert(student);
    }

    public boolean removeStudent(int id) {
        return studentDao.removeStudent(id);
    }

}
