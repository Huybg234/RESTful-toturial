package repository;

import entity.Subject;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;

public class SubjectDao {

    Logger logger = Logger.getLogger(StudentDao.class);
    public List<Subject> getAllSubject() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Subject> subject = session.createQuery("from Subject").list();
            session.getTransaction().commit();
            return subject;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }
}
