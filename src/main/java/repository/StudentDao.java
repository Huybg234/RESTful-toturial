package repository;

import entity.Student;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import java.util.List;

public class StudentDao {

    Logger logger = Logger.getLogger(StudentDao.class);
    public List<Student> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").list();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    public Student findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery("select s from Student s where s.id = :p_student_id");
            query.setParameter("p_student_id", id);
            Student student = query.getSingleResult();
            session.getTransaction().commit();
            return student;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }
}
