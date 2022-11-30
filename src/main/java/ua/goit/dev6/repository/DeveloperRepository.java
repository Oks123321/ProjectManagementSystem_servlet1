package ua.goit.dev6.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.dev6.config.HibernateProvider;
import ua.goit.dev6.model.dao.DeveloperDao;

import java.util.List;
import java.util.Optional;


public class DeveloperRepository implements Repository<DeveloperDao> {
    private final HibernateProvider manager;

    public DeveloperRepository(HibernateProvider manager) {
        this.manager = manager;
    }

    @Override
    public DeveloperDao save(DeveloperDao entity) {
        try (Session session = manager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Developer not created");
        }
        return entity;
    }

    @Override
    public void delete(DeveloperDao entity) {
        try (Session session = manager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Delete developer failed");
        }
    }

    @Override
    public Optional<DeveloperDao> findById(Long id) {
        try (Session session = manager.openSession()) {
            return Optional.ofNullable(session.byId(DeveloperDao.class).load(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Find developer by id failed");
        }
    }

    @Override
    public DeveloperDao update(DeveloperDao entity) {
        try (Session session = manager.openSession()) {
            session.beginTransaction();
            DeveloperDao updated = session.merge(entity);
            session.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Developer not updated");
        }
    }

    @Override
    public List<DeveloperDao> findAll() {
        try (Session session = manager.openSession()) {
            return session.createQuery("from DeveloperDao", DeveloperDao.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Find all customers failed");
        }
    }

    @Override
    public List<DeveloperDao> findByListOfID(List<Long> idList) {
        try (Session session = manager.openSession()) {
            return session.byMultipleIds(DeveloperDao.class).multiLoad(idList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Find all developers failed");
        }
    }

}

