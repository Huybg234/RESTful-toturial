package repository;

import entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDao {

    private static List<Student> students = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            students.add(new Student(i, "Nguyen Van " + i, new Date(), "CN" + i));
        }
    }

    //    Logger logger = Logger.getLogger(StudentDao.class);
    public List<Student> getAll() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            List<Student> students = session.createQuery("from Student").list();
//            session.getTransaction().commit();
//            return students;
//        } catch (HibernateException e) {
//            session.getTransaction().rollback();
//            logger.error(e);
//        } finally {
//            session.close();
//        }
        return students;
    }

    public Student findById(int id) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            Query<Student> query = session.createQuery("select s from Student s where s.id = :p_student_id");
//            query.setParameter("p_student_id", id);
//            Student student = query.getSingleResult();
//            session.getTransaction().commit();
//            return student;
//        } catch (HibernateException e) {
//            session.getTransaction().rollback();
//            logger.error(e);
//        } finally {
//            session.close();
//        }
        List<Student> studentList = students.stream().filter(student -> student.getId() == id).collect(Collectors.toList());
        return students != null && studentList.isEmpty() ? null : studentList.get(0);
    }

    public boolean insert(Student student) {
        if (student == null) {
            return false;
        }
        students.add(student);
        return true;
    }

    public boolean removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        return true;
    }
}
